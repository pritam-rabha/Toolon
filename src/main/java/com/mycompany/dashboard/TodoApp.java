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

public class TodoApp extends JPanel implements ActionListener {

    JTextField taskField;
    JButton addButton, deleteButton, clearButton;
    JList<String> taskList;
    DefaultListModel<String> listModel;

    public TodoApp() {

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

   
        JPanel topPanel = new JPanel(new BorderLayout(8, 8));
        topPanel.setBackground(new Color(30, 30, 30));

        taskField = new JTextField();
        taskField.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taskField.setBackground(new Color(50, 50, 50));
        taskField.setForeground(Color.WHITE);
        taskField.setCaretColor(Color.WHITE);
        taskField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        addButton = new JButton("Add");
        styleButton(addButton, new Color(0, 200, 83));

        topPanel.add(taskField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);


        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskList.setBackground(new Color(45, 45, 45));
        taskList.setForeground(Color.WHITE);
        taskList.setSelectionBackground(new Color(0, 150, 136));

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));


        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBackground(new Color(30, 30, 30));

        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear All");

        styleButton(deleteButton, new Color(244, 67, 54));
        styleButton(clearButton, new Color(33, 150, 243));

        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);

 
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);


        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            String task = taskField.getText();

            if (!task.isEmpty()) {
                listModel.addElement("• " + task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a task!");
            }
        }

        else if (e.getSource() == deleteButton) {
            int selected = taskList.getSelectedIndex();

            if (selected != -1) {
                listModel.remove(selected);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task!");
            }
        }

        else if (e.getSource() == clearButton) {
            listModel.clear();
        }
    }
}