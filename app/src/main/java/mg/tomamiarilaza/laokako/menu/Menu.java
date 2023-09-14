package mg.tomamiarilaza.laokako.menu;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import mg.tomamiarilaza.laokako.parameter.Parameter;

public class Menu {
    // field
    int id;
    String name;
    int duration;   // Cooking duration
    double rate;   // from 0 to 5
    String recipe;
    boolean[] specificity;  // morning, noon, evening
    String frontPicture;
    String backPicture;
    List<IngredientQuantity> ingredients;

    // constructor

    public Menu(int id, String name, int duration, double rate, String recipe, boolean[] specificity, String frontPicture, String backPicture, List<IngredientQuantity> ingredients) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.rate = rate;
        this.recipe = recipe;
        this.specificity = specificity;
        this.frontPicture = frontPicture;
        this.backPicture = backPicture;
        this.ingredients = ingredients;
    }

    public Menu(String name, int duration, int rate, String recipe, boolean[] specificity, String frontPicture, String backPicture, List<IngredientQuantity> ingredients) {
        this.name = name;
        this.duration = duration;
        this.rate = rate;
        this.recipe = recipe;
        this.specificity = specificity;
        this.frontPicture = frontPicture;
        this.backPicture = backPicture;
        this.ingredients = ingredients;
    }

    // encapsulation

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public boolean[] getSpecificity() {
        return specificity;
    }

    public void setSpecificity(boolean[] specificity) {
        this.specificity = specificity;
    }

    public String getFrontPicture() {
        return frontPicture;
    }

    public void setFrontPicture(String frontPicture) {
        this.frontPicture = frontPicture;
    }

    public String getBackPicture() {
        return backPicture;
    }

    public void setBackPicture(String backPicture) {
        this.backPicture = backPicture;
    }

    public List<IngredientQuantity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientQuantity> ingredients) {
        this.ingredients = ingredients;
    }

    // methods
    public static List<Menu> getAllMenu() {
        List<Menu> menus = new ArrayList<>();

        int id1 = 1;
        String name1 = "Anana sy totokena";
        int duration1 = 20;
        double rate1 = 2.5;
        String recipe1 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity1 = new boolean[] {false, true, true};
        String frontPicture1 = "crevette";
        String backPicture1 = "carotte";
        List<IngredientQuantity> ingredientQuantities1 = new ArrayList<>();
        ingredientQuantities1.add(new IngredientQuantity(Ingredient.findByName("Anana"), 500, true));
        ingredientQuantities1.add(new IngredientQuantity(Ingredient.findByName("Totokena"), 1000, true));
        ingredientQuantities1.add(new IngredientQuantity(Ingredient.findByName("Voatabia"), 200, false));
        ingredientQuantities1.add(new IngredientQuantity(Ingredient.findByName("Tongolo"), 200, false));
        menus.add(new Menu(id1, name1, duration1, rate1, recipe1, specificity1, frontPicture1, backPicture1, ingredientQuantities1));

        int id2 = 2;
        String name2 = "Atody";
        int duration2 = 15;
        double rate2 = 3.5;
        String recipe2 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity2 = new boolean[] {true, false, true};
        String frontPicture2 = "carotte";
        String backPicture2 = "crevette";
        List<IngredientQuantity> ingredientQuantities2 = new ArrayList<>();
        ingredientQuantities2.add(new IngredientQuantity(Ingredient.findByName("Atody"), 800, true));
        menus.add(new Menu(id2, name2, duration2, rate2, recipe2, specificity2, frontPicture2, backPicture2, ingredientQuantities2));

        int id3 = 3;
        String name3 = "Karoty sy kisoa";
        int duration3 = 25;
        double rate3 = 4;
        String recipe3 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity3 = new boolean[] {true, true, true};
        String frontPicture3 = "carotte";
        String backPicture3 = "crevette";
        List<IngredientQuantity> ingredientQuantities3 = new ArrayList<>();
        ingredientQuantities3.add(new IngredientQuantity(Ingredient.findByName("Karoty"), 500, true));
        ingredientQuantities3.add(new IngredientQuantity(Ingredient.findByName("Hena kisoa"), 1000, true));
        ingredientQuantities3.add(new IngredientQuantity(Ingredient.findByName("Percil"), 100, false));
        ingredientQuantities3.add(new IngredientQuantity(Ingredient.findByName("Tongolo"), 200, false));
        ingredientQuantities3.add(new IngredientQuantity(Ingredient.findByName("Voatabia"), 200, false));
        menus.add(new Menu(id3, name3, duration3, rate3, recipe3, specificity3, frontPicture3, backPicture3, ingredientQuantities3));

        int id4 = 4;
        String name4 = "Kitoza";
        int duration4 = 15;
        double rate4 = 3.5;
        String recipe4 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity4 = new boolean[] {true, false, true};
        String frontPicture4 = "carotte";
        String backPicture4 = "crevette";
        List<IngredientQuantity> ingredientQuantities4 = new ArrayList<>();
        ingredientQuantities4.add(new IngredientQuantity(Ingredient.findByName("Kitoza"), 1000, true));
        menus.add(new Menu(id4, name4, duration4, rate4, recipe4, specificity4, frontPicture4, backPicture4, ingredientQuantities4));

        int id5 = 5;
        String name5 = "Ravimbomanga";
        int duration5 = 20;
        double rate5 = 4;
        String recipe5 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity5 = new boolean[] {true, false, true};
        String frontPicture5 = "crevette";
        String backPicture5 = "carotte";
        List<IngredientQuantity> ingredientQuantities5 = new ArrayList<>();
        ingredientQuantities5.add(new IngredientQuantity(Ingredient.findByName("Ravimbomanga"), 500, true));
        ingredientQuantities5.add(new IngredientQuantity(Ingredient.findByName("Voatabia"), 200, false));
        ingredientQuantities5.add(new IngredientQuantity(Ingredient.findByName("Tongolo"), 200, false));
        menus.add(new Menu(id5, name5, duration5, rate5, recipe5, specificity5, frontPicture5, backPicture5, ingredientQuantities5));

        int id6 = 6;
        String name6 = "Anamamy sy Hena omby";
        int duration6 = 30;
        double rate6 = 4.5;
        String recipe6 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity6 = new boolean[] {false, true, true};
        String frontPicture6 = "crevette";
        String backPicture6 = "carotte";
        List<IngredientQuantity> ingredientQuantities6 = new ArrayList<>();
        ingredientQuantities6.add(new IngredientQuantity(Ingredient.findByName("Anamamy"), 500, true));
        ingredientQuantities6.add(new IngredientQuantity(Ingredient.findByName("Hena omby"), 200, true));
        menus.add(new Menu(id6, name6, duration6, rate6, recipe6, specificity6, frontPicture6, backPicture6, ingredientQuantities6));

        int id7 = 7;
        String name7 = "Sambos";
        int duration7 = 10;
        double rate7 = 4;
        String recipe7 = "Voila etape 1 // Voila etape 2 // Voila etape 3";
        boolean[] specificity7 = new boolean[] {true, false, false};
        String frontPicture7 = "carotte";
        String backPicture7 = "crevette";
        List<IngredientQuantity> ingredientQuantities7 = new ArrayList<>();
        ingredientQuantities7.add(new IngredientQuantity(Ingredient.findByName("Sambos"), 600, true));
        menus.add(new Menu(id7, name7, duration7, rate7, recipe7, specificity7, frontPicture7, backPicture7, ingredientQuantities7));

        return menus;
    }

    @Nullable
    public static Menu findByName(String menuName) {
        List<Menu> menus = Menu.getAllMenu();
        for (Menu menu: menus) {
            if (menu.getName().equals(menuName)) return menu;
        }
        return null;
    }

    public boolean contain(Ingredient otherIngredient) {
        for (IngredientQuantity selfIngredient: getIngredients()) {
            if (selfIngredient.getIngredient().getId() == otherIngredient.getId() && selfIngredient.isPrincipal()) {
                return true;
            }
        }
        return false;
    }

    // calculate the price of the menu
    public double getPrice() {
        double total = 0;
        for (IngredientQuantity ingredient: getIngredients()) {
            total += ingredient.getPrice();
        }
        total *= Parameter.nbPerson;
        total += total * (((double) Parameter.inflation * 50 / 5) / 100);    // 5 is the max value of inflation

        return total;
    }
}
