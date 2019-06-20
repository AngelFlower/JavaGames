/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelgato;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author angel
 */
public class Welcome_Pane extends JPanel{
    public Welcome_Pane(){
        initComponents();
    }
    
    private void initComponents(){
        setLayout(new GridLayout(1,));
        JPanel pWelcome = new JPanel();
        
        JLabel txtTitle = new JLabel("Juego del Gato");
        JButton btnStart = new JButton("Play");
        
        pWelcome.setLayout(new FlowLayout());
        pWelcome.add(txtTitle);
        
        add.(pWelcome,1,0);
   
    }
}
