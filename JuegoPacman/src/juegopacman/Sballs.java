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
public class Sballs {
    private Game game;
    int X,Y;
    
    public Sballs(Game game){
        this.game = game;
    }
    
    public void paint(Graphics2D g, int x, int y) {
        X = x; Y = y;
        g.setColor(new Color(250,250,250));
        g.fillOval(x, y, 20, 20);
    }
    public Rectangle getBounds() {
        return new Rectangle(X, Y,20, 20);
    }
}
