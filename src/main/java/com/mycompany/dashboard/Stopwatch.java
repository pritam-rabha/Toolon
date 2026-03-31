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

public class Stopwatch extends JPanel implements ActionListener {

    JLabel timeLabel, titleLabel;
    JButton startButton, stopButton, resetButton;

    int seconds = 0;
    Timer timer;

    public Stopwatch() {

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(20, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

   
        titleLabel = new JLabel("⏱ Stopwatch", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);

  
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 50));
        timeLabel.setForeground(new Color(0, 255, 180));


        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBackground(new Color(20, 20, 20));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        styleButton(startButton, new Color(0, 200, 83));
        styleButton(stopButton, new Color(244, 67, 54));
        styleButton(resetButton, new Color(33, 150, 243));

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);


        timer = new Timer(1000, e -> updateTime());


        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);


        add(titleLabel, BorderLayout.NORTH);
        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    void updateTime() {
        seconds++;

        int hrs = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;

        timeLabel.setText(String.format("%02d:%02d:%02d", hrs, mins, secs));
    }

    void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            timer.start();
        }

        else if (e.getSource() == stopButton) {
            timer.stop();
            Toolkit.getDefaultToolkit().beep(); // sound
        }

        else if (e.getSource() == resetButton) {
            timer.stop();
            seconds = 0;
            timeLabel.setText("00:00:00");
        }
    }
}