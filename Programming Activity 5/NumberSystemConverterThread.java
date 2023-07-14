import javax.swing.*;

public class NumberSystemConverterThread extends SwingWorker<String, Void> {
    private NumberSystemConverter converter;
    private JTextArea resultArea;

    public NumberSystemConverterThread(NumberSystemConverter converter, JTextArea resultArea) {
        this.converter = converter;
