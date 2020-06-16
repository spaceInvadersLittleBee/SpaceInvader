package Model;

import javax.swing.ImageIcon;

public class Player extends Character{
	
	public Player(int x, int y, int width, int height,int speed, int HP) {
		super(x, y, width, height, speed, HP);
		this.image = new ImageIcon("src/resources/icecream.PNG").getImage();
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnCollision(GameObject collider) {
		// TODO Auto-generated method stub
		
	}


}
