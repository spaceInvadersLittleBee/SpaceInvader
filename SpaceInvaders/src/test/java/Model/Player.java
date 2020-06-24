package Model;

import javax.swing.ImageIcon;

import Controller.GameBoard;

public class Player extends Character implements Friendly{
	
	public Player(int x, int y, int width, int height,double speed, int HP) {
		super(x, y, width, height, speed, HP);
		this.image = new ImageIcon("src/test/resources/icecream.PNG").getImage();
	}

	@Override
	public void shoot() {
		// TODO
		Bullet bullet=new PlayerBullet((int)this.x+30,(int)this.y+100,10, 10,this.speed*4,100);//≤Œ ˝¥Ê“…
		GameBoard.getGameBoard().getPlayerBullets().add((PlayerBullet) bullet);
	}


	
	public void hitEnemy(Enemy enemy) {
		GameBoard.getGameBoard().endGame();
	}

	
	public void hitEnemyBullet(EnemyBullet enemyBullet) {
		loseHP(enemyBullet.damage);
		if(HP<=0)GameBoard.getGameBoard().endGame();
	}

	


}
