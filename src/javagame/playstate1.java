/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author BENBENZ
 */
public class playstate1 extends JPanel implements ActionListener{

    private ImageIcon img1 = new ImageIcon(this.getClass().getResource("image/bg2.png"));
    
    homegame hg = new homegame();
    Cannon c = new Cannon();
    ImageIcon over = new ImageIcon(this.getClass().getResource("image/gover.png"));
    ImageIcon exitover = new ImageIcon(this.getClass().getResource("image/exit.jpg"));
    ImageIcon mon = new ImageIcon(this.getClass().getResource("image/mon1.png"));
    
    
    JButton jbtExit = new JButton(exitover);
    
    private JLabel score1 = new JLabel("SCORE: ");
    
    public ArrayList<Bullet> bullet = new ArrayList<Bullet>();
    public ArrayList<Monster> mons = new ArrayList<Monster>();
    
    public int times;
    boolean timestart = true;
    boolean startCannon = false;
    
    
    public int score = 0;
    
    Thread time = new Thread(new Runnable(){
        @Override
        public void run() { 
            while(true){
                try{
                    Thread.sleep(10);
                }catch(Exception e){}
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    
    Thread cannon = new Thread(new Runnable(){
        @Override
        public void run() { 
            while(true){
                try{
                    Thread.sleep(1);
                }catch(Exception e){}
                repaint();
                
            }
        }
    });
    
    Thread bull = new Thread(new Runnable(){
        @Override
        public void run() { 
            while(true){
                try{
                    if(startCannon == false){
                        Thread.sleep((long)(Math.random()*1000)+2000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(startCannon == false){
                    mons.add(new Monster());
                    repaint();
                }
            }
        }
    });
    

    
     Thread tm = new Thread(new Runnable(){
        @Override
        public void run() { 
            while(true){
                if(timestart == false){
                    times = times - 1;
                }
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){e.printStackTrace();}
            }
        }
    });

    playstate1() {
        this.setFocusable(true);
        this.setLayout(null);
        jbtExit.addActionListener(this);
        
        this.add(jbtExit);
        
        this.add(score1);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                //int get = e.getKeyCode();
                
                    if(e.getKeyCode() == KeyEvent.VK_LEFT){
                        c.x -= 10;
                        c.count++;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                        c.x += 10;
                        c.count++;
                    }
                    if(c.count > 3){
                        c.count=0;
                    }
                    else if(e.getKeyCode() == KeyEvent.VK_UP){
                        c.count = 5;
                        bullet.add(new Bullet(c.x,600));
                        //repaint();
                    }
                }
            
            public void keyReleased(KeyEvent e){
                c.count = 0;
            }
        });
        c.x = 400;
        time.start();;
        cannon.start();
        tm.start();
        bull.start();
    }
    
    public  void paintComponent(Graphics g){
        super.paintComponent(g);
        if(times <= 0 ){
            this.remove(jbtExit);
            this.setLayout(null);
            g.drawImage(over.getImage(), 0,0, 1000, 800, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.CENTER_BASELINE,50));
            g.drawString("Score: "+score, 400, 520);
            jbtExit.setBounds(415, 550, 170, 90);
            add(jbtExit);
            
        }
        else{
                g.drawImage(img1.getImage(), 0, 0, 1000, 800, this);
                g.drawImage(c.im.getImage(), c.x, 660, 110, 160, this);
                g.setColor(Color.white);
                g.setFont(new Font("Arial",Font.CENTER_BASELINE,35));
                g.drawString("Score: "+score, 20, 50);
                g.setFont(new Font("Arial",Font.CENTER_BASELINE,50));
                g.drawString("Time "+times, 740, 700);
            
                if(c.x < 0){
                    c.x = this.getWidth()-10;
                }
                if(c.x > this.getWidth()){
                    c.x = 20;
                }
                for(int i = 0;i < bullet.size();i++){
                    Bullet bl = bullet.get(i);
                    g.drawImage(bl.bullet.getImage(), bl.x, bl.y, 50, 70, null);
                    bl.move();
                    bl.count++;
                    if(bl.y < 0){
                        bullet.remove(i);
                }
            }
            
            //----------mons-----------------
            for(int i = 0; i < mons.size();i++){
                g.drawImage(mons.get(i).getImage(), mons.get(i).getX(), mons.get(i).getY(), 150, 150, this);
            }
            for(int i = 0;i < bullet.size();i++){
                for(int j = 0; j < mons.size();j++){
                    if(Overlap(bullet.get(i).getbound(), mons.get(j).getbound())){
                        mons.remove(j);
                        bullet.remove(i);
                        score += 5;
                    }
                }
            }
        }
    }
    
    public boolean Overlap(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == jbtExit){
            System.exit(0);
        }
    }
    
}
