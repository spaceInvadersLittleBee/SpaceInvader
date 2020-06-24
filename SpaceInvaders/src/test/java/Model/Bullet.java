package Model;

public abstract class Bullet extends GameObject{
	protected int damage;
	public Bullet(int x, int y, int width, int height,double speed, int damage) {
		super(x, y, width,height, speed);
		this.damage = damage;
	}


}
