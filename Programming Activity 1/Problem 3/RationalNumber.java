/**

Author: Joshua Timothy O. Clet
BSCS 3rd Year

The RationalNumber class represents a rational number as a fraction of two integers, with methods to perform arithmetic operations.
It provides methods to convert the rational number to simplest form, compare two rational numbers, and determine if a rational number is valid.
The class also has a method to find the reciprocal of the rational number and a private method to compute the greatest common divisor (GCD) of two integers.

*/

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double toDouble() {
        return (double)numerator / denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public RationalNumber toSimplestForm() {
        int gcd = gcd(numerator, denominator);
        return new RationalNumber(numerator / gcd, denominator / gcd);
    }

    public int compareTo(RationalNumber other) {
        int num1 = numerator * other.denominator;
        int num2 = other.numerator * denominator;

        if (num1 > num2) {
            return 1;
        } 
        else if (num1 < num2) {
            return -1;
        } 
        else {
            return 0;
        }
    }

    public RationalNumber add(RationalNumber other) {
        int num = numerator * other.denominator + other.numerator * denominator;
        int denom = denominator * other.denominator;
        return new RationalNumber(num, denom);
    }

    public RationalNumber multiply(RationalNumber other) {
        int num = numerator * other.numerator;
        int denom = denominator * other.denominator;
        return new RationalNumber(num, denom);
    }

    public RationalNumber subtract(RationalNumber other) {
        int num = numerator * other.denominator - other.numerator * denominator;
        int denom = denominator * other.denominator;
        return new RationalNumber(num, denom);
    }

    public RationalNumber divides(RationalNumber other) {
        int num = numerator * other.denominator;
        int denom = denominator * other.numerator;
        return new RationalNumber(num, denom);
    }

    public static boolean isValid(RationalNumber rn) {
        return rn.getDenominator() != 0;
    }

    public RationalNumber reciprocal() {
        return new RationalNumber(denominator, numerator);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
