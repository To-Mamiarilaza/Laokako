package mg.tomamiarilaza.laokako.menu;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    // field
    int id;
    String name;
    String icon;

    // constructor

    public Ingredient(int id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public Ingredient(String name, String icon) {
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    // methods
    public static List<Ingredient> getAllIngredient() {
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient(1, "Anana", "anana.ico"));
        ingredients.add(new Ingredient(2, "Totokena", "totokena.ico"));
        ingredients.add(new Ingredient(3, "Atody", "atody.ico"));
        ingredients.add(new Ingredient(4, "Karoty", "karoty.ico"));
        ingredients.add(new Ingredient(5, "Hena kisoa", "hena_kisoa.ico"));
        ingredients.add(new Ingredient(6, "Kitoza", "kitoza.ico"));
        ingredients.add(new Ingredient(7, "Voatabia", "voatabia.ico"));
        ingredients.add(new Ingredient(8, "Tongolo", "tongolo.ico"));
        ingredients.add(new Ingredient(9, "Ravimbomanga", "ravimbomanga.ico"));
        ingredients.add(new Ingredient(10, "Anamamy", "anamamy.ico"));
        ingredients.add(new Ingredient(11, "Hena omby", "hena_omby.ico"));
        ingredients.add(new Ingredient(12, "Sambos", "sambos.ico"));
        ingredients.add(new Ingredient(13, "Percil", "percil.ico"));

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
