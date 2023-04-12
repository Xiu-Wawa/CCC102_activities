public class Main {
    public static void main(String[] args) {
        // Create two RationalNumber objects
        RationalNumber r1 = new RationalNumber(3, 0);
        RationalNumber r2 = new RationalNumber(1, 2);
        
        // Print out the values of the RationalNumber objects
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);

        // Check Validity
        System.out.println("r1 Validity: " + RationalNumber.isValid(r1));
        System.out.println("r2 Validity: " + RationalNumber.isValid(r2));

        // Reciprocal
        System.out.println("Reciprocal of r1: " + r1.reciprocal());
        System.out.println("Reciprocal of r2: " + r2.reciprocal());
        
        // Add the two RationalNumber objects together and print out the result
        RationalNumber sum = r1.add(r2);
        System.out.println("Sum: " + sum);
        
        // Multiply the two RationalNumber objects together and print out the result
        RationalNumber product = r1.multiply(r2);
        System.out.println("Product: " + product);
        
        // Subtract the two RationalNumber objects and print out the result
        RationalNumber difference = r1.subtract(r2);
        System.out.println("Difference: " + difference);
        
        // Divide the two RationalNumber objects and print out the result
        RationalNumber quotient = r1.divides(r2);
        System.out.println("Quotient: " + quotient);
        
        // Compare the two RationalNumber objects and print out the result
        int compareResult = r1.compareTo(r2);
        if (compareResult == 0) {
            System.out.println("Comaprison: r1 and r2 are equal.");
        } else if (compareResult < 0) {
            System.out.println("Comparison: r1 is less than r2.");
        } else {
            System.out.println("Comparison: r1 is greater than r2.");
        }

    }
}
