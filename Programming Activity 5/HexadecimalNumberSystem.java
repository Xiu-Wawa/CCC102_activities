public class HexadecimalNumberSystem implements NumberSystem {
    @Override
    public String convertNumber(int number) {
        return Integer.toHexString(number);
    }

    @Override
    public String getName() {
        return "Hexadecimal";
    }
}
