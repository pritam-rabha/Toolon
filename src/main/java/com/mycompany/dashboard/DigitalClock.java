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
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JPanel {

    JLabel timeLabel, dateLabel;

    public DigitalClock() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(15, 15, 15));

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 60));
        timeLabel.setForeground(new Color(0, 255, 180)); // neon color
        timeLabel.setAlignmentX(CENTER_ALIGNMENT);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        dateLabel.setForeground(Color.LIGHT_GRAY);
        dateLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(timeLabel);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(dateLabel);
        add(Box.createVerticalGlue());

        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock();
    }

    void updateClock() {
        Date now = new Date();

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMM yyyy");

        timeLabel.setText(timeFormat.format(now));
        dateLabel.setText(dateFormat.format(now));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(
            0, 0, new Color(10,10,10),
            0, getHeight(), new Color(30,30,30)
        );

        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}

