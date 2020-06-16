package Model;

public abstract class Character extends GameObject{
	
	private int HP;

	public Character(int x, int y, int width, int height, int speed,int HP) {
		super(x, y, width, height, speed);
		this.setHP(HP);
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}
	
	public abstract void shoot();

}
