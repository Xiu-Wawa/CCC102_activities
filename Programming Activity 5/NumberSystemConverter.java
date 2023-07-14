public class NumberSystemConverter {
    private int min;
    private int max;
    private NumberSystem numberSystem;
    private StringBuilder resultBuilder;

    public NumberSystemConverter(int min, int max, NumberSystem numberSystem) {
        this.min = min;
        this.max = max;
        this.numberSystem = numberSystem;
        this.resultBuilder = new StringBuilder();
    }

    public void convert() {
        for (int i = min; i <= max; i++) {
            String convertedNumber = numberSystem.convertNumber(i);
            resultBuilder.append(i).append(" (Decimal) -> ").append(convertedNumber).append(" (").append(numberSystem.getName()).append(")").append("\n");
        }
    }

    public String getResult() {
        return resultBuilder.toString();
    }
}
