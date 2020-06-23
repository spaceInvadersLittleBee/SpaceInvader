package Model;

import javax.swing.ImageIcon;

import Controller.GameBoard;

public class Enemy extends Character implements Hostile{
	private int value;
	private MovePattern movePattern;
	
	public Enemy(int x, int y, int width, int height, int speed,int HP, int value) {
		super(x, y, width, height, speed,HP);
		this.value = value;
		movePattern = new Wander(x);
		this.image = new ImageIcon("src/test/resources/icecream.PNG").getImage();
	}

	@Override
	public void shoot() {
		// TODO 
		
	}

	public void OnCollision(Friendly collider) {
		collider.hitEnemy(this);
		if(HP<=0)GameBoard.getGameBoard().getEnemies().remove(this);
	}

	

	
	

}
