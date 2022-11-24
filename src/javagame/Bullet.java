/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author BENBENZ
 */
public class Bullet extends JPanel{
    public ImageIcon bullet = new ImageIcon();
    public int x;
    public int y;
    public int count=0;

    Bullet(int x,int y) {
        bullet = new ImageIcon(this.getClass().getResource("image/b2.png"));
        this.x = x;
        this.y = y;
    }
    
    
    
    public void move(){
        this.y -=  1;
    }
    public Rectangle2D getbound(){
        return(new Rectangle2D.Double(x, y, 20, 20));
    }
    
    
    
}
