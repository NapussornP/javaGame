/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author BENBENZ
 */
public class PlayGame extends JFrame implements ActionListener{
    homegame homegame1 = new homegame();
    playstate1 state = new playstate1();

    public PlayGame(){
        this.setSize(1000, 800);
        this.add(homegame1);
        homegame1.BExit1.addActionListener(this);
        homegame1.BStart.addActionListener(this);
        state.jbtExit.addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == homegame1.BStart){
           this.setLocationRelativeTo(null);
           this.remove(homegame1);
           this.setSize(1000, 800);
           this.add(state);
           state.requestFocusInWindow();
           state.timestart =false;
           state.score = 0;
           
           state.times = 100;
           state.startCannon = false;
           state.timestart = false;
       }
       else if(e.getSource() == homegame1.BExit1){
           System.exit(0);
       }
       else if(e.getSource() == state.jbtExit)
       {
           System.exit(0);
       }
       this.validate();
       this.repaint();
    }
    
    public static void main(String[] args) {
        JFrame frame = new PlayGame();
        frame.setSize(1000, 800);
        frame.setTitle("Monster Hunt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
}
