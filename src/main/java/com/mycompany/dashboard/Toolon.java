package com.mycompany.dashboard;

import javax.swing.*;
import java.awt.*;

public class Toolon extends JFrame {

    CardLayout cardLayout;
    JPanel mainPanel;
    JPanel sidebar;

    public Toolon() {

        setTitle("Toolon");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(24, 24, 24));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Toolon");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        

        sidebar.add(title);
        sidebar.add(Box.createRigidArea(new Dimension(0,10)));

        JButton btnProject = new JButton("▶ Tools");
        styleMainButton(btnProject);


        JPanel projectPanel = new JPanel();
        projectPanel.setLayout(new BoxLayout(projectPanel, BoxLayout.Y_AXIS));
        projectPanel.setBackground(new Color(35,35,35));
        projectPanel.setVisible(false);
        projectPanel.setAlignmentX(Component.LEFT_ALIGNMENT);


        JButton btnClock = new JButton("Analog Clock");
        JButton btnCalc = new JButton("Calculator");
        JButton btnContact = new JButton("Contact Book");
        JButton btnCurrency = new JButton("Currency Converter");
        JButton btnDClock = new JButton("Digital Clock");
        JButton btnGame = new JButton("Guess Game");
        JButton btnViewer = new JButton("Image Viewer");
        JButton btnLogin = new JButton("Login System");
        JButton btnNotepad = new JButton("Notepad");
        JButton btnPizza = new JButton("Pizza Billing");
        JButton btnQuiz = new JButton("Quiz App");
        JButton btnStopwatch = new JButton("Stopwatch");
        JButton btnTemp = new JButton("Temperature Converter");
        JButton btnTic = new JButton("Tic Tac Toe");
        JButton btnTodo = new JButton("To-Do List");


        JButton[] allButtons = {
            btnClock, btnCalc, btnContact, btnCurrency,
            btnDClock, btnGame, btnViewer, btnLogin,
            btnNotepad, btnPizza, btnQuiz,
            btnStopwatch, btnTemp, btnTic, btnTodo
        };

        for (JButton btn : allButtons) {

            btn.setAlignmentX(Component.LEFT_ALIGNMENT);
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(true);
            btn.setOpaque(true);

            btn.setBackground(new Color(45,45,45));
            btn.setForeground(Color.WHITE);

            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btn.setHorizontalAlignment(SwingConstants.LEFT);

            btn.setBorder(BorderFactory.createEmptyBorder(8,20,8,10));

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    btn.setBackground(new Color(70,130,180));
                }
                public void mouseExited(java.awt.event.MouseEvent e) {
                    btn.setBackground(new Color(45,45,45));
                }
            });
        }


        projectPanel.add(createSection("Time Tools"));
        projectPanel.add(btnClock);
        projectPanel.add(btnDClock);
        projectPanel.add(btnStopwatch);

        projectPanel.add(createSection("Utilities"));
        projectPanel.add(btnCalc);
        projectPanel.add(btnCurrency);
        projectPanel.add(btnTemp);

        projectPanel.add(createSection("Productivity"));
        projectPanel.add(btnNotepad);
        projectPanel.add(btnTodo);
        projectPanel.add(btnContact);

        projectPanel.add(createSection("Games"));
        projectPanel.add(btnGame);
        projectPanel.add(btnTic);
        projectPanel.add(btnQuiz);

        projectPanel.add(createSection("Others"));
        projectPanel.add(btnPizza);
        projectPanel.add(btnViewer);
        projectPanel.add(btnLogin);


        btnProject.addActionListener(e -> {
            boolean visible = !projectPanel.isVisible();
            projectPanel.setVisible(visible);
            btnProject.setText(visible ? "▼ Tools" : "▶ Tools");
            sidebar.revalidate();
        });

        sidebar.add(btnProject);
        sidebar.add(projectPanel);


        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel blank = new JPanel();
        blank.setBackground(Color.WHITE);
        mainPanel.add(blank, "home");


        mainPanel.add(new AnalogClock(), "clock");
        mainPanel.add(new BasicCalculator(), "calc");
        mainPanel.add(new ContactBook(), "contact");
        mainPanel.add(new CurrencyConverter(), "currency");
        mainPanel.add(new DigitalClock(), "dclock");
        mainPanel.add(new GuessGame(), "game");
        mainPanel.add(new ImageViewer(), "viewer");
        mainPanel.add(new LoginScreen(cardLayout, mainPanel), "login");
        mainPanel.add(new Notepad(), "notepad");
        mainPanel.add(new PizzaBilling(), "pizza");
        mainPanel.add(new QuizApp(), "quiz");
        mainPanel.add(new Stopwatch(), "stopwatch");
        mainPanel.add(new TempConverter(), "temp");
        mainPanel.add(new TicTacToe(), "tic");
        mainPanel.add(new TodoApp(), "todo");


        btnClock.addActionListener(e -> cardLayout.show(mainPanel, "clock"));
        btnCalc.addActionListener(e -> cardLayout.show(mainPanel, "calc"));
        btnContact.addActionListener(e -> cardLayout.show(mainPanel, "contact"));
        btnCurrency.addActionListener(e -> cardLayout.show(mainPanel, "currency"));
        btnDClock.addActionListener(e -> cardLayout.show(mainPanel, "dclock"));
        btnGame.addActionListener(e -> cardLayout.show(mainPanel, "game"));
        btnViewer.addActionListener(e -> cardLayout.show(mainPanel, "viewer"));
        btnLogin.addActionListener(e -> cardLayout.show(mainPanel, "login"));
        btnNotepad.addActionListener(e -> cardLayout.show(mainPanel, "notepad"));
        btnPizza.addActionListener(e -> cardLayout.show(mainPanel, "pizza"));
        btnQuiz.addActionListener(e -> cardLayout.show(mainPanel, "quiz"));
        btnStopwatch.addActionListener(e -> cardLayout.show(mainPanel, "stopwatch"));
        btnTemp.addActionListener(e -> cardLayout.show(mainPanel, "temp"));
        btnTic.addActionListener(e -> cardLayout.show(mainPanel, "tic"));
        btnTodo.addActionListener(e -> cardLayout.show(mainPanel, "todo"));

        setLayout(new BorderLayout());
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    void styleMainButton(JButton btn) {
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setBackground(new Color(45,45,45));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorder(BorderFactory.createEmptyBorder(10,15,10,10));
        
    }

    JLabel createSection(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.GRAY);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    public static void main(String[] args) {
        new Toolon().setVisible(true);
    }
}