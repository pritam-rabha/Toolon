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

public class TempConverter extends JPanel implements ActionListener {

    JTextField inputField;
    JLabel resultLabel;
    JButton cToF, fToC;

    public TempConverter() {

        setLayout(new GridBagLayout());
        setBackground(new Color(30,30,30));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        Font font = new Font("Segoe UI", Font.BOLD, 14);

        // Label
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel label = new JLabel("Enter Temperature:");
        label.setForeground(Color.WHITE);
        add(label, gbc);

        // Input
        gbc.gridx = 1;
        inputField = new JTextField(10);
        inputField.setFont(font);
        add(inputField, gbc);

        // Buttons
        cToF = new JButton("C → F");
        fToC = new JButton("F → C");

        styleButton(cToF, new Color(70,130,180));
        styleButton(fToC, new Color(60,179,113));

        cToF.addActionListener(this);
        fToC.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 1;
        add(cToF, gbc);

        gbc.gridx = 1;
        add(fToC, gbc);

        // Result
        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(new Color(0,255,180));
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);
    }

    void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            double temp = Double.parseDouble(inputField.getText());

            if (e.getSource() == cToF) {
                double result = (temp * 9/5) + 32;
                resultLabel.setText("Fahrenheit: " + String.format("%.2f", result));
            } 
            else {
                double result = (temp - 32) * 5/9;
                resultLabel.setText("Celsius: " + String.format("%.2f", result));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid number!");
        }
    }
}