package a04;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 4
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
