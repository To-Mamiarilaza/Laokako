package mg.tomamiarilaza.laokako.proposer;

import mg.tomamiarilaza.laokako.menu.Ingredient;
import mg.tomamiarilaza.laokako.menu.Menu;

public class Filter {
    // field
    CompareFilter priceFilter;
    CompareFilter durationFilter;
    CompareFilter rateFilter;
    Ingredient existingIngredient;
    Ingredient notExistingIngredient;

    // constructor

    public Filter() {
    }

    public Filter(CompareFilter priceFilter, CompareFilter durationFilter, CompareFilter rateFilter, Ingredient existingIngredient, Ingredient notExistingIngredient) {
        this.priceFilter = priceFilter;
        this.durationFilter = durationFilter;
        this.rateFilter = rateFilter;
        this.existingIngredient = existingIngredient;
        this.notExistingIngredient = notExistingIngredient;
    }

    // encapsulation

    public CompareFilter getPriceFilter() {
        return priceFilter;
    }

    public void setPriceFilter(CompareFilter priceFilter) {
        this.priceFilter = priceFilter;
    }

    public CompareFilter getDurationFilter() {
        return durationFilter;
    }

    public void setDurationFilter(CompareFilter durationFilter) {
        this.durationFilter = durationFilter;
    }

    public CompareFilter getRateFilter() {
        return rateFilter;
    }

    public void setRateFilter(CompareFilter rateFilter) {
        this.rateFilter = rateFilter;
    }

    public Ingredient getExistingIngredient() {
        return existingIngredient;
    }

    public void setExistingIngredient(Ingredient existingIngredient) {
        this.existingIngredient = existingIngredient;
    }

    public Ingredient getNotExistingIngredient() {
        return notExistingIngredient;
    }

    public void setNotExistingIngredient(Ingredient notExistingIngredient) {
        this.notExistingIngredient = notExistingIngredient;
    }

    // methods
    public void addPriceFilter(boolean state, double value, int compareUnit) {
        if (getPriceFilter() != null) {
            getPriceFilter().setState(state);
            getPriceFilter().setValue(value);
            getPriceFilter().setCompareUnit(compareUnit);
        } else {
            setPriceFilter(new CompareFilter(state, value, compareUnit));   // compare Unit -1 inferior 1 superior
        }
    }

    public void addDurationFilter(boolean state, double value, int compareUnit) {
        if (getDurationFilter() != null) {
            getDurationFilter().setState(state);
            getDurationFilter().setValue(value);
            getDurationFilter().setCompareUnit(compareUnit);
        } else {
            setDurationFilter(new CompareFilter(state, value, compareUnit));   // compare Unit -1 inferior 1 superior
        }
    }

    public void addRateFilter(boolean state, double value, int compareUnit) {
        if (getRateFilter() != null) {
            getRateFilter().setState(state);
            getRateFilter().setValue(value);
            getRateFilter().setCompareUnit(compareUnit);
        } else {
            setRateFilter(new CompareFilter(state, value, compareUnit));   // compare Unit -1 inferior 1 superior
        }
    }

    public void  addExistingIngredient(Ingredient ingredient) {
        setExistingIngredient(ingredient);
    }

    public void addNotExistingIngredient(Ingredient ingredient) {
        setNotExistingIngredient(ingredient);
    }

    public boolean checkMenuValidity(Menu menu) {
        // return false if menu not valid
        if (!checkPriceFilter(menu) || !checkDurationFilter(menu) || !checkRateFilter(menu) || !checkExistingIngredient(menu) || !checkNotExistingIngredient(menu)) {
            return false;
        }
        return true;
    }

    // if the menu contain the ingredient return false
    private boolean checkNotExistingIngredient(Menu menu) {
        if (getNotExistingIngredient() != null && menu.contain(getNotExistingIngredient())) {
            return false;
        }
        return true;
    }

    // check if the menu contains an ingredient
    private boolean checkExistingIngredient(Menu menu) {
        if (getExistingIngredient() == null) return true;
        if (menu.contain(getExistingIngredient())) {
            return true;
        }
        return false;
    }

    private boolean checkRateFilter(Menu menu) {
        if (getRateFilter() != null && getRateFilter().getState()) {
            if (getRateFilter().getCompareUnit() == -1 && menu.getRate() >= getRateFilter().getValue()) {
                return false;
            }
            else if (getRateFilter().getCompareUnit() == 1 && menu.getRate() < getRateFilter().getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDurationFilter(Menu menu) {
        if (getDurationFilter() != null && getDurationFilter().getState()) {
            if (getDurationFilter().getCompareUnit() == -1 && menu.getDuration() >= getDurationFilter().getValue()) {
                return false;
            }
            else if (getDurationFilter().getCompareUnit() == 1 && menu.getDuration() < getDurationFilter().getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPriceFilter(Menu menu) {
        if (getPriceFilter() != null && getPriceFilter().getState()) {
            if (getPriceFilter().getCompareUnit() == -1 && menu.getPrice() >= getPriceFilter().getValue()) {
                return false;
            }
            else if (getPriceFilter().getCompareUnit() == 1 && menu.getPrice() < getPriceFilter().getValue()) {
                return false;
            }
        }
        return true;
    }
}
