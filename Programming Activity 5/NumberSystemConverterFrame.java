import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConverterFrame extends JFrame implements ActionListener {
    private JTextField minField, maxField;
    private JTextArea octalResultArea, hexadecimalResultArea, binaryResultArea;
    private JButton convertButton;

    public NumberSystemConverterFrame() {
        setTitle("Number System Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        createInputPanel();
        createConvertButton();
        createResultPanel();

        customizeAppearance();

        addComponentsToFrame();

        pack();
        setLocationRelativeTo(null);
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBackground(Color.DARK_GRAY);

        JLabel minLabel = createLabel("Min value:");
        minField = createTextField(10);
        JLabel maxLabel = createLabel("Max value:");
        maxField = createTextField(10);

        inputPanel.add(minLabel);
        inputPanel.add(minField);
        inputPanel.add(maxLabel);
        inputPanel.add(maxField);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void createConvertButton() {
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(convertButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void createResultPanel() {
        JPanel resultPanel = new JPanel(new GridLayout(1, 3));
        resultPanel.setBackground(Color.DARK_GRAY);

        octalResultArea = createResultArea();
        hexadecimalResultArea = createResultArea();
        binaryResultArea = createResultArea();

        resultPanel.add(createResultSubPanel("Octal", octalResultArea));
        resultPanel.add(createResultSubPanel("Hexadecimal", hexadecimalResultArea));
        resultPanel.add(createResultSubPanel("Binary", binaryResultArea));

        add(resultPanel, BorderLayout.SOUTH);
    }

    private JTextArea createResultArea() {
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        resultArea.setBackground(Color.LIGHT_GRAY);
        resultArea.setForeground(Color.BLACK);
        resultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        return resultArea;
    }

    private JPanel createResultSubPanel(String systemName, JTextArea resultArea) {
        JPanel subPanel = new JPanel(new BorderLayout());
        subPanel.setBackground(Color.DARK_GRAY);

        JLabel systemLabel = createLabel(systemName + ":");
        subPanel.add(systemLabel, BorderLayout.NORTH);
        subPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        return subPanel;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        textField.setBackground(Color.LIGHT_GRAY);
        textField.setForeground(Color.BLACK);
        return textField;
    }

    private void customizeAppearance() {
        Color backgroundColor = Color.DARK_GRAY;
        Color foregroundColor = Color.LIGHT_GRAY;

        getContentPane().setBackground(backgroundColor);

        applyForegroundToComponent(minField, backgroundColor, foregroundColor);
        applyForegroundToComponent(maxField, backgroundColor, foregroundColor);
        applyForegroundToComponent(convertButton, backgroundColor, foregroundColor);
    }

    private void applyForegroundToComponent(JComponent component, Color background, Color foreground) {
        component.setBackground(background);
        component.setForeground(foreground);
    }

    private void addComponentsToFrame() {
        setPreferredSize(new Dimension(850, 300));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            String minText = minField.getText();
            String maxText = maxField.getText();

            if (!minText.isEmpty() && !maxText.isEmpty()) {
                int min = Integer.parseInt(minText);
                int max = Integer.parseInt(maxText);

                convertNumberSystemInParallel(new OctalNumberSystem(), min, max, octalResultArea);
                convertNumberSystemInParallel(new HexadecimalNumberSystem(), min, max, hexadecimalResultArea);
                convertNumberSystemInParallel(new BinaryNumberSystem(), min, max, binaryResultArea);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter min and max values.");
            }
        }
    }

    private void convertNumberSystemInParallel(NumberSystem numberSystem, int min, int max, JTextArea resultArea) {
        Thread conversionThread = new Thread(() -> {
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = min; i <= max; i++) {
                String convertedNumber = numberSystem.convertNumber(i);
                resultBuilder.append(i).append(" (Decimal) -> ").append(convertedNumber)
                        .append(" (").append(numberSystem.getName()).append(")").append("\n");
            }
            SwingUtilities.invokeLater(() -> resultArea.setText(resultBuilder.toString()));
        });

        conversionThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            NumberSystemConverterFrame converterFrame = new NumberSystemConverterFrame();
            converterFrame.setVisible(true);
        });
    }
}
