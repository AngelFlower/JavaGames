
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angel
 */
public class ClasePrincipal extends JFrame{
    
    public static JPanel panelMain = new JPanel();
    
    public static void main(String[] args) {
        ClasePrincipal ventana = new ClasePrincipal();
        panelMain.setLayout(new GridLayout(1,1));
        Menu menu = new Menu();
        panelMain.add(menu);
        ventana.add(panelMain);
        ventana.setSize(mainclass.largo, mainclass.ancho);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Pong");
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
}
