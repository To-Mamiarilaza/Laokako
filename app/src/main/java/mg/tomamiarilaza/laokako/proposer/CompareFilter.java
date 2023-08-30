package mg.tomamiarilaza.laokako.proposer;

public class CompareFilter {
    // field
    boolean state;
    double value;
    int compareUnit; // -1 or 1

    // constructor
    public CompareFilter(boolean state, double value, int compareUnit) {
        this.state = state;
        this.value = value;
        this.compareUnit = compareUnit;
    }

    // encapsulation

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCompareUnit() {
        return compareUnit;
    }

    public void setCompareUnit(int compareUnit) {
        this.compareUnit = compareUnit;
    }
}
