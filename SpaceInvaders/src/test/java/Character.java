
public abstract class Character extends GameObject{
	
	private int HP;

	public Character(int x, int y, int width, int height, int speed,int HP) {
		super(x, y, width, height, speed);
		this.HP = HP;
	}

}
