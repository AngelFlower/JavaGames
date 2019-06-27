package main;

import efectos.MaterialColor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import principal.MaterialButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angel
 */
public class About extends JDialog {

    public About() {
        initComponents();
    }

    private void initComponents() {

        this.setLayout(null);

        JPanel panelTitle = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel panelContent = new JPanel();
        JPanel panelCTitle = new JPanel();
        JPanel panelCContent = new JPanel();

        panelTitle.setBounds(0, 0, 400, 80);
        panelTitle.setBackground(new Color(249, 249, 249));
        panelTitle.setLayout(new GridBagLayout());

        panelContent.setBounds(0, 70, 400, 312);
        panelContent.setBackground(new Color(244, 244, 244));
        panelContent.setLayout(new BorderLayout());
        
        panelCTitle.setOpaque(false);
        panelCContent.setOpaque(false);
        panelCContent.setLayout(new GridBagLayout());

        MaterialButton btnOk = new MaterialButton();
        btnOk.setText("OK");
        btnOk.setBounds(140, 340, 120, 50);
        btnOk.setBackground(MaterialColor.BLUEA_100);
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnOkActionPerformed();
            }
        });
        
        
        JLabel labelTitle = new JLabel(""
                + "<html>"
                + "<h1>About</h1>"
                + "</html>");
        
        JLabel labelDescription = new JLabel(""
                + "<html>"
                + "<style>"+styles.style.getText()+"</style>"
                + "<h2>CECyTEM Plantel Xonacatlán</h2>"
                + "<h2 class='display-1'>Members:</h2>"
                + "<div class='card'>"
                + "<h4>Angel Flores Carlos            403</h4>"
                + "<p><h4>Héctor Gutierrez Gutierrez  403</h4></p>"
                + "</div>"
                + "<br></br>"
                + "</html>");

        labelTitle.setBounds(0, 20, 100, 40);
        panelTitle.add(labelTitle, new GridBagConstraints());
        
        labelDescription.setBounds(0, 0, 200, 100);
        panelCContent.add(labelDescription, new GridBagConstraints());
        

        this.setSize(400, 435);

        panelContent.add(panelCContent, BorderLayout.CENTER);
        
        add(btnOk);
        add(panelTitle);
        add(panelContent);
        
    }
    
    private void btnOkActionPerformed(){
        this.dispose();
    }

    public static void main(String[] args) {

        About Dialog = new About();
        Dialog.setResizable(false);
        Dialog.setVisible(true);
        Dialog.setLocationRelativeTo(null);
        Dialog.setModal(true);
        Dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });;
    }
}
