/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author angel
 */
public class Game extends JPanel{
    
    public static int ancho = 800;
    public static int largo = 600;
    
    int score = 0;
    
    boolean balls[] = new boolean[11];
    
    Font font = new Font("Ubuntu", Font.BOLD, 16);
    Sbloques Bloques = new Sbloques(this);
    Spacman Pacman = new Spacman(this);
    Sballs Ball1 = new Sballs(this);
    Sballs Ball2 = new Sballs(this);
    Sballs Ball3 = new Sballs(this);
    Sballs Ball4 = new Sballs(this);
    Sballs Ball5 = new Sballs(this);
    Sballs Ball6 = new Sballs(this);
    Sballs Ball7 = new Sballs(this);
    Sballs Ball8 = new Sballs(this);
    Sballs Ball9 = new Sballs(this);
    Sballs Ball10 = new Sballs(this);
    
    JLabel txtScore = new JLabel("0");

    private void move() {
        Pacman.move();
    }
    
    public Game(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               Pacman.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            Pacman.keyReleased(e);
            }
        });
        setFocusable(true);
    }
    
    public void init(){
        
        txtScore.setBounds(10,10,300,300);
        txtScore.setFont(font);
        txtScore.setForeground(Color.WHITE);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        paintBalls(g2d);
        Pacman.paint(g2d);
        Bloques.paint(g2d);
        ballColli();
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(""+ScoreC(), 15, 25);
    }
    
    private int ScoreC(){
        score = 0;
        for(int i=0;i<balls.length;i++){
            if(balls[i]){
                score ++;
            }
        }
        return score;
    }
    
    private void paintBalls(Graphics2D g2d){
        if(!balls[0]) Ball1.paint(g2d,75,75);
        if(!balls[1]) Ball2.paint(g2d,150,75);
        if(!balls[2]) Ball3.paint(g2d,225,75);
        if(!balls[3]) Ball4.paint(g2d,300,75);
        
    }
    
    
    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Pacman");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
    private void ballColli(){
        if(!balls[0]) balls[0] = Ball1.getBounds().intersects(Pacman.getBounds());
        if(!balls[1]) balls[1] = Ball2.getBounds().intersects(Pacman.getBounds());
        if(!balls[2]) balls[2] = Ball3.getBounds().intersects(Pacman.getBounds());
        if(!balls[3]) balls[3] = Ball4.getBounds().intersects(Pacman.getBounds());
    }
}
