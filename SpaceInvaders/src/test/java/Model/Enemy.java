package Model;

public class Enemy extends Character{
	private int value;
	
	public Enemy(int x, int y, int width, int height, int speed,int HP, int value) {
		super(x, y, width, height, speed,HP);
		this.value = value;
	}

	@Override
	public void shoot() {
		// TODO 
		
	}

	@Override
	public void OnCollision(GameObject collider) {
	
		
	}

}
