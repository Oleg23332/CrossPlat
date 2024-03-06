package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TypeInfoAnalyzerGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;

    public TypeInfoAnalyzerGUI() {
        setTitle("Аналізатор класу");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeTypeInfo();
            }
        });

        JButton analyzeButton = new JButton("Аналіз");
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeTypeInfo();
            }
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        panel.add(inputField, BorderLayout.NORTH);
        panel.add(analyzeButton, BorderLayout.EAST);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private void analyzeTypeInfo() {
        String input = inputField.getText().trim();
        if (!input.isEmpty()) {
            try {
                // Перевіряємо, чи введене значення є іменем класу чи не
                if (input.contains(".")) {
                    // Якщо введений рядок містить крапку, вважаємо, що це ім'я класу і викликаємо getTypeInfo з рядком
                    String info = TypeInfoAnalyzer.getTypeInfo(input);
                    resultArea.setText(info);
                } else {
                    // В іншому випадку припускаємо, що введений рядок є ім'ям класу і викликаємо getTypeInfo з класом
                    Class<?> clazz = Class.forName(input);
                    String info = TypeInfoAnalyzer.getTypeInfo(clazz);
                    resultArea.setText(info);
                }
            } catch (ClassNotFoundException ex) {
                resultArea.setText("Клас не знайдено: " + input);
            }
        }
    }
}
