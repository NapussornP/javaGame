/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagame;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;

/**
 *
 * @author BENBENZ
 */
public class Monster {
    Image img;
    public int x = (int)((Math.random()*300)+20);
    public int y = 0;
    public int count = 0;

    Monster() {
        URL imageURL = this.getClass().getResource("image/mon1.png");
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        run.start();
    }
    
    Thread run = new Thread(new Runnable(){
        @Override
        public void run() {
            while (true) {
                y += 2;
                if( y >= 1100){
                    img = null;
                    run = null;
                    x = -500;
                    y = -500;
                }
                try {
                    run.sleep(7);
                } catch (InterruptedException e) {}
                
            }
        }
        
    });
    
    public Image getImage(){
        return img;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Rectangle2D getbound(){
        return (new Rectangle2D.Double(x, y, 100, 100));
    }
    
    
    
}
