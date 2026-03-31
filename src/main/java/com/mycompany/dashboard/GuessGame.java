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
import java.util.Random;

public class GuessGame extends JPanel implements ActionListener {

    int numberToGuess;
    int attempts = 0;

    JTextField inputField;
    JLabel messageLabel, attemptsLabel;
    JButton guessButton;

    public GuessGame() {

        setLayout(new GridBagLayout());
        setBackground(new Color(20,20,20));

        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(35,35,35));
        card.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));

        JLabel title = new JLabel("🎯 Guess The Number");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(CENTER_ALIGNMENT);

        messageLabel = new JLabel("Enter number (1-100)");
        messageLabel.setForeground(Color.LIGHT_GRAY);
        messageLabel.setAlignmentX(CENTER_ALIGNMENT);

        inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(200,35));
        inputField.setFont(new Font("Segoe UI", Font.BOLD, 16));
        inputField.setHorizontalAlignment(JTextField.CENTER);

        guessButton = new JButton("Guess");
        guessButton.setBackground(new Color(70,130,180));
        guessButton.setForeground(Color.WHITE);
        guessButton.setFocusPainted(false);
        guessButton.setAlignmentX(CENTER_ALIGNMENT);
        guessButton.addActionListener(this);

        attemptsLabel = new JLabel("Attempts: 0");
        attemptsLabel.setForeground(new Color(0,200,150));
        attemptsLabel.setAlignmentX(CENTER_ALIGNMENT);

        card.add(title);
        card.add(Box.createRigidArea(new Dimension(0,10)));
        card.add(messageLabel);
        card.add(Box.createRigidArea(new Dimension(0,15)));
        card.add(inputField);
        card.add(Box.createRigidArea(new Dimension(0,15)));
        card.add(guessButton);
        card.add(Box.createRigidArea(new Dimension(0,15)));
        card.add(attemptsLabel);

        add(card);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(inputField.getText());
            attempts++;

            attemptsLabel.setText("Attempts: " + attempts);

            if (guess < numberToGuess) {
                messageLabel.setText("Too Low 🔻");
            } 
            else if (guess > numberToGuess) {
                messageLabel.setText("Too High 🔺");
            } 
            else {
                JOptionPane.showMessageDialog(this,
                        "Correct! 🎉 Attempts: " + attempts);

                numberToGuess = new Random().nextInt(100) + 1;
                attempts = 0;
                attemptsLabel.setText("Attempts: 0");
                messageLabel.setText("Enter number (1-100)");
                inputField.setText("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid number!");
        }
    }
}