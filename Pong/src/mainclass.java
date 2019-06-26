

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    int frames = 29;
    double numBalls = 1.0;
    boolean inGame = true;
    int i = 0;
    
    Font font = new Font("Ubuntu", Font.BOLD, 35);
    
    public static int ancho = 720;
    public static int largo = 1060;
    
    public static int Ry = ancho/2-100;
    public static boolean gamerun;
    
    public static mainclass game = new mainclass();
    public static JFrame ventana = new JFrame();
    Graphics g;

    JLabel labelNumBalls = new JLabel("Balls number: ");
    JLabel labelSpeed = new JLabel("Speed: ");
    
    JButton btnStart = new JButton("Play/Pause");
    JButton btnRestart = new JButton("Restart");
    JButton btnExit = new JButton("Exit");
    
    SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 2, 1.0);  
    JSpinner SpinnerNumBalls = new JSpinner(model1);
    JTextField txtNumBalls = new JTextField(1);
    JSlider Slider = new JSlider();
    
    public mainclass(){
        initComponets();
        hilo.start();
        
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               Raqueta1.keyPressed(e);
               Raqueta2.keyPressed(e);
               if(e.getKeyCode() == KeyEvent.VK_SPACE)
                    inGame = !inGame;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Raqueta1.keyReleased(e);
                Raqueta2.keyPressed(e);
            }
        });
        setFocusable(true);
        
        
    }
    
    private void initComponets(){
        this.setLayout(null);
        
        btnStart.setBounds(1, ancho-63, 130, 30);
        btnStart.setFocusable(false);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnStartActionPerformed(ae);
            }
        });
        add(btnStart);
        
        btnExit.setBounds(largo-68, ancho-63, 60, 30);
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnExitActionPerformed(ae);
            }
        });
        add(btnExit);
        
        btnRestart.setBounds(131, ancho-63, 100, 30);
        btnRestart.setFocusable(false);
        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnRestartActionPerformed(ae);
            }
        });
        add(btnRestart);
        
        labelNumBalls.setBounds(242, ancho-63, 90, 30);
        labelNumBalls.setFocusable(false);
        add(labelNumBalls);
        
        SpinnerNumBalls.setBounds(332, ancho-63, 35, 30);
        ((DefaultEditor) SpinnerNumBalls.getEditor()).getTextField().setEditable(false);
        SpinnerNumBalls.setFocusable(false);
        SpinnerNumBalls.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                SpinnerNumBallsstateChanged(ce);
            }
        });
        add(SpinnerNumBalls);
        
        labelSpeed.setBounds(377,ancho-63, 55, 30);
        labelSpeed.setFocusable(false);
        add(labelSpeed);
        
        Slider.setBounds(427,ancho-61, 120, 30);
        Slider.setValue(1);
        Slider.setFocusable(false);
        Slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                SliderstateChanged(ce);
            }
        });
        add(Slider);
    }
    
    private void btnStartActionPerformed(ActionEvent e){
        inGame = !inGame;
    }
    
    private void btnExitActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    private void btnRestartActionPerformed(ActionEvent e){
        restart();
    }
    
    private void restart(){
        ScoreP1 = 0;
        ScoreP2 = 0;
        Pelota.x = largo/2;
        Pelota.y = ancho/2;
        Pelota2.x = largo/2;
        Pelota2.y = ancho/2;
        Raqueta1.Y = Ry;
        Raqueta2.Y = Ry;
        Raqueta1.velocidadY = 0;
        Raqueta2.velocidadY = 0;
        SpinnerNumBalls.setValue(1.0);
        numBalls = 1;
    }
    
    private void SpinnerNumBallsstateChanged(ChangeEvent e){
        numBalls = (double) SpinnerNumBalls.getValue();
        this.requestFocus();
    }
    
    private void SliderstateChanged(ChangeEvent e){
        System.out.println(""+Slider.getValue());
        if(Slider.getValue() >=1 && 10<= Slider.getValue()){
            frames = 29;
        }
        if(Slider.getValue() >=11 && 20< Slider.getValue()){
            frames = 27;
        }
        if(Slider.getValue() >21 && 30< Slider.getValue()){
            frames = 25;
        }
        if(Slider.getValue() >31 && 40< Slider.getValue()){
            frames = 23;
        }
        if(Slider.getValue() >41 && 50< Slider.getValue()){
            frames = 21;
        }
        if(Slider.getValue() >51 && 60< Slider.getValue()){
            frames = 19;
        }
        if(Slider.getValue() >61 && 70< Slider.getValue()){
            frames = 17;
        }
        if(Slider.getValue() >71 && 80< Slider.getValue()){
            frames = 15;
        }
        if(Slider.getValue() >81 && 90< Slider.getValue()){
            frames = 13;
        }
        if(Slider.getValue() >91 && 100< Slider.getValue()){
            frames = 11;
        }
        
        /*
        switch (Slider.getValue()){
            case 1 :
                frames = 29;
            case 10  :
                frames = 29;
        }
        */
    }
    
    public void move() {
        if(inGame){
        Raqueta1.move();
        Raqueta2.move();
        if(numBalls > 0){
            Pelota.move();
        if(numBalls > 1){
            Pelota2.move();
        }
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
        if(Pelota.y+30 >= ancho-72)
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
        if(Pelota2.y+30 >= ancho-72)
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
        }
    }
    
    public void paint(Graphics g) {
        if(inGame){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(10,240,60));
        g2d.setFont(font);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight()-32);
        Raqueta1.paint(g2d,0);
        Raqueta2.paint(g2d,(largo-30));
        g2d.setColor(Color.white);
        g2d.drawLine(largo/2, 0, largo/2, ancho-67);
        if(numBalls>0){
            Pelota.paint(g2d);
            if(numBalls>1){
                Pelota2.paint(g2d);
            }
        }
        g2d.drawString( " " +ScoreP1,460,40);
        g2d.drawString( " " +ScoreP2,540,40);
        g2d.drawString( "Player 1" ,60,40);
        g2d.drawString( "Player 2" ,860,40);
        }
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
        
        ventana.setSize(mainclass.largo, mainclass.ancho);
        ventana.add(game);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Pong");
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    private int winner(){
        int WinnerInt = 0;
        if(ScoreP1 == 5){
            WinnerInt = 1;
        }
        else if(ScoreP2 == 5){
            WinnerInt = 2;
        }
        return WinnerInt;
    }
    
    @Override
    public void run() {
        while(i != 1){
            game.move();
            game.repaint();
            try {
                Thread.sleep(1600);
            } catch (InterruptedException ex) {
                Logger.getLogger(mainclass.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
        inGame = false;
        //System.out.println(""+inGame);
        while(true){
            //System.out.println("asd");
            try {
                Thread.sleep(frames);
            } catch (InterruptedException ex) {
                Logger.getLogger(mainclass.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(winner() != 0){
                JOptionPane.showMessageDialog(null, "Winner: Player "+winner());
                ScoreP1 = 0;
                ScoreP2 = 0;
                Pelota.x = largo/2;
                Pelota.y = ancho/2;
                Pelota2.x = largo/2;
                Pelota2.y = ancho/2;
                Raqueta1.Y = Ry;
                Raqueta2.Y = Ry;
                Raqueta1.velocidadY = 0;
                Raqueta2.velocidadY = 0;
                SpinnerNumBalls.setValue(1.0);
                numBalls = 1;
                inGame = false;
                
            }
            if(inGame){
                //System.out.println(""+inGame);
                game.move();
                game.repaint();
 
            }
        }
    }
    
}
