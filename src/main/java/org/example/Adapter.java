package org.example;

import org.example.components.*;

import javax.swing.*;

public class Adapter {
    JLabel label;
    JButton button;
    JFrame frame;
    JPanel panel;
    String type;

    public Adapter() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            this.label = new WindowsLabel();
            this.button = new WindowsButton();
            this.frame = new WindowsFrame();
            this.panel = new WindowsPanel();
            this.type = "Windows";
        } else {
            this.label = new LinuxLabel();
            this.button = new LinuxButton();
            this.frame = new LinuxFrame();
            this.panel = new LinuxPanel();
            this.type = "Linux";
        }
    }

    public void showWindow() {
        if (this.type.equals("Windows")) {
            this.frame.setTitle("Windows");
            this.button.setText("Windows");
            this.label.setText("Windows");
        } else if (this.type.equals("Linux")) {
            this.frame.setTitle("Linux");
            this.button.setText("Linux");
            this.label.setText("Linux");
        }
        this.frame.setSize(300, 300);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.panel.add(this.label);
        this.panel.add(this.button);
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
}
