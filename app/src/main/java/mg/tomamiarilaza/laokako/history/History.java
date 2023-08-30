package mg.tomamiarilaza.laokako.history;

import android.os.Build;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mg.tomamiarilaza.laokako.menu.Menu;

public class History {
    // field
    int id;
    Menu menu;
    String date;

    // constructor

    public History(int id, Menu menu, String date) {
        this.id = id;
        this.menu = menu;
        this.date = date;
    }

    public History(Menu menu, String date) {
        this.menu = menu;
        this.date = date;
    }

    // encapsulation

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // methods

    // To get all histories ordered last on first we use id
    public static List<History> getAllHistories() {
        List<History> histories = new ArrayList<>();

        histories.add(new History(10, Menu.findByName("Atody"), "2023-08-20 07:00"));
        histories.add(new History(9, Menu.findByName("Anana sy totokena"), "2023-08-20 10:00"));
        histories.add(new History(8, Menu.findByName("Karoty sy kisoa"), "2023-08-20 15:00"));
        histories.add(new History(7, Menu.findByName("Ravimbomanga"), "2023-08-21 05:00"));
        histories.add(new History(6, Menu.findByName("Anamamy sy Hena omby"), "2023-08-21 11:30"));
        histories.add(new History(5, Menu.findByName("Sambos"), "2023-08-21 16:00"));
        histories.add(new History(4, Menu.findByName("Karoty sy kisoa"), "2023-08-22 10:00"));
        histories.add(new History(3, Menu.findByName("Kitoza"), "2023-08-22 13:20"));
        histories.add(new History(2, Menu.findByName("Anana sy totokena"), "2023-08-23 12:00"));
        histories.add(new History(1, Menu.findByName("Ravimbomanga"), "2023-08-23 18:00"));

        return histories;
    }

    // get ten last histories if there is ten histories
    public static List<History> getLastHistories() {
        List<History> histories = History.getAllHistories();    // already ordered
        List<History> tenLastHistories = new ArrayList<>();

        int number = 10;
        if (histories.size() < 10) number = histories.size();

        for (int i = 0; i < number; i++) {
            tenLastHistories.add(histories.get(i));
        }

        return tenLastHistories;
    }

}
