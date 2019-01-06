package com.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;


public class Snake extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(7, this);
    double x = 0, y = 0, velX, velY;
    ArrayList <Integer> comida= new ArrayList<>(); //Tendra el control del cuerpo de la serpiente,
    // cuando alcance la comida se agregara otro rectangulo y se incrementrara la lista

    Random rand = new Random();
    private  boolean enJuego=true,bandera=false;
    public double getVelX() {
        return velX;
    }
    public void setVelX(double velX) {
        this.velX = velX;
    }
    public double getVelY() {
        return velY;
    }
    public void setVelY(double velY) {
        this.velY = velY;
    }

    public Snake() {
        t.start();
        //TODA ESTA MADRE ES PARA AGREGAR EL KEY LISTENER AL JPANEL
        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.darkGray);
        setFocusTraversalKeysEnabled(false);
    }
    private int elegirUbicacionX(){
        int dirX=1+rand.nextInt(565);
        return dirX;
    }
    private int elegirUbicacionY(){
        int dirY=1+rand.nextInt(535);
        return dirY;
    }
    public void paintComida(Graphics g){
        Graphics2D g3 = (Graphics2D) g;
        Rectangle2D rect1 = new Rectangle2D.Double(elegirUbicacionX(),elegirUbicacionY(),15,15);
        g3.setColor(Color.RED);
        g3.fill(rect1);
    }
    private void gameOver(Graphics g) {
        String msg = "Perdiste! :'v";
        Font letra = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(letra);
        g.setColor(Color.white);
        g.setFont(letra);
        g.drawString(msg, (600 - metr.stringWidth(msg)) / 2, 550 / 2);
    }
    public void paintComponent(Graphics g) {//ESTA WEA DIBUJA LOS COMPONENTES LAS COSAS AL JPANEL
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect = new Rectangle2D.Double(x, y, 20, 20);
        g2.setColor(Color.GREEN);
        g2.fill(rect);
        if (!colisionPared()){
            t.stop();
            gameOver(g);
        }
        paintComida(g);//ESTA WEA ANDA CRAZY AHORITA >:V
        Toolkit.getDefaultToolkit().sync();
    }
    private boolean colisionPared(){
        if (x < 0 || x > 580) {//SI ESTO ES CIERTO, TERMINAR EL JUEGO Y MOSTRAR PANTALLA DE GAME OVER
            velX = 0;
            velY=0;
            bandera=true;
        }
        if (y < 0 || y > 550) {//SI ESTO ES CIERTO, TERMINAR EL JUEGO Y MOSTRAR PANTALLA DE GAME OVER
            velY = 0;
            velX=0;
            bandera=true;
        }
        if (bandera){
            enJuego=false;
        }else{
            //SI NO HAY COLISION, X e Y SE SUMAN CON velX Y velY RESPECTIVAMENTE! NO BORRAR!!
            x += velX;
            y += velY;
        }
        return enJuego;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        colisionPared();// VERIFICA SI HAY COLISION CON UNA PARED, DE LO CONTRARIO MUEVE EL RECTANGULO
        repaint();//BUCLE QUE REDIBUJA EL FRAME
    }

    private void arriba() {
        velY = -1.5;
        velX = 0;
    }

    private void abajo() {
        velY = 1.5;
        velX = 0;
    }

    private void derecha() {
        velX = 1.5;
        velY = 0;
    }

    private void izquierda() {
        velX = -1.5;
        velY = 0;
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            System.out.println("TECLA PRESIONADA: " + keyCode);
            arriba();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            System.out.println("TECLA PRESIONADA: " + keyCode);
            abajo();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("TECLA PRESIONADA: " + keyCode);
            derecha();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            System.out.println("TECLA PRESIONADA: " + keyCode);
            izquierda();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }


}
