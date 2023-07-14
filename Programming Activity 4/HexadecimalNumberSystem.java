/**
Author: Joshua Timothy O. Clet
BSCS 3rd Year

The HexadecimalNumberSystem class represents the hexadecimal number system.
It extends the NumberSystem abstract class and provides implementation
for converting values, validating numbers, and retrieving the string
representation of the hexadecimal number system.
 */

public class HexadecimalNumberSystem extends NumberSystem {
    public HexadecimalNumberSystem(String value) {
        super(value, 16);
    }

    @Override
    public String convertTo(String valueToConvert, int newBase) {
        int decimalValue = Integer.parseInt(valueToConvert, getBase());
        return Integer.toString(decimalValue, newBase);
    }

    @Override
    public boolean isValidNumber() {
        try {
            Integer.parseInt(getValue(), getBase());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "#" + getBase() + " [" + getValue() + "]";
    }

    @Override
    public String getNumberSystemType() {
        return "Hexadecimal";
    }
}
