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
import java.io.*;

public class Notepad extends JPanel implements ActionListener {

    JTextArea textArea;

    public Notepad() {

        setLayout(new BorderLayout());

    
        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));

        add(new JScrollPane(textArea), BorderLayout.CENTER);

      
        JMenuBar menuBar = new JMenuBar();

        
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open...");
        JMenuItem saveItem = new JMenuItem("Save");

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);

    
        JMenu editMenu = new JMenu("Edit");

        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        cutItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

    
        add(menuBar, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        try {

            if (command.equals("New")) {
                textArea.setText("");
            }

            else if (command.equals("Open...")) {
                JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    textArea.read(reader, null);
                    reader.close();
                }
            }

            else if (command.equals("Save")) {
                JFileChooser fc = new JFileChooser();
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    textArea.write(writer);
                    writer.close();
                }
            }

            else if (command.equals("Cut")) textArea.cut();
            else if (command.equals("Copy")) textArea.copy();
            else if (command.equals("Paste")) textArea.paste();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}