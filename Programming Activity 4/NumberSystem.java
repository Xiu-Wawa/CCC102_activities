/**
Author: Joshua Timothy O. Clet
BSCS 3rd Year

The NumberSystem abstract class represents a number system and provides methods to convert values,
validate numbers, and retrieve the string representation of the number system.
 */

public abstract class NumberSystem {
    protected String value;
    protected int base;

    public NumberSystem(String value, int base) {
        this.value = value;
        this.base = base;
    }

    public abstract String convertTo(String valueToConvert, int newBase);
    public abstract boolean isValidNumber();
    public abstract String toString();
    public abstract String getNumberSystemType();
    

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
