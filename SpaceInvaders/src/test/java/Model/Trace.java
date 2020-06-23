package Model;

public class Trace implements MovePattern{

	public int getXDir(int x, int y, int xp, int yp) {
		return (int)((xp - x)/(Math.sqrt((xp-x)^2+(yp-y)^2)));
	}

	public int getYDir(int x, int y, int xp, int yp) {
		return (int)((yp - y)/(Math.sqrt((xp-x)^2+(yp-y)^2)));
	}

}
