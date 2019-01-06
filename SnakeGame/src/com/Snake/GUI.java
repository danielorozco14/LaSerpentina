package com.Snake;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    public GUI() {
        super("La Serpentina");
        initialComponents();
    }
    public void initialComponents() {
        Snake sr = new Snake();
        Container contains = getContentPane(); //SE DECLARA UN CONTENEDOR, EL CUAL ALMACENA TODOS LOS ELEMENTOS QUE CONTENDRA LA VENTANA

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);// Sirve para habilitar o no, que se modifique el tamanio de la ventana
        setSize(600, 600); //SETEANDO TAMANIO DE LA VENTANA
        setLocationRelativeTo(null);
        //setLocationByPlatform(true);
        contains.add(sr);//se agrega el panel snake al JFrame
        //contains.setBackground(Color.DARK_GRAY);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               new GUI().setVisible(true);
            }
        });
    }

}


