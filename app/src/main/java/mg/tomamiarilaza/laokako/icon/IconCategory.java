package mg.tomamiarilaza.laokako.icon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class IconCategory {
    // field
    int idIconCategory;
    String category;

    // constructor
    public IconCategory(int idIconCategory, String category) {
        this.idIconCategory = idIconCategory;
        this.category = category;
    }

    public int getIdIconCategory() {
        return idIconCategory;
    }

    public void setIdIconCategory(int idIconCategory) {
        this.idIconCategory = idIconCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // methods
    @NonNull
    public static List<IconCategory> getAllIconCategory() {
        List<IconCategory> iconCategories = new ArrayList<>();

        iconCategories.add(new IconCategory(1, "legume"));
        iconCategories.add(new IconCategory(2, "viande"));
        iconCategories.add(new IconCategory(3, "épice"));
        iconCategories.add(new IconCategory(4, "sauce"));
        iconCategories.add(new IconCategory(5, "poid"));

        return iconCategories;
    }

    @Nullable
    public static IconCategory findByName(String name) {
        List<IconCategory> iconCategories = getAllIconCategory();

        for (IconCategory category : iconCategories) {
            if (category.getCategory().equals(name)) return category;
        }

        return null;
    }
}
