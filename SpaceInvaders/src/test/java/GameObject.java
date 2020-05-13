
public abstract class GameObject {
	private int x;
	private int y;
	private int width;
	private int height;
	private int speed;
	
	public GameObject(int x, int y, int width, int height, int speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public int getSpeed() {
		return speed;
	}
	
	public void moveDir(int xDir, int yDir) {
		x = x+xDir*speed;
		y = y+yDir*speed;
	}
	
}
