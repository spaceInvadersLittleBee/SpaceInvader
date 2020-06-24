package Model;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

public abstract class GameObject {
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected double speed;
	protected Image image;
	
	public GameObject(int x, int y, int width, int height, double speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public double getSpeed() {
		return speed;
	}
	public Image getImage() {
		return image;
	}
	
	public void moveDir(double xDir, double yDir) {
		x = x+xDir*speed;
		y = y+yDir*speed;
	}
	
	//TODO
	public GameObject detectCollision(List<GameObject> collidables) {
		for(GameObject obj:collidables) {
			if((x+width>=obj.getX()&&x<=obj.getX()+obj.getWidth())||(y+height>=obj.getY()&&y<=obj.getY()+obj.getHeight())) {
				return obj;
			}
		}
		return null;
	}
	
	

}
