package mg.tomamiarilaza.laokako.proposer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

import mg.tomamiarilaza.laokako.history.History;
import mg.tomamiarilaza.laokako.menu.Ingredient;
import mg.tomamiarilaza.laokako.menu.Menu;
import mg.tomamiarilaza.laokako.parameter.Parameter;

public class MenuProposer {
    // field
    List<History> histories;    // ten last histories ordered
    Filter filter;
    List<Ingredient> allergicFoods;
    List<Menu> menus;
    List<Menu> selectedMenus;

    // constructor
    public MenuProposer() {
        this.histories = History.getLastHistories();
        this.filter = new Filter();
        this.allergicFoods = Parameter.allergicFoods;
        this.menus = Menu.getAllMenu();
        this.selectedMenus = new ArrayList<>();
    }

    public MenuProposer(List<History> histories, Filter filter, List<Ingredient> allergicFoods, List<Menu> menus, List<Menu> selectedMenus) {
        this.histories = histories;
        this.filter = filter;
        this.allergicFoods = allergicFoods;
        this.menus = menus;
        this.selectedMenus = selectedMenus;
    }

    // encapsulation

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Ingredient> getAllergicFoods() {
        return allergicFoods;
    }

    public void setAllergicFoods(List<Ingredient> allergicFoods) {
        this.allergicFoods = allergicFoods;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getSelectedMenus() {
        return selectedMenus;
    }

    public void setSelectedMenus(List<Menu> selectedMenus) {
        this.selectedMenus = selectedMenus;
    }


    // methods

    // clone the field this.menu
    public List<Menu> getAllClonedMenus() {
        List<Menu> clonedList = new ArrayList<>();
        for (Menu menu: getMenus()) {
            clonedList.add(menu);
        }
        return clonedList;
    }

    // propose two menu  with all parameter
    public Menu[] proposeMenu() {
        Menu[] menuResult = new Menu[2];
        List<Menu> currentMenu = getAllClonedMenus();

        checkAlreadySelectedMenu(currentMenu);  // drop menus already in selected menus
        checkAllergicFood(currentMenu);         // drop menus who contains allergic foods
        checkFilter(currentMenu);               // drop menus who doesn't respond filter

        if (currentMenu.size() < 2 && getSelectedMenus().size() >= 1) {
            getSelectedMenus().clear();         // For giving more choice
            return proposeMenu();
        }

        if (currentMenu.size() == 0) return menuResult;     // If there is no menu valid

        List<MenuScore> menuScores = prepareCurrentMenu(currentMenu);
        for (MenuScore menuScore: menuScores) {
            giveMenuScore(menuScore);     // calculate the score of a menu
        }

        menuResult = getBestMenu(menuResult, menuScores);
        for (Menu menu : menuResult) if (menu != null) getSelectedMenus().add(menu);

        return menuResult;
    }

    private Menu[] getBestMenu(Menu[] menuResult, List<MenuScore> menuScores) {
        // Sort the list of MenuScore
        Collections.sort(menuScores, Comparator.comparingDouble(MenuScore::getScore).reversed());
        for (int i = 0; i < 2; i++) {
            if (menuScores.size() > i) {
                menuResult[i] = menuScores.get(i).getMenu();
            }
        }
        return menuResult;
    }

    private void giveMenuScore(MenuScore menuScore) {
        addHistoryScore(menuScore);
        addRateScore(menuScore);
        addTimeScore(menuScore);
    }

    // Give score by specificity
    private void addTimeScore(MenuScore menuScore) {
        // Get the current time
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // Specificity [ morning, noon, evening ]
        if (hour >= 0 && hour < 9) {
            if (menuScore.getMenu().getSpecificity()[0]) menuScore.addScore(20 * 3);
        } else if (hour >= 9 && hour < 15) {
            if (menuScore.getMenu().getSpecificity()[1]) menuScore.addScore(20 * 3);
        } else {
            if (menuScore.getMenu().getSpecificity()[2]) menuScore.addScore(20 * 3);
        }
    }

    // Give score to the meno due to this rate
    private void addRateScore(MenuScore menuScore) {
        double score = menuScore.getMenu().getRate() * 2;
        menuScore.addScore(score * 2);
    }

    private void addHistoryScore(MenuScore menuScore) {
        double repetitionScore = 10;
        for (History history: getHistories()) {     // The histories is already ordered new to old
            if (history.getMenu().getId() == menuScore.getMenu().getId()) {
                repetitionScore--;
            }
        }

        double distanceScore = 0;                      // The distance from now and the last we choice the menu
        for (History history: getHistories()) {
            if (history.getMenu().getId() != menuScore.getMenu().getId()) {
                distanceScore++;
            } else break;
        }
        if (distanceScore == getHistories().size()) distanceScore = 10;

        double score = (repetitionScore * 3 + distanceScore * 5) / 8;
        menuScore.addScore(score * 6);      // History score is the most important * 6
    }

    private List<MenuScore> prepareCurrentMenu(List<Menu> currentMenu) {
        List<MenuScore> menuScores =  new ArrayList<>();
        for (Menu menu: currentMenu) {
            menuScores.add(new MenuScore(menu, 0));
        }
        return menuScores;
    }

    private void checkFilter(List<Menu> currentMenu) {
        for (int i = 0; i < currentMenu.size(); i++) {
            if (!getFilter().checkMenuValidity(currentMenu.get(i))) {
                currentMenu.remove(i);
                i--;
            }
        }
    }

    private void checkAllergicFood(List<Menu> currentMenu) {
        for (int i = 0; i < currentMenu.size(); i++) {
            for (Ingredient ingredient: getAllergicFoods()) {
                if (currentMenu.get(i).contain(ingredient)) {
                    currentMenu.remove(i);
                    i--;
                }
            }
        }
    }

    private void checkAlreadySelectedMenu(List<Menu> currentMenu) {
        for (int i = 0; i < currentMenu.size(); i++) {
            for (Menu selectedMenu: getSelectedMenus()) {
                if (currentMenu.get(i).getId() == selectedMenu.getId()) {
                    currentMenu.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Ingredient> allergicFoods = new ArrayList<>();

        Parameter.nbPerson = 1;
        Parameter.inflation = 0;
        Parameter.allergicFoods = allergicFoods;


        MenuProposer proposer = new MenuProposer();
        for (int i = 0; i < 10; i++) {
            Menu[] proposition = proposer.proposeMenu();
            System.out.println("Le menu proposé est : " + proposition[0].getName() + " et " + proposition[1].getName());
            System.out.println("Dans le selected menu :");
            for (Menu menu: proposer.getSelectedMenus()) {
                System.out.println("- " + menu.getName());
            }
            System.out.println();
        }
    }
}
