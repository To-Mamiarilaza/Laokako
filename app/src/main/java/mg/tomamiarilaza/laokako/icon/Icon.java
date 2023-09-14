package mg.tomamiarilaza.laokako.icon;

import java.util.ArrayList;
import java.util.List;

public class Icon {
    // field
    int idIcon;
    String iconName;
    IconCategory category;

    // constructor
    public Icon(int idIcon, String iconName, IconCategory category) {
        this.idIcon = idIcon;
        this.iconName = iconName;
        this.category = category;
    }

    // getter and setter

    public int getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(int idIcon) {
        this.idIcon = idIcon;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public IconCategory getCategory() {
        return category;
    }

    public void setCategory(IconCategory category) {
        this.category = category;
    }

    // methods
    public static List<Icon> getAllIcon() {
        List<Icon> icons = new ArrayList<>();

        icons.add(new Icon(1, "tomato_ico", IconCategory.findByName("legume")));
        icons.add(new Icon(2, "green_parsley", IconCategory.findByName("legume")));

        return icons;
    }

    public static Icon findByName(String name) {
        List<Icon> icons = getAllIcon();

        for (Icon icon : icons) {
            if (icon.getIconName().equals(name)) return icon;
        }

        return null;
    }
}
