package mg.tomamiarilaza.laokako.menu;

import java.util.ArrayList;
import java.util.List;

import mg.tomamiarilaza.laokako.icon.Icon;

public class Ingredient {
    // field
    int id;
    String name;
    Icon icon;

    // constructor

    public Ingredient(int id, String name, Icon icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Ingredient(String name, Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    public Ingredient() {
        this.id = id;
        this.name = name;
        this.icon = icon;
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

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    // methods
    public static List<Ingredient> getAllIngredient() {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient(1, "Anana", Icon.findByName("green_parsley")));
        ingredients.add(new Ingredient(2, "Totokena", Icon.findByName("tomato_ico")));
        ingredients.add(new Ingredient(3, "Atody", Icon.findByName("green_parsley")));
        ingredients.add(new Ingredient(4, "Karoty", Icon.findByName("tomato_ico")));
        ingredients.add(new Ingredient(5, "Hena kisoa", Icon.findByName("green_parsley")));
        ingredients.add(new Ingredient(6, "Kitoza", Icon.findByName("tomato_ico")));
        ingredients.add(new Ingredient(7, "Voatabia", Icon.findByName("green_parsley")));
        ingredients.add(new Ingredient(8, "Tongolo", Icon.findByName("tomato_ico")));
        ingredients.add(new Ingredient(9, "Ravimbomanga", Icon.findByName("green_parsley")));
        ingredients.add(new Ingredient(10, "Anamamy", Icon.findByName("tomato_ico")));
        ingredients.add(new Ingredient(11, "Hena omby", Icon.findByName("green_parsley")));
        ingredients.add(new Ingredient(12, "Sambos", Icon.findByName("tomato_ico")));
        ingredients.add(new Ingredient(13, "Percil", Icon.findByName("green_parsley")));

        return ingredients;
    }

    public static Ingredient findByName(String ingredientName) {
        List<Ingredient> ingredients = Ingredient.getAllIngredient();
        for (Ingredient ingredient: ingredients) {
            if (ingredient.getName().equals(ingredientName)) return ingredient;
        }
        return null;
    }

}
