package a04;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 4
 */

public class Circle implements Shape{
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

	@Override
	public double perimeter() {
		return this.circumference();
	}

	@Override
	public double area() {
		return radius * radius * Math.PI;
	}
}
