import javax.swing.*;

public class NumberSystemConverterGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NumberSystemConverterFrame converterFrame = new NumberSystemConverterFrame();
            converterFrame.setVisible(true);
        });
    }
}
