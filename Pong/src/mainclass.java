

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class mainclass extends JPanel implements Runnable{
    
    Thread hilo = new Thread(this);
    
    Raqueta_1 Raqueta1 = new Raqueta_1(this);
    Raqueta_2 Raqueta2 = new Raqueta_2(this);
    Ball Pelota = new Ball(this);
    Ball2 Pelota2 = new Ball2(this);
    int ScoreP1 = 0;
    int ScoreP2 = 0;
    
    Font font = new Font("Ubuntu", Font.BOLD, 40);
    
    public static int ancho = 700;
    public static int largo = 1060;
    
    public static int Ry = ancho/2-100;
    public static boolean gamerun;
    
    public static mainclass game = new mainclass();
    public static JFrame ventana = new JFrame();
    Graphics g;
    
    
    
    public mainclass(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               Raqueta1.keyPressed(e);
               Raqueta2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Raqueta1.keyReleased(e);
                Raqueta2.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    
    public void move() {
        
        Raqueta1.move();
        Raqueta2.move();
        Pelota.move();
        Pelota2.move();
        if(colision1()){
            System.out.println("Pelota choca con raqueta 1");
            Pelota.velocidadX = (Pelota.velocidadX * -1);
        }
        if(colision2()){
            Pelota.velocidadX = (Pelota.velocidadX * -1);
            System.out.println("Pelota choca con raqueta 2");
        }
        if(Pelota.y <=0)
            Pelota.velocidadY = (Pelota.velocidadY * -1);
        if(Pelota.y+60 >= ancho)
            Pelota.velocidadY = (Pelota.velocidadY * -1);
        if(Pelota.x > largo){
            Pelota.x = largo/2;
            Pelota.y = ancho/2;
            ScoreP1 ++;
        }
        if(Pelota.x < 0){
            Pelota.x = largo/2;
            Pelota.y = ancho/2;
            ScoreP2 ++;
        }
        
        ///
        
        if(colision3()){
            System.out.println("Pelota choca con raqueta 1");
            Pelota2.velocidadX = (Pelota2.velocidadX * -1);
        }
        if(colision4()){
            Pelota2.velocidadX = (Pelota2.velocidadX * -1);
            System.out.println("Pelota choca con raqueta 2");
        }
        if(Pelota2.y <=0)
            Pelota2.velocidadY = (Pelota2.velocidadY * -1);
        if(Pelota2.y+60 >= ancho)
            Pelota2.velocidadY = (Pelota2.velocidadY * -1);
        if(Pelota2.x > largo){
            Pelota2.x = largo/2;
            Pelota2.y = ancho/2;
            ScoreP1 ++;
        }
        if(Pelota2.x < 0){
            Pelota2.x = largo/2;
            Pelota2.y = ancho/2;
            ScoreP2 ++;
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(10,240,60));
        g2d.setFont(font);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        Raqueta1.paint(g2d,0);
        Raqueta2.paint(g2d,(largo-30));
        g2d.setColor(Color.white);
        g2d.drawLine(largo/2, 0, largo/2, ancho);
        Pelota.paint(g2d);
        Pelota2.paint(g2d);
        g2d.drawString( " " +ScoreP1,460,40);
        g2d.drawString( " " +ScoreP2,540,40);
    }
    
    
    
    public boolean colision1(){
        return Raqueta1.getbounds().intersects(Pelota.getbounds());
    }
    public boolean colision2(){
        return Raqueta2.getbounds().intersects(Pelota.getbounds());
    }
    public boolean colision3(){
        return Raqueta1.getbounds().intersects(Pelota2.getbounds());
    }
    public boolean colision4(){
        return Raqueta2.getbounds().intersects(Pelota2.getbounds());
    }
    public static void main(String[] args) {
        
        
        Menu menu = new Menu();
        mainclass Game = new mainclass();
        ventana.add(game);
        ventana.setSize(mainclass.largo, mainclass.ancho);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Pong");
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        while(true){
            try {
                game.move();
                game.repaint();
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(mainclass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void startGame(){
        mainclass main = new mainclass();
        main.run();
    }
    
    @Override
    public void run() {
        while(true){
            try {
                this.move();
                this.repaint();
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(mainclass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
