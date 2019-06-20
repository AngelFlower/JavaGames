/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Spacman{
    private static final int WITH = 50;
    private static final int HEIGHT = 50;
    int angulo = -141;
    int boca = 270;
    double coliX = 0;
    int contadorA = 0;
    boolean animation;
    int y;
    int x = 40;
    int velocidadX = 0;
    int velocidadY = 0;
    double a;

    private Game game;
    public Spacman(Game game) {
        y = game.largo/2-(HEIGHT/2);
        x = game.ancho/2-(WITH/2);
        this.game= game;
    }
    public void move() {
            if(x + WITH > game.getWidth()+WITH){
                x = 0 ;
            }
            if(x + WITH < 0){
                x = game.getWidth();
            }
            if(y + HEIGHT > game.getHeight()+HEIGHT){
                y = -50 ;
            }
            if(y + HEIGHT < 0){
                y = game.getHeight();
            }
            
            if(!(valueCollision() + velocidadY < y + velocidadY +1)){
                y = y + velocidadY;
            }
            else{
                if(valueCollision() == y)
                    y = y+ 3;
            }
            if(!(valueCollision() + velocidadY > y+HEIGHT + velocidadY -6)){
                y = y + velocidadY;
            }
            else{
                if(valueCollision() > x+HEIGHT - 6)
                    y = y - 3;  
            }
            
            if(!(coliX + velocidadX < x + velocidadX +1)){
                x = x + velocidadX;
            }
            else{
                if(collision()){
                if(coliX  == x)
                    x = x+ 3;
                }
            }
            if(!(coliX + velocidadX > x+WITH + velocidadX -6)){
                x = x + velocidadX;
            }
            else{
                if(collision()){
                    if(coliX > x+WITH - 6)
                        x = x - 3;  
                }
            }
            coliX = 0;
    }
    
    public void paint(Graphics2D g) {
        g.setColor(Color.yellow);
        if(contadorA == 13){
            contadorA = 0;
            animation = !animation;
        }
        if(animation){
            bocaAnimation(-13);
        }
        else
            bocaAnimation(13);
        g.fillArc(x, y, WITH, HEIGHT, angulo, boca);
    }
    
    public void keyReleased(KeyEvent e) {
        velocidadX = 0;
        velocidadY = 0;
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            velocidadX = -3;
            angulo = - 141;      
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            velocidadX = 3;
            angulo = 34;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            velocidadY = -3;
            angulo = 130;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            velocidadY = 3;
            angulo = -50; 
        }
        
    }
    
    public void bocaAnimation(int sumador){
        if(boca < 270){
            contadorA = 13;
            boca = 270; 
        }
        else{
            boca+=sumador/2;
            contadorA++;
            angulo+= sumador/10;
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, WITH, HEIGHT);
    }
    
    private boolean collision(){
        return game.Bloques.getBoundsCol1().intersects(getBounds()) ||
               game.Bloques.getBoundsCol2().intersects(getBounds()) ||
               game.Bloques.getBoundsCol3().intersects(getBounds()) ||
               game.Bloques.getBoundsCol4().intersects(getBounds()) ||
               game.Bloques.getBoundsCol5().intersects(getBounds()) ||
               game.Bloques.getBoundsCol6().intersects(getBounds()) ||
               game.Bloques.getBoundsCol7().intersects(getBounds()) ||
               game.Bloques.getBoundsCol8().intersects(getBounds()) ||
               game.Bloques.getBoundsCol9().intersects(getBounds()) ||
               game.Bloques.getBoundsCol10().intersects(getBounds()) ||
               game.Bloques.getBoundsCol11().intersects(getBounds());
    }
    private double valueCollision(){
        
        a = 0;
        if(game.Bloques.getBoundsCol1().intersects(getBounds())){
            a = game.Bloques.getBoundsCol1().intersection(getBounds()).getY();
            coliX = game.Bloques.getBoundsCol1().intersection(getBounds()).getX();
        }
        else{
            if(game.Bloques.getBoundsCol2().intersects(getBounds())){
            a = game.Bloques.getBoundsCol2().intersection(getBounds()).getY();
            coliX = game.Bloques.getBoundsCol2().intersection(getBounds()).getX();
            }
            else {
                if(game.Bloques.getBoundsCol3().intersects(getBounds())){
                a = game.Bloques.getBoundsCol3().intersection(getBounds()).getY();
                coliX = game.Bloques.getBoundsCol3().intersection(getBounds()).getX();
                }
                else{
                    if(game.Bloques.getBoundsCol4().intersects(getBounds())){
                    a = game.Bloques.getBoundsCol4().intersection(getBounds()).getY();
                    coliX = game.Bloques.getBoundsCol4().intersection(getBounds()).getX();
                    }
                    else{
                        if(game.Bloques.getBoundsCol5().intersects(getBounds())){
                        a = game.Bloques.getBoundsCol5().intersection(getBounds()).getY();
                        coliX = game.Bloques.getBoundsCol5().intersection(getBounds()).getX();
                        }
                        else{
                            if(game.Bloques.getBoundsCol6().intersects(getBounds())){
                            a = game.Bloques.getBoundsCol6().intersection(getBounds()).getY();
                            coliX = game.Bloques.getBoundsCol6().intersection(getBounds()).getX();
                            }
                            else{
                                if(game.Bloques.getBoundsCol7().intersects(getBounds())){
                                a = game.Bloques.getBoundsCol7().intersection(getBounds()).getY();
                                coliX = game.Bloques.getBoundsCol7().intersection(getBounds()).getX();
                                }
                                else{
                                    if(game.Bloques.getBoundsCol8().intersects(getBounds())){
                                    a = game.Bloques.getBoundsCol8().intersection(getBounds()).getY();
                                    coliX = game.Bloques.getBoundsCol1().intersection(getBounds()).getX();
                                    }
                                    else{
                                        if(game.Bloques.getBoundsCol9().intersects(getBounds())){
                                        a = game.Bloques.getBoundsCol9().intersection(getBounds()).getY();
                                        coliX = game.Bloques.getBoundsCol9().intersection(getBounds()).getX();
                                        }
                                        else{
                                            if(game.Bloques.getBoundsCol10().intersects(getBounds())){
                                            a = game.Bloques.getBoundsCol10().intersection(getBounds()).getY();
                                            coliX = game.Bloques.getBoundsCol10().intersection(getBounds()).getX();
                                            }
                                            else{
                                                if(game.Bloques.getBoundsCol11().intersects(getBounds())){
                                                a = game.Bloques.getBoundsCol11().intersection(getBounds()).getY();
                                                coliX = game.Bloques.getBoundsCol11().intersection(getBounds()).getX();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                            
            }
        }
        return a;
    }
    public int getTopY() {
        return y - HEIGHT;
    }

    
}
