/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagame;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author BENBENZ
 */
public class Cannon {
    public ImageIcon im = new ImageIcon();
    public  int x;
    public int count = 0;

    Cannon() {
        //URL imageURL = this.getClass().getResource("image/cannon1.png");
        im = new ImageIcon(this.getClass().getResource("image/cannon1.png"));
    }
    
    
}
