package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.GameBoard;

public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private int first=0;//first key pressed
    private int second=0;//second key pressed
    private boolean shooting;
    
    
    
    //initialize frame
    public void windowSetup(){
        setSize(1100,600);
        setBackground(Color.black);
        setLocation(200,100);
        
        panel = new JPanel(){
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void paint(Graphics g){
                g.drawImage(GameBoard.getGameBoard().getPlayer().getImage(),
                		GameBoard.getGameBoard().getPlayer().getX(),GameBoard.getGameBoard().getPlayer().getY(),
                		GameBoard.getGameBoard().getPlayer().getWidth(),GameBoard.getGameBoard().getPlayer().getHeight(),null);
                for(int i = 0; i < GameBoard.getGameBoard().getEnemies().size();i++) {
                	g.drawImage(GameBoard.getGameBoard().getEnemies().get(i).getImage(),
                		GameBoard.getGameBoard().getEnemies().get(i).getX(),GameBoard.getGameBoard().getEnemies().get(i).getY(),
                		GameBoard.getGameBoard().getEnemies().get(i).getWidth(),GameBoard.getGameBoard().getEnemies().get(i).getHeight(),null);
                }
                for(int i = 0; i < GameBoard.getGameBoard().getEnemyBullets().size();i++) {
                	g.drawImage(GameBoard.getGameBoard().getEnemyBullets().get(i).getImage(),
                		GameBoard.getGameBoard().getEnemyBullets().get(i).getX(),GameBoard.getGameBoard().getEnemyBullets().get(i).getY(),
                		GameBoard.getGameBoard().getEnemyBullets().get(i).getWidth(),GameBoard.getGameBoard().getEnemyBullets().get(i).getHeight(),null);
                }
                for(int i = 0; i < GameBoard.getGameBoard().getPlayerBullets().size();i++) {
                	g.drawImage(GameBoard.getGameBoard().getPlayerBullets().get(i).getImage(),
                		GameBoard.getGameBoard().getPlayerBullets().get(i).getX(),GameBoard.getGameBoard().getPlayerBullets().get(i).getY(),
                		GameBoard.getGameBoard().getPlayerBullets().get(i).getWidth(),GameBoard.getGameBoard().getPlayerBullets().get(i).getHeight(),null);
                }
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
                if(e.getKeyCode()==KeyEvent.VK_SPACE) {
                	shooting = true;
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
                if(e.getKeyCode()==KeyEvent.VK_SPACE) {
                	shooting = false;
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
    
    public boolean isShooting() {
    	return shooting;
    }
	
}
