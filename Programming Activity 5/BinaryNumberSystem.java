public class BinaryNumberSystem implements NumberSystem {
    @Override
    public String convertNumber(int number) {
        return Integer.toBinaryString(number);
    }

    @Override
    public String getName() {
        return "Binary";
    }
}
