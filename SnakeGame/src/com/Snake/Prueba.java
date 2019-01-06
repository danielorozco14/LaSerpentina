package com.Snake;
import java.awt.*;
import javax.swing.*;

public class Prueba extends JPanel {
    private int x=0,y=0,Xspeed=1,Yspeed=0;
    public void update(){
        this.x=this.x+this.Xspeed;
        this.y=this.y+this.Yspeed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the rectangle here
        g.setColor(Color.red);
        g.fillRect(this.x, this.y, 10, 10);
    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(600, 600);
    }

    // create the GUI explicitly on the Swing event thread
    private static void createAndShowGui() {
        Prueba mainPanel = new Prueba();

        JFrame frame = new JFrame("Snake Game ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}