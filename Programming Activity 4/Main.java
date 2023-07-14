/**
Author: Joshua Timothy O. Clet
BSCS 3rd Year

The Main class demonstrates the usage of different number systems.
 */

public class Main {
    public static void main(String[] args) {
        NumberSystem[] numberSystems = {
            new BinaryNumberSystem("1010"),
            new OctalNumberSystem("753"),
            new DecimalNumberSystem("1234"),
            new HexadecimalNumberSystem("ABC")
        };

        int newBase = 7;

        for (NumberSystem numberSystem : numberSystems) {
            String numberSystemType = numberSystem.getNumberSystemType();
            System.out.println("Number System: " + numberSystemType);
            
            System.out.println("Original Number: " + numberSystem.toString());

            String convertedValue = numberSystem.convertTo(numberSystem.getValue(), newBase);
            System.out.println("Converted to base " + newBase + ": " + convertedValue);

            boolean isValid = numberSystem.isValidNumber();
            System.out.println("Is a valid number? " + isValid);

            System.out.println();
        }
    }
}
