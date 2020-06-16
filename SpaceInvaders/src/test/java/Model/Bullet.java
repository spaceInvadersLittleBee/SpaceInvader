package Model;

public abstract class Bullet extends GameObject{
	private int damage;
	public Bullet(int x, int y, int width, int height,int speed, int damage) {
		super(x, y, width,height, speed);
		this.damage = damage;
	}


}
