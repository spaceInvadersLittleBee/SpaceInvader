import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class View extends JFrame{

    JPanel panel;
    int x = 350;
    int y = 50;
    int v = 0;
    int first=0;
    int second=0;
    int dir = 10;
    
    
    //initialize frame
    public void windowSetup(){
        setSize(1100,600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setLocation(200,100);
        panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                if (dir==10)g.drawImage(new ImageIcon("icecream.PNG").getImage(),x,y,300,300,null);
                else g.drawImage(new ImageIcon("icecream.PNG").getImage(),x,y,300,300,null);
                
            }
        };
        panel.setLocation(0,0);
        panel.setBackground(Color.blue);
        panel.setSize(1100,600);
        add(panel);
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    if(first==0)first=-10;
                    else if(first==10)second = -10;
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    if(first==0)first=10;
                    else if(first==-10)second = 10;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                if(second==0)first=0;
                else if((e.getKeyCode()==KeyEvent.VK_LEFT&&second==10)||(e.getKeyCode()==KeyEvent.VK_RIGHT&&second==-10)){
                    first=second;second=0;
                }else {
                    first=-second;second = 0;
                }
            }
        });
        
        GameBoard.boardSetup();
        
        Timer timer = new Timer(17,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
        timer.start();
        setVisible(true);
    }
    
    //update is called once per frame
    public void update(){
        if(second==0){
            x = x+first;if(first!=0)dir = first;
        }
        else {
            x = x+second;dir = second;
        }
        y=y+v;
        v=v+((100-y)/20);
        repaint();
    }
    
    


}
