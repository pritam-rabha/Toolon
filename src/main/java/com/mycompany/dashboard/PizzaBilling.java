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

public class PizzaBilling extends JPanel implements ActionListener {

    JTextField nameField, qtyField;
    JCheckBox cheese, pepperoni, mushroom, drink;
    JRadioButton small, medium, large;
    JButton orderButton;
    JTextArea billArea;

    public PizzaBilling() {

        setLayout(new BorderLayout(10,10));
        setBackground(new Color(30,30,30));

        JPanel panel = new JPanel(new GridLayout(5,1,10,10));
        panel.setBackground(new Color(30,30,30));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Customer
        nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Customer Name"));

        qtyField = new JTextField("1");
        qtyField.setBorder(BorderFactory.createTitledBorder("Quantity"));

        // Size
        JPanel sizePanel = new JPanel();
        sizePanel.setBackground(new Color(30,30,30));
        sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));

        small = new JRadioButton("Small ₹100");
        medium = new JRadioButton("Medium ₹150");
        large = new JRadioButton("Large ₹200");

        styleRadio(small);
        styleRadio(medium);
        styleRadio(large);

        ButtonGroup bg = new ButtonGroup();
        bg.add(small); bg.add(medium); bg.add(large);

        sizePanel.add(small);
        sizePanel.add(medium);
        sizePanel.add(large);

        // Toppings
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(30,30,30));
        topPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));

        cheese = new JCheckBox("Cheese ₹40");
        pepperoni = new JCheckBox("Pepperoni ₹60");
        mushroom = new JCheckBox("Mushroom ₹30");
        drink = new JCheckBox("Cold Drink ₹50");

        styleCheck(cheese);
        styleCheck(pepperoni);
        styleCheck(mushroom);
        styleCheck(drink);

        topPanel.add(cheese);
        topPanel.add(pepperoni);
        topPanel.add(mushroom);
        topPanel.add(drink);

        orderButton = new JButton("Generate Bill");
        orderButton.setBackground(new Color(0,200,83));
        orderButton.setForeground(Color.WHITE);
        orderButton.setFocusPainted(false);
        orderButton.addActionListener(this);

    
        billArea = new JTextArea();
        billArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        billArea.setBackground(new Color(20,20,20));
        billArea.setForeground(Color.WHITE);

        panel.add(nameField);
        panel.add(qtyField);
        panel.add(sizePanel);
        panel.add(topPanel);
        panel.add(orderButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(billArea), BorderLayout.CENTER);
    }

    void styleRadio(JRadioButton r) {
        r.setBackground(new Color(30,30,30));
        r.setForeground(Color.WHITE);
    }

    void styleCheck(JCheckBox c) {
        c.setBackground(new Color(30,30,30));
        c.setForeground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            String name = nameField.getText();
            int qty = Integer.parseInt(qtyField.getText());

            int total = 0;
            StringBuilder bill = new StringBuilder("🍕 Pizza Bill\n\n");

            bill.append("Customer: ").append(name).append("\n");
            bill.append("Quantity: ").append(qty).append("\n\n");

            int price = 0;

            if (small.isSelected()) price = 100;
            else if (medium.isSelected()) price = 150;
            else if (large.isSelected()) price = 200;
            else {
                JOptionPane.showMessageDialog(this, "Select size!");
                return;
            }

            total += price;

            if (cheese.isSelected()) total += 40;
            if (pepperoni.isSelected()) total += 60;
            if (mushroom.isSelected()) total += 30;
            if (drink.isSelected()) total += 50;

            total *= qty;

            double gst = total * 0.18;
            double finalTotal = total + gst;

            bill.append("Base Price: ₹").append(total).append("\n");
            bill.append("GST (18%): ₹").append(String.format("%.2f", gst)).append("\n");
            bill.append("-------------------------\n");
            bill.append("Total: ₹").append(String.format("%.2f", finalTotal));

            billArea.setText(bill.toString());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid data!");
        }
    }
}