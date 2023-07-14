public class OctalNumberSystem implements NumberSystem {
    @Override
    public String convertNumber(int number) {
        return Integer.toOctalString(number);
    }

    @Override
    public String getName() {
        return "Octal";
    }
}
