/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dashboard;

/**
 *
 * @author pritamrabha
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculator extends JPanel implements ActionListener {

    JTextField display;
    double num1 = 0, num2 = 0;
    char operator = ' ';

    public BasicCalculator() {

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Display
        display = new JTextField();
        display.setFont(new Font("Segoe UI", Font.BOLD, 40));
        display.setForeground(Color.WHITE);
        display.setBackground(Color.BLACK);
        display.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Buttons
        JPanel panel = new JPanel(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        String[] buttons = {
            "AC","+/-","%","÷",
            "7","8","9","×",
            "4","5","6","-",
            "1","2","3","+",
            "0",".","=",""
        };

        for (String text : buttons) {

            if (text.equals("")) {
                panel.add(new JLabel());
                continue;
            }

            JButton btn = new JButton(text);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);

            // Style
            if ("+-×÷=".contains(text)) {
                btn.setBackground(new Color(255,149,0)); // orange
                btn.setForeground(Color.WHITE);
            } else if ("AC+/-%".contains(text)) {
                btn.setBackground(Color.LIGHT_GRAY);
                btn.setForeground(Color.BLACK);
            } else {
                btn.setBackground(new Color(50,50,50));
                btn.setForeground(Color.WHITE);
            }

            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        // Numbers & dot
        if ("0123456789.".contains(cmd)) {
            display.setText(display.getText() + cmd);
        }

        // Clear
        else if (cmd.equals("AC")) {
            display.setText("");
            num1 = num2 = 0;
            operator = ' ';
        }

        // Equals
        else if (cmd.equals("=")) {
            if (display.getText().isEmpty()) return;

            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+': display.setText("" + (num1 + num2)); break;
                case '-': display.setText("" + (num1 - num2)); break;
                case '*': display.setText("" + (num1 * num2)); break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Error");
                    } else {
                        display.setText("" + (num1 / num2));
                    }
                    break;
            }
        }

        // Operators
        else {
            if (display.getText().isEmpty()) return;

            num1 = Double.parseDouble(display.getText());

            switch (cmd) {
                case "+": operator = '+'; break;
                case "-": operator = '-'; break;
                case "×": operator = '*'; break;
                case "÷": operator = '/'; break;
                case "%": operator = '%'; break;
            }

            display.setText("");
        }

        // Percentage
        if (cmd.equals("%")) {
            double value = Double.parseDouble(display.getText());
            display.setText("" + (value / 100));
        }

        // +/- toggle
        if (cmd.equals("+/-")) {
            if (!display.getText().isEmpty()) {
                double value = Double.parseDouble(display.getText());
                display.setText("" + (-value));
            }
        }
    }
}