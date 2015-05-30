package serialization;

import java.io.Serializable;

public class Line implements Serializable {
	private static final long serialVersionUID = 6565309943633169559L;
	Point start;
	Point end;
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public double length() {
		return Math.hypot(start.getX() - end.getX(), start.getY() - end.getY());
	}

	@Override
	public String toString() {
		return start + "->" + end;
	}
}
