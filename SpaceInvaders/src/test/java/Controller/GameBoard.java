package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import View.View;
import Model.Enemy;
import Model.EnemyBullet;
import Model.Player;
import Model.PlayerBullet;

public class GameBoard {
	
	//singleton
		private static GameBoard gameBoard;
		private Player player;
		private View view;
		private AudioPlayer audioplayer;
		private List<Enemy> enemies;
		private List<PlayerBullet> playerBullets;
		private List<EnemyBullet> enemyBullets;
		private int score;
		private int level;
		private boolean isGameOver;
		private boolean isLevelClean;
		
		//getters
		public static GameBoard getGameBoard() {
			return gameBoard;
		}
		public Player getPlayer() {
			return player;
		}
		public List<Enemy> getEnemies() {
			return enemies;
		}
		public List<PlayerBullet> getPlayerBullets(){
			return playerBullets;
		}
		public List<EnemyBullet> getEnemyBullets(){
			return enemyBullets;
		}
		
		
		//called once when starting the game
		public static void initializeGame() {
			gameBoard = new GameBoard();
			gameBoard.view = new View();
			gameBoard.player = new Player(450,400,150,150,5,100);
			gameBoard.audioplayer = new AudioPlayer();
			gameBoard.enemies = new LinkedList<Enemy>();
			gameBoard.enemyBullets = new LinkedList<EnemyBullet>();
			gameBoard.playerBullets = new LinkedList<PlayerBullet>();
			
			gameBoard.view.windowSetup();
			Timer timer = new Timer(17,(ActionListener) new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gameBoard.update();
				}
			});
	        timer.start();
		}
		//end of initializeGame()
		
		
		
		//update is called once per frame
	    private void update(){
	        player.moveDir(view.getXAxis(), 0);
	        
	        view.repaint();
	    }//end of update
	    
	    //TODO
	    private void moveEnemies() {
	    	
	    }
	    //TODO
	    private void moveBullets() {
	    	
	    }
	    
	    private void loadNewLevel() {
	    	
	    }
	    
	    public void endGame() {
	    	
	    }
	    
	    
	    //TODO
	    private void enemiesShoot() {
	    	
	    }


}
