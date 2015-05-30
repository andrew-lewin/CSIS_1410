package a03;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 3
 */

public class Circle {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	
	public int diameter() {
		return 2 * radius;
	}
	
	public double circumference() {
		return 2 * radius * Math.PI;
	}
	
	public int getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		return "Circle(" + radius + ")";
	}
}
