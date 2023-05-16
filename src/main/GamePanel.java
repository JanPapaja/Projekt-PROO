package main;

import javax.swing.JPanel;
import java.awt.*;
// 320, 224

public class GamePanel extends JPanel implements Runnable
{
    // USTAWIENIA EKRANU
    final int originalTitleSize = 16; //16x16
    final int scale = 3;

    final int titleSize = originalTitleSize * scale; //48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol;
    final int screenHeight = titleSize * maxScreenRow;

    Thread gameThread;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override // PĘTLA GRY
    public void run()
    {
        while(gameThread != null)
        {
            // Odnawiamy informacje w grze
            update();
            // Rysujemy to co się zmeiniło
            repaint();
        }
    }

    public void update()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //Jak czytałem i dobrze zrozumiałem to tutaj zmieniam nasz obiekt klasy Graphics g
                                        // na obiekt klasy Graphics2D
        g2.setColor(Color.white);

        g2.fillRect(100,100,titleSize,titleSize);

        g2.dispose();
    }
}

