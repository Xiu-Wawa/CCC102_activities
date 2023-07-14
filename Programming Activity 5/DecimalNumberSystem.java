import javax.swing.*;

public class DecimalNumberSystem implements NumberSystem {
    @Override
    public String convertNumber(int number) {
        return Integer.toString(number);
    }

    @Override
    public String getName() {
        return "Decimal";
    }

    public static JComboBox<NumberSystem> createComboBox() {
        return new JComboBox<>(new NumberSystem[]{new DecimalNumberSystem()});
    }
}
