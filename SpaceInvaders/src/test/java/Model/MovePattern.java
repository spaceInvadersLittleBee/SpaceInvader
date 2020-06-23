package Model;

public interface MovePattern {
	int getXDir(int x, int y, int xp, int yp);
	int getYDir(int x, int y, int xp, int yp);
}
