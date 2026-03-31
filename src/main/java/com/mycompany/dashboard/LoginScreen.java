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

public class LoginScreen extends JPanel implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    CardLayout cardLayout;
    JPanel mainPanel;

    public LoginScreen(CardLayout cardLayout, JPanel mainPanel) {

        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;

        setLayout(new GridBagLayout());
        setBackground(new Color(30,30,30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        Font font = new Font("Segoe UI", Font.BOLD, 14);

     
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        add(userLabel, gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        add(usernameField, gbc);

      
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);
        add(passLabel, gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(70,130,180));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton, gbc);
    }

    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("pritam") && password.equals("12345")) {
            JOptionPane.showMessageDialog(this, "Login Successful ✅");

       
            cardLayout.show(mainPanel, "home");

        } else {
            JOptionPane.showMessageDialog(this, "Invalid ❌");
        }
    }
}