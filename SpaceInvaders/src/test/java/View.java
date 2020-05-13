import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class View extends JFrame{

    private JPanel panel;
    private int first=0;//first key pressed
    private int second=0;//second key pressed
    
    public int getFirst() {
    	return first;
    }
    
    public int getSecond() {
    	return second;
    }
    
    //initialize frame
    public void windowSetup(){
        setSize(1100,600);
        setBackground(Color.black);
        setLocation(200,100);
        
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(new ImageIcon("src/test/resources/icecream.PNG").getImage(),
                		GameBoard.getPlayer().getX(),GameBoard.getPlayer().getY(),
                		GameBoard.getPlayer().getWidth(),GameBoard.getPlayer().getHeight(),null);
            }
        };
        panel.setLocation(0,0);
        panel.setSize(1100,600);
        add(panel);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(first==0)first=-1;
                    else if(first==1)second = -1;
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    if(first==0)first=1;
                    else if(first==-1)second = 1;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                if(second==0)first=0;
                else if((e.getKeyCode()==KeyEvent.VK_LEFT&&second==1)
                		||(e.getKeyCode()==KeyEvent.VK_RIGHT&&second==-1)){
                    first=second;second=0;
                }else {
                    first=-second;second = 0;
                }
            }
        });
       
        
        
        
        setVisible(true);
    }//end of windowSetup()
    
    public int getXAxis() {
    	if(second==0){
            return first;
        }
        else {
            return second;
        }
    }
    
    
    


}
