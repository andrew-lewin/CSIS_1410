package a03;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 3
 */

public class Rectangle {
	private int length;
	private int width;
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
	@Override
	public String toString() {
		return "Rectangle(" + length + "x" + width + ")";
	}
}
