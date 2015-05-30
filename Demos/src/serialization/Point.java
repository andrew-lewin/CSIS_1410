package serialization;

import java.io.Serializable;

public class Point implements Serializable {
	private static final long serialVersionUID = -8342945289199668523L;
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
}
