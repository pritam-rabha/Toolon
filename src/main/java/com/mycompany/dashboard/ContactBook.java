/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dashboard;

/**
 *
 * @author pritamrabha
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ContactBook extends JPanel implements ActionListener {

    JTextField nameField, phoneField;
    JButton addButton, deleteButton;

    JTable table;
    DefaultTableModel model;

    int count = 1;

    public ContactBook() {

        setLayout(new BorderLayout(10,10));
        setBackground(new Color(30,30,30));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

 
        JPanel topPanel = new JPanel(new GridLayout(1,3,10,10));
        topPanel.setBackground(new Color(30,30,30));

        nameField = new JTextField();
        nameField.setBorder(BorderFactory.createTitledBorder("Name"));

        phoneField = new JTextField();
        phoneField.setBorder(BorderFactory.createTitledBorder("Phone"));

        addButton = new JButton("Add");
        addButton.setBackground(new Color(0,200,83));
        addButton.setForeground(Color.WHITE);
        addButton.addActionListener(this);

        topPanel.add(nameField);
        topPanel.add(phoneField);
        topPanel.add(addButton);

        model = new DefaultTableModel(new String[]{"S.No", "Name", "Phone"}, 0);
        table = new JTable(model);

        table.setBackground(new Color(40,40,40));
        table.setForeground(Color.WHITE);
        table.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(table);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(30,30,30));

        deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(244,67,54));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);

        bottomPanel.add(deleteButton);

        add(topPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String phone = phoneField.getText();

            if (!name.isEmpty() && !phone.isEmpty()) {
                model.addRow(new Object[]{count++, name, phone});
                nameField.setText("");
                phoneField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter all fields!");
            }
        }

        else if (e.getSource() == deleteButton) {
            int row = table.getSelectedRow();

            if (row != -1) {
                model.removeRow(row);
                updateSerialNumbers();
            } else {
                JOptionPane.showMessageDialog(this, "Select a row!");
            }
        }
    }

    void updateSerialNumbers() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
        count = model.getRowCount() + 1;
    }
}