
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class Raqueta_1 {
    
    
    public int velocidadY = 0;
    public int Y = mainclass.Ry;
    int X;
    
    private mainclass main;
    public Raqueta_1(mainclass main){
        this.main= main;
    }
    
    public void move(){
        if(Y+200 >= mainclass.ancho){
            //Y = mainclass.ancho-221;
            velocidadY = -7;
            Y += velocidadY;
        }
        else{
            if(Y <= 0){
                velocidadY = 7;
                Y += velocidadY;
            }
            else
            Y += velocidadY;
        }
    }
    
    public void paint(Graphics2D g, int x) {
        g.setColor(Color.WHITE);
        g.fillRect(x, Y, 30, 200);
        X = x;
    }
    
    public void keyReleased(KeyEvent e){
        //velocidadY = 0;
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W){
            velocidadY = -7;      
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            velocidadY = 7;
        }
    }
    
    public Rectangle getbounds(){
        return new Rectangle(X,Y,30,200);
    }
}
