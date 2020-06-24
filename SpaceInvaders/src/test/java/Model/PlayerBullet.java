package Model;

import Controller.GameBoard;

public class PlayerBullet extends Bullet implements Friendly{
	
	public PlayerBullet(int x, int y, int width, int height,double speed, int damage) {
		super(x, y, width, height,speed, damage);
		// TODO Auto-generated constructor stub
	}


	public void hitEnemy(Enemy enemy) {
		enemy.loseHP(damage);
		GameBoard.getGameBoard().getPlayerBullets().remove(this);
	}


	public void hitEnemyBullet(EnemyBullet enemyBullet) {
		GameBoard.getGameBoard().getPlayerBullets().remove(this);
	}

}
