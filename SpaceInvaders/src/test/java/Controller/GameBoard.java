package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

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
		private int coolingTime;
		private int cd;
		private int score=0;
		private int level=1;
		private boolean isGameOver;
		private boolean isLevelClean = true;
		private int numberOfTrace = 0;
		private MovementPolicy movementPolicy;
		private int frameTime;
		
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
		public int getNumberOfTrace() {
			return numberOfTrace;
		}
		public void tracePlus() {
			numberOfTrace++;
		}
		public void traceMinus() {
			numberOfTrace--;
		}
		
		
		//called once when starting the game
		public static void initializeGame() {
			gameBoard = new GameBoard();
			gameBoard.view = new View();
			gameBoard.player = new Player(450,500,50,50,5,100);
			gameBoard.audioplayer = new AudioPlayer();
			gameBoard.enemies = new LinkedList<Enemy>();
			gameBoard.enemyBullets = new LinkedList<EnemyBullet>();
			gameBoard.playerBullets = new LinkedList<PlayerBullet>();
			gameBoard.movementPolicy = new MovementPolicy();
			gameBoard.coolingTime = 300;
			gameBoard.frameTime = 17;
			
			gameBoard.view.windowSetup();
			Timer timer = new Timer(gameBoard.frameTime,(ActionListener) new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					gameBoard.update();
				}
			});
	        timer.start();
		}
		//end of initializeGame()
		
		
		
		//update is called once per frame
	    private void update(){
	    	if(isLevelClean) {
	    		loadNewLevel();
	    		isLevelClean = false;
	    	}
	        player.moveDir(view.getXAxis(), 0);
	        cd = cd - frameTime;
	        if(cd<0)cd=0;
	        
	        if(view.isShooting()&&cd==0) {
	        	player.shoot();
	        	cd = cd+coolingTime;
	        }
	        moveEnemies();
	        if (enemyBullets.isEmpty()) {
	        	newEnemyBulletCanFire = true;
	        }
	        enemiesShoot();

            moveBullets();
	        
            for(Enemy e: enemies) {
            	player.detectCollision(e);
            	for(PlayerBullet b: playerBullets) {
            		b.detectCollision(e);
            	}
            }
            
            for(EnemyBullet e: enemyBullets) {
            	player.detectCollision(e);
            	for(PlayerBullet b: playerBullets) {
            		b.detectCollision(e);
            	}
            }
            enemies.removeIf(new Predicate<Enemy>() {
				public boolean test(Enemy e) {
					return (!e.isEnabled());
				}
			});
            enemyBullets.removeIf(new Predicate<EnemyBullet>() {
				public boolean test(EnemyBullet e) {
					return (!e.isEnabled());
				}
			});
            playerBullets.removeIf(new Predicate<PlayerBullet>() {
				public boolean test(PlayerBullet e) {
					return (!e.isEnabled());
				}
			});
	        if(enemies.isEmpty())isLevelClean=true;
	        view.repaint();
	    }//end of update
	    
	    //TODO
	    private void moveEnemies() {
	    	movementPolicy.configure(this);
	    	for(Enemy e: enemies) {
	    		e.move();
	    		if(e.getY()>700) {
	    			e.disable();
	    		}
	    	}
	    }
	    //TODO
	    private void moveBullets() {
	    	for(EnemyBullet b:enemyBullets) {
	    		b.moveDir(0, 1);
	    		if(b.getY()>700) {
	    			b.disable();
	    		}
	    	}
	    	for(PlayerBullet b:playerBullets) {
	    		b.moveDir(0, -1);
	    		if(b.getY()<0) {
	    			b.disable();
	    		}
	    	}
	    }
	    
	    private void loadNewLevel() {
	    	enemies.clear();
            for (int column = 0; column < 10; column++) {
                for (int row = 0; row < 5; row++) {
                    enemies.add(new Enemy(65+column*100, 50*row, 50,50,1.5, 100,100));
                }
            } 

	    	/*for(int i = 0; i<5; i++) {
	    		enemies.add(new Enemy(100+i*200, 50, 100,100,1.5, 100,100));
	    	}*/
	    }
	    
	    public void endGame() {
	    	
	    }
	    
	    private boolean newEnemyBulletCanFire=true;
	    Random r = new Random();
	    //TODO
	    private void enemiesShoot() {
	    	if (newEnemyBulletCanFire) {
	    		for (int index = 0; index < enemies.size(); index++) {
	    			if (r.nextInt(50) ==index) {
	    				enemies.get(index).shoot();
	                    //AudioPlayer
	    			}
	                newEnemyBulletCanFire= false;
	            }
	        }
	   }


}
