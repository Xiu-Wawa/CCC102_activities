import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberSystemConverterFrame extends JFrame implements ActionListener {
    private JTextField minField, maxField;
    private JComboBox<NumberSystem> systemComboBox;
    private JButton convertButton;
    private JTextArea resultArea;

    public NumberSystemConverterFrame() {
        setTitle("Number System Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false); // Set resizable to false

        createInputPanel();
        createConvertButton();
        createResultPanel();

        customizeAppearance();

        addComponentsToFrame();

        pack();
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new FlowLayout());

        JLabel minLabel = new JLabel("Min value:");
        minField = new JTextField(10);
        JLabel maxLabel = new JLabel("Max value:");
        maxField = new JTextField(10);

        inputPanel.add(minLabel);
        inputPanel.add(minField);
        inputPanel.add(maxLabel);
        inputPanel.add(maxField);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void createConvertButton() {
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        add(convertButton, BorderLayout.CENTER);
    }

    private void createResultPanel() {
        JPanel resultPanel = new JPanel(new BorderLayout());

        JLabel systemLabel = new JLabel("Number System:");
        NumberSystem[] systems = {
                new OctalNumberSystem(),
                new BinaryNumberSystem(),
                new HexadecimalNumberSystem(),
                new DecimalNumberSystem()
        };
        systemComboBox = new JComboBox<>(systems);
        systemComboBox.setRenderer(new NumberSystemComboBoxRenderer());

        resultPanel.add(systemLabel, BorderLayout.NORTH);
        resultPanel.add(systemComboBox, BorderLayout.CENTER);

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        resultPanel.add(scrollPane, BorderLayout.SOUTH);

        add(resultPanel, BorderLayout.SOUTH);
    }

    private void customizeAppearance() {
        Color backgroundColor = new Color(33, 33, 33); // Dark gray color
        Color foregroundColor = new Color(187, 187, 187); // Light gray color

        getContentPane().setBackground(backgroundColor);

        applyForegroundToComponent(minField, backgroundColor, foregroundColor);
        applyForegroundToComponent(maxField, backgroundColor, foregroundColor);
        applyForegroundToComponent(systemComboBox, backgroundColor, foregroundColor);
        applyForegroundToComponent(convertButton, backgroundColor, foregroundColor);
        resultArea.setBackground(foregroundColor);
        resultArea.setForeground(backgroundColor);
    }

    private void applyForegroundToComponent(JComponent component, Color background, Color foreground) {
        component.setBackground(background);
        component.setForeground(foreground);
    }

    private void addComponentsToFrame() {
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            String minText = minField.getText();
            String maxText = maxField.getText();

            if (!minText.isEmpty() && !maxText.isEmpty()) {
                int min = Integer.parseInt(minText);
                int max = Integer.parseInt(maxText);

                NumberSystem selectedSystem = (NumberSystem) systemComboBox.getSelectedItem();

                NumberSystemConverter converter = new NumberSystemConverter(min, max, selectedSystem);
                converter.convert();
                String result = converter.getResult();

                resultArea.setText(result);
            } else {
                JOptionPane.showMessageDialog(this, "Please enter min and max values.");
            }
        }
    }

    private static class NumberSystemComboBoxRenderer extends DefaultListCellRenderer {
        public NumberSystemComboBoxRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof NumberSystem) {
                setText(((NumberSystem) value).getName());
            } else {
                setText("");
            }

            return this;
        }
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
