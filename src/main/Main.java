package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    JFrame window;
    JPanel textPanel;
    JLabel textLabel;
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Wódą i Piwem");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }

}