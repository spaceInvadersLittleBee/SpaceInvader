package Model;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Controller.GameBoard;

public class Enemy extends Character implements Hostile{
	private int value;
	private MovePattern movePattern;
	
	public Enemy(int x, int y, int width, int height, double speed,int HP, int value) {
		super(x, y, width, height, speed,HP);
		this.value = value;
		movePattern = new Wander(x);
		this.image = new ImageIcon("src/main/resources/alien1Skin.gif").getImage();
	}

	@Override
	public void shoot() {
		Bullet bullet=new EnemyBullet((int)this.x+30,(int)this.y+100,10, 10,this.speed*4,100);
		GameBoard.getGameBoard().getEnemyBullets().add((EnemyBullet) bullet);
		
	}

	public void OnCollision(Friendly collider) {
		collider.hitEnemy(this);
		if(movePattern instanceof Trace)GameBoard.getGameBoard().traceMinus();
		if(HP<=0)GameBoard.getGameBoard().getEnemies().remove(this);
	}
	
	public void move() {
		moveDir(movePattern.getXDir(x, y),movePattern.getYDir(x, y));
	}
	
	public void setMovePattern(MovePattern movePattern) {
		this.movePattern = movePattern;
	}

	

	
	

}
