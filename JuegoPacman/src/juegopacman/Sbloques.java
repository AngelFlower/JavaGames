/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static juegopacman.Game.ancho;
import static juegopacman.Game.largo;

/**
 *
 * @author angel
 */
public class Sbloques{
    
    
    private Game game;
    
    public Sbloques(Game game){
        this.game = game;
    }
    
    public void paint(Graphics2D g) {
        g.setColor(new Color(1,1,255));
        g.drawRoundRect(5,5, (ancho/2 -75), 30, 10, 10);
        g.drawRoundRect((ancho/2 +75),5, (ancho/2 - 85), 30, 10, 10);
        
        g.drawRoundRect(5,largo-70, (ancho/2 -75), 30, 10, 10);
        g.drawRoundRect((ancho/2 +75),largo-70, (ancho/2 - 85), 30, 10, 10);
        
        g.drawRoundRect(5,35, 30, largo/2 -95, 10, 10);
        g.drawRoundRect(ancho-40,35, 30, largo/2 -95, 10, 10);
        
        g.drawRoundRect(5,largo/2+20, 30, largo/2 -95, 10, 10);
        g.drawRoundRect(ancho-40,largo/2+20, 30, largo/2 -95, 10, 10);
 
        g.drawRoundRect(ancho/2-100,largo/2-50, 30, 100, 10, 10);
        g.drawRoundRect(ancho/2+70,largo/2-50, 30, 100, 10, 10);
        g.drawRoundRect(ancho/2-100, largo/2+50, 200, 30, 10, 10);
    }
    
    public Rectangle getBoundsCol1() {
        return new Rectangle(5, 3,(ancho/2 -75), 30);
    }
    
    public Rectangle getBoundsCol2() {
        return new Rectangle((ancho/2 +75),3, (ancho/2 - 85), 30);
    }
    /*as*/
    public Rectangle getBoundsCol3() {
        return new Rectangle(5,largo-70, (ancho/2 -75), 30);
    }
    
    public Rectangle getBoundsCol4() {
        return new Rectangle((ancho/2 +75),largo-70, (ancho/2 - 85), 30);
    }
    public Rectangle getBoundsCol5() {
        return new Rectangle(5,35, 30, largo/2 -95);
    }
    
    public Rectangle getBoundsCol6() {
        return new Rectangle(ancho-40,35, 30, largo/2 -95);
    }
    
    public Rectangle getBoundsCol7() {
        return new Rectangle(5,largo/2+20, 30, largo/2 -95);
    }
    
    public Rectangle getBoundsCol8() {
        return new Rectangle(ancho-40,largo/2+20, 30, largo/2 -95);
    }
    public Rectangle getBoundsCol9() {
        return new Rectangle(ancho/2-100,largo/2-50, 30, 100);
    }
    
    public Rectangle getBoundsCol10() {
        return new Rectangle(ancho/2+70,largo/2-50, 30, 100);
    }
    
    public Rectangle getBoundsCol11() {
        return new Rectangle(ancho/2-100, largo/2+50, 200, 30);
    }
    
}
