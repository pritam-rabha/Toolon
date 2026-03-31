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

public class QuizApp extends JPanel {

    JLabel questionLabel, timerLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup group;

    JButton nextButton, prevButton, submitButton;
    JProgressBar progressBar;

    int current = 0;
    int score = 0;
    int timeLeft = 10;

    int[] userAnswers;
    Timer timer;

    String[][] questions = {
        {"Java is?", "Language", "Animal", "Car", "City"},
        {"2 + 2 = ?", "3", "4", "5", "6"},
        {"Sun rises in?", "West", "North", "East", "South"},
        {"Which is OOP concept?", "Inheritance", "Loop", "Array", "Pointer"}
    };

    int[] answers = {0, 1, 2, 0};

    public QuizApp() {

        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(18, 18, 18));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        userAnswers = new int[questions.length];
        for (int i = 0; i < userAnswers.length; i++) userAnswers[i] = -1;

        // TOP
        questionLabel = new JLabel();
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        timerLabel = new JLabel("10s", SwingConstants.RIGHT);
        timerLabel.setForeground(Color.RED);

        progressBar = new JProgressBar(0, questions.length);
        progressBar.setStringPainted(true);

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(new Color(18,18,18));

        top.add(questionLabel, BorderLayout.WEST);
        top.add(timerLabel, BorderLayout.EAST);
        top.add(progressBar, BorderLayout.SOUTH);

        // OPTIONS
        JPanel optionPanel = new JPanel(new GridLayout(4,1,10,10));
        optionPanel.setBackground(new Color(18,18,18));

        group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBackground(new Color(40,40,40));
            options[i].setForeground(Color.WHITE);
            options[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            options[i].setFocusPainted(false);

            group.add(options[i]);
            optionPanel.add(options[i]);
        }

        // BUTTONS
        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(18,18,18));

        prevButton = new JButton("Prev");
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");

        bottom.add(prevButton);
        bottom.add(nextButton);
        bottom.add(submitButton);

        add(top, BorderLayout.NORTH);
        add(optionPanel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        // TIMER
        timer = new Timer(1000, e -> updateTimer());

        prevButton.addActionListener(e -> previous());
        nextButton.addActionListener(e -> next());
        submitButton.addActionListener(e -> submitQuiz());

        loadQuestion();
        timer.start();
    }

    void loadQuestion() {
        group.clearSelection();

        questionLabel.setText((current + 1) + ". " + questions[current][0]);

        for (int i = 0; i < 4; i++) {
            options[i].setText(questions[current][i + 1]);
        }

        if (userAnswers[current] != -1) {
            options[userAnswers[current]].setSelected(true);
        }

        progressBar.setValue(current + 1);

        timeLeft = 10;
        timerLabel.setText(timeLeft + "s");
    }

    void updateTimer() {
        timeLeft--;
        timerLabel.setText(timeLeft + "s");

        if (timeLeft == 0) next();
    }

    void saveAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                userAnswers[current] = i;
            }
        }
    }

    void next() {
        saveAnswer();
        if (current < questions.length - 1) {
            current++;
            loadQuestion();
        }
    }

    void previous() {
        saveAnswer();
        if (current > 0) {
            current--;
            loadQuestion();
        }
    }

    void submitQuiz() {
        saveAnswer();
        score = 0;

        for (int i = 0; i < questions.length; i++) {
            if (userAnswers[i] == answers[i]) score++;
        }

        JOptionPane.showMessageDialog(this,
                "Score: " + score + "/" + questions.length);
    }
}