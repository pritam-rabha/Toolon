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
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer extends JPanel implements ActionListener {

    JLabel imageLabel, infoLabel;
    JButton openButton, nextButton, prevButton, zoomIn, zoomOut, slideshowBtn;

    File[] imageFiles;
    int currentIndex = 0;

    double scale = 1.0;
    Timer slideshowTimer;

    public ImageViewer() {

        setLayout(new BorderLayout(10,10));
        setBackground(new Color(30,30,30));

   
        imageLabel = new JLabel("No Image", SwingConstants.CENTER);
        imageLabel.setForeground(Color.WHITE);

        infoLabel = new JLabel(" ", SwingConstants.CENTER);
        infoLabel.setForeground(Color.LIGHT_GRAY);

        add(imageLabel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(30,30,30));

        openButton = new JButton("Open");
        prevButton = new JButton("◀");
        nextButton = new JButton("▶");
        zoomIn = new JButton("Zoom +");
        zoomOut = new JButton("Zoom -");
        slideshowBtn = new JButton("Slideshow");

        styleButton(openButton, new Color(0,200,83));
        styleButton(prevButton, new Color(255,87,34));
        styleButton(nextButton, new Color(33,150,243));
        styleButton(zoomIn, new Color(156,39,176));
        styleButton(zoomOut, new Color(156,39,176));
        styleButton(slideshowBtn, new Color(255,193,7));

        btnPanel.add(openButton);
        btnPanel.add(prevButton);
        btnPanel.add(nextButton);
        btnPanel.add(zoomIn);
        btnPanel.add(zoomOut);
        btnPanel.add(slideshowBtn);

        add(btnPanel, BorderLayout.SOUTH);

        slideshowTimer = new Timer(2000, e -> nextImage());

        openButton.addActionListener(this);
        nextButton.addActionListener(this);
        prevButton.addActionListener(this);
        zoomIn.addActionListener(this);
        zoomOut.addActionListener(this);
        slideshowBtn.addActionListener(this);
    }

    void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == openButton) {
            JFileChooser fc = new JFileChooser();

            fc.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "jpeg"));
            fc.setMultiSelectionEnabled(true);

            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                imageFiles = fc.getSelectedFiles();
                currentIndex = 0;
                scale = 1.0;
                showImage();
            }
        }

        else if (e.getSource() == nextButton) nextImage();
        else if (e.getSource() == prevButton) prevImage();

        else if (e.getSource() == zoomIn) {
            scale += 0.2;
            showImage();
        }

        else if (e.getSource() == zoomOut) {
            scale -= 0.2;
            if (scale < 0.2) scale = 0.2;
            showImage();
        }

        else if (e.getSource() == slideshowBtn) {
            if (slideshowTimer.isRunning()) {
                slideshowTimer.stop();
                slideshowBtn.setText("Slideshow");
            } else {
                slideshowTimer.start();
                slideshowBtn.setText("Stop");
            }
        }
    }

    void nextImage() {
        if (imageFiles != null && currentIndex < imageFiles.length - 1) {
            currentIndex++;
            showImage();
        }
    }

    void prevImage() {
        if (imageFiles != null && currentIndex > 0) {
            currentIndex--;
            showImage();
        }
    }

    void showImage() {
        if (imageFiles == null) return;

        ImageIcon icon = new ImageIcon(imageFiles[currentIndex].getAbsolutePath());

        int width = (int)(imageLabel.getWidth() * scale);
        int height = (int)(imageLabel.getHeight() * scale);

        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        imageLabel.setIcon(new ImageIcon(img));
        imageLabel.setText("");

        infoLabel.setText(
            imageFiles[currentIndex].getName() +
            " (" + (currentIndex+1) + "/" + imageFiles.length + ")"
        );
    }
}