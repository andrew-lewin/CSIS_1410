package a03;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 3
 */

public class Square extends Rectangle {

	public Square(int length) {
		super(length, length);
	}
	
	public int getSide() {
		return super.getLength();
	}
	
	@Override
	public String toString() {
		return "Square(" + super.getLength() + ")";
	}
}
