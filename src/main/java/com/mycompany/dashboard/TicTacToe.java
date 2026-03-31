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

public class TicTacToe extends JPanel implements ActionListener {

    JButton[][] buttons = new JButton[3][3];
    boolean isXTurn = true;

    public TicTacToe() {

        setLayout(new GridLayout(3, 3, 5, 5));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        Font font = new Font("Segoe UI", Font.BOLD, 50);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].setBackground(new Color(50, 50, 50));
                buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));

                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();

        if (!btn.getText().equals("")) return;

        if (isXTurn) {
            btn.setText("X");
            btn.setForeground(Color.RED);
        } else {
            btn.setText("O");
            btn.setForeground(Color.CYAN);
        }

        isXTurn = !isXTurn;

        checkWinner();
    }

    void checkWinner() {
        String[][] b = new String[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                b[i][j] = buttons[i][j].getText();

      
        for (int i = 0; i < 3; i++) {
            if (!b[i][0].equals("") && b[i][0].equals(b[i][1]) && b[i][1].equals(b[i][2]))
                showWinner(b[i][0]);

            if (!b[0][i].equals("") && b[0][i].equals(b[1][i]) && b[1][i].equals(b[2][i]))
                showWinner(b[0][i]);
        }

     
        if (!b[0][0].equals("") && b[0][0].equals(b[1][1]) && b[1][1].equals(b[2][2]))
            showWinner(b[0][0]);

        if (!b[0][2].equals("") && b[0][2].equals(b[1][1]) && b[1][1].equals(b[2][0]))
            showWinner(b[0][2]);
    }

    void showWinner(String winner) {
        JOptionPane.showMessageDialog(this, winner + " Wins! 🎉");
        resetGame();
    }

    void resetGame() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setForeground(Color.WHITE);
            }

        isXTurn = true;
    }
}