package mg.tomamiarilaza.laokako.menu;

public class IngredientQuantity {
    // field
    Ingredient ingredient;
    double price;
    boolean isPrincipal;

    // constructor
    public IngredientQuantity(Ingredient ingredient, double price, boolean isPrincipal) {
        this.ingredient = ingredient;
        this.price = price;
        this.isPrincipal = isPrincipal;
    }

    // encapsulation

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPrincipal() {
        return isPrincipal;
    }

    public void setPrincipal(boolean principal) {
        isPrincipal = principal;
    }

    // methods

}
