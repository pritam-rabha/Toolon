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

public class CurrencyConverter extends JPanel implements ActionListener {

    JTextField amountField;
    JComboBox<String> fromCurrency, toCurrency;
    JButton convertButton;
    JLabel resultLabel;

    String[] currencies = {"INR", "USD", "EUR", "GBP"};

    public CurrencyConverter() {

        setLayout(new GridBagLayout());
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);

        Font labelFont = new Font("Segoe UI", Font.BOLD, 15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setFont(labelFont);
        add(amountLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        amountField = new JTextField();
        amountField.setPreferredSize(new Dimension(180, 35));
        amountField.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setFont(labelFont);
        add(fromLabel, gbc);

        gbc.gridx = 1;
        fromCurrency = new JComboBox<>(currencies);
        add(fromCurrency, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        JLabel toLabel = new JLabel("To:");
        toLabel.setForeground(Color.WHITE);
        toLabel.setFont(labelFont);
        add(toLabel, gbc);

        gbc.gridx = 1;
        toCurrency = new JComboBox<>(currencies);
        add(toCurrency, gbc);

        convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(70,130,180));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);
        convertButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(convertButton, gbc);

        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(Color.GREEN);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        gbc.gridy = 4;
        add(resultLabel, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());

            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double result = convert(amount, from, to);
            result = Math.round(result * 100.0) / 100.0;

            resultLabel.setText("Result: " + result + " " + to);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid amount!");
        }
    }

    double convert(double amount, String from, String to) {
        double inr = 0;

        if (from.equals("INR")) inr = amount;
        else if (from.equals("USD")) inr = amount * 83;
        else if (from.equals("EUR")) inr = amount * 90;
        else if (from.equals("GBP")) inr = amount * 100;

        if (to.equals("INR")) return inr;
        else if (to.equals("USD")) return inr / 83;
        else if (to.equals("EUR")) return inr / 90;
        else if (to.equals("GBP")) return inr / 100;

        return 0;
    }
}