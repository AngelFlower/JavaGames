
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class Ball2 {
    
    int y = mainclass.ancho/2;
    int x = mainclass.largo/2;
    int velocidadX = 11;
    int velocidadY = -11; 
    
    private mainclass main;
    
    public Ball2(mainclass main){
        this.main = main;
    }
    
    public void move(){
        x += velocidadX;
        y += velocidadY;
        
    }
    
    public void paint(Graphics2D g) {
        g.setColor(Color.white);
        g.fillOval(x, y, 40, 40);
    }
    
    public Rectangle getbounds(){
        return new Rectangle(x,y,40,40);
    }
    
}
