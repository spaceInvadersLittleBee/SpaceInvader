package Model;

import java.awt.Image;
import java.util.List;

public abstract class GameObject {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int speed;
	protected Image image;
	
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
	public Image getImage() {
		return image;
	}
	
	public void moveDir(int xDir, int yDir) {
		x = x+xDir*speed;
		y = y+yDir*speed;
	}
	
	public GameObject detectCollision(List<GameObject> collidables) {
		return null;
	}
	
	public abstract void OnCollision(GameObject collider);

}
