package Model;

public class Wander implements MovePattern{

	private int left;
	private int right;
	private int dir;
	private int radius = 20;
	
	public Wander(int x) {
		this.left = x-radius;
		this.right = x+radius;
		this.dir = 1;
	}
	

	public int getXDir(int x, int y, int xp, int yp) {
		if(x>=right) {
			dir = -1;
		}
		else if (x<=left) {
			dir = 1;
		}
		return dir;
	}

	public int getYDir(int x, int y, int xp, int yp) {
		return 0;
	}

}
