/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author BENBENZ
 */
public class homegame extends JPanel{

    //1000 700
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("image/bg.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("image/exit.jpg"));
    private  ImageIcon start = new ImageIcon(this.getClass().getResource("image/start.jpg"));
    public JButton BExit1 = new JButton(exit);
    public  JButton BStart = new JButton(start);
    homegame() {
        setLayout(null);
        BExit1.setBounds(415, 400, 170, 90);
        add(BExit1);
        BStart.setBounds(415, 550, 170, 90);
        add(BStart);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(bg.getImage(), 0, 0, 1000, 800,this);        
    }
    
}
