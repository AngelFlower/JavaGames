/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodelgato;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author angel
 */
public class JuegoDelGato extends JFrame{
    
    public static JPanel paneMain;
    
    public JuegoDelGato(){
        getContentPane().setLayout(new GridLayout(1,0));
        paneMain.setLayout(new GridLayout(1,0));
        Welcome_Pane pWelcome_Pane = new Welcome_Pane();
        paneMain.add(pWelcome_Pane);
        getContentPane().add(paneMain);
    }
    
    public static void main(String[] args) {
        JuegoDelGato ventana = new JuegoDelGato();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);
        ventana.setSize(400,380);
        ventana.setVisible(true);
        ventana.setResizable(false);
    }
    
}
