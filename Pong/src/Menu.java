
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class Menu extends JPanel{
    
    Font font = new Font("Ubuntu", Font.ITALIC, 80);
    
    JButton btnPlay = new JButton("Play");
    JLabel txtTituloS = new JLabel("Pong Game");
    JLabel txtTitulo = new JLabel("Pong Game");
    
    
    public Menu(){
        
        initComponentes();
        
    }
    
    private void initComponentes(){
        //this.setSize(mainclass.ancho,mainclass.largo);
        this.setBackground(new Color(100,100,250));
        this.setLayout(null);
        
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnPlayAction(ae);
            }
        });
        
        btnPlay.setBounds(465,350,130,70);
        btnPlay.setFocusPainted(false);
        btnPlay.setBackground(Color.white);
        add(btnPlay);
        
        txtTitulo.setFont(font);
        txtTitulo.setForeground(Color.white);
        txtTitulo.setBounds(290, 180, 530, 100);
        add(txtTitulo);
        
        txtTituloS.setFont(font);
        txtTituloS.setForeground(Color.black);
        txtTituloS.setBounds(293, 183, 530, 100);
        add(txtTituloS);
        
        
    }
    
    private void btnPlayAction(ActionEvent e){
        /*
        mainclass Game = new mainclass();
        
        ClasePrincipal.panelMain.removeAll();
        ClasePrincipal.panelMain.add(Game);
        ClasePrincipal.panelMain.revalidate();
        ClasePrincipal.panelMain.repaint();
        */
        mainclass.game.gamerun = true;
        mainclass.ventana.removeAll();
        mainclass.ventana.add(mainclass.game);
        mainclass.ventana.revalidate();
        mainclass.ventana.repaint();
        
        //frame.dispose();
        
    }
    
}
