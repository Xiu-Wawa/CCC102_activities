/**
 Author: Joshua Timothy O. Clet
 BSCS 3rd Year

 The NumberSystemConverterGUI class represents a GUI version of the Number System Converter.
 It provides a graphical interface for converting numbers between different number systems.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConverterGUI extends JFrame {
    private JTextField valueTextField;
    private JComboBox<String> baseComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public NumberSystemConverterGUI() {
        setTitle("Number System Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        JLabel valueLabel = new JLabel("Value:");
        valueTextField = new JTextField(10);
        inputPanel.add(valueLabel, BorderLayout.WEST);
        inputPanel.add(valueTextField, BorderLayout.CENTER);
        mainPanel.add(inputPanel);

        JPanel basePanel = new JPanel(new BorderLayout(5, 5));
        JLabel baseLabel = new JLabel("Base:");
        baseComboBox = new JComboBox<>(new String[]{"Binary", "Octal", "Decimal", "Hexadecimal"});
        basePanel.add(baseLabel, BorderLayout.WEST);
        basePanel.add(baseComboBox, BorderLayout.CENTER);
        mainPanel.add(basePanel);

        JPanel convertPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        convertButton = new JButton("Convert");
        convertPanel.add(convertButton);
        mainPanel.add(convertPanel);

        JPanel resultPanel = new JPanel(new BorderLayout(5, 5));
        JLabel resultTextLabel = new JLabel("Result:");
        resultLabel = new JLabel();
        resultPanel.add(resultTextLabel, BorderLayout.WEST);
        resultPanel.add(resultLabel, BorderLayout.CENTER);
        mainPanel.add(resultPanel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertNumber();
            }
        });

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void convertNumber() {
        String value = valueTextField.getText();
        String selectedBase = (String) baseComboBox.getSelectedItem();
        NumberSystem numberSystem = null;

        switch (selectedBase) {
            case "Binary":
                numberSystem = new BinaryNumberSystem(value);
                break;
            case "Octal":
                numberSystem = new OctalNumberSystem(value);
                break;
            case "Decimal":
                numberSystem = new DecimalNumberSystem(value);
                break;
            case "Hexadecimal":
                numberSystem = new HexadecimalNumberSystem(value);
                break;
        }

        if (numberSystem != null) {
            int newBase = 10;
            String convertedValue = numberSystem.convertTo(value, newBase);
            resultLabel.setText(convertedValue);
        } else {
            resultLabel.setText("Invalid number system");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberSystemConverterGUI().setVisible(true);
            }
        });
    }
}
