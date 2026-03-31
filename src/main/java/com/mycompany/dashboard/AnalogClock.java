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
import java.util.Calendar;

public class AnalogClock extends JPanel {

    public AnalogClock() {
        Timer timer = new Timer(1000, e -> repaint());
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 2 - 20;

    
        g2.setColor(Color.WHITE);
        g2.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

   
        g2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(i * 30 - 90);
            int x = (int) (centerX + Math.cos(angle) * (radius - 40));
            int y = (int) (centerY + Math.sin(angle) * (radius - 40));

            String num = String.valueOf(i);
            FontMetrics fm = g2.getFontMetrics();
            int w = fm.stringWidth(num);
            int h = fm.getAscent();

            g2.drawString(num, x - w / 2, y + h / 2);
        }

   
        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6 - 90);

            int inner = radius - (i % 5 == 0 ? 20 : 10);
            int outer = radius;

            int x1 = (int) (centerX + Math.cos(angle) * inner);
            int y1 = (int) (centerY + Math.sin(angle) * inner);

            int x2 = (int) (centerX + Math.cos(angle) * outer);
            int y2 = (int) (centerY + Math.sin(angle) * outer);

            g2.setStroke(new BasicStroke(i % 5 == 0 ? 3 : 1));
            g2.drawLine(x1, y1, x2, y2);
        }

   
        Calendar cal = Calendar.getInstance();

        int sec = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int hr = cal.get(Calendar.HOUR);

        double secAngle = Math.toRadians(sec * 6 - 90);
        double minAngle = Math.toRadians(min * 6 + sec * 0.1 - 90);
        double hrAngle = Math.toRadians(hr * 30 + min * 0.5 - 90);

     
        drawHand(g2, centerX, centerY, hrAngle, radius - 80, 6, Color.BLACK);

        drawHand(g2, centerX, centerY, minAngle, radius - 50, 4, Color.BLACK);

   
        drawHand(g2, centerX, centerY, secAngle, radius - 30, 2, Color.RED);


        g2.setColor(Color.RED);
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
    }

    void drawHand(Graphics2D g2, int x, int y, double angle, int length, int thickness, Color color) {
        int x2 = (int) (x + Math.cos(angle) * length);
        int y2 = (int) (y + Math.sin(angle) * length);

        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawLine(x, y, x2, y2);
    }

}