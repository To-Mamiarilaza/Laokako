package mg.tomamiarilaza.laokako.proposer;

import mg.tomamiarilaza.laokako.menu.Menu;

public class MenuScore {
    // field
    Menu menu;
    double score;

    // constructor

    public MenuScore(Menu menu, double score) {
        this.menu = menu;
        this.score = score;
    }

    // encapsulation

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // methods
    public void addScore(double newScore) { this.score += newScore; }
}
