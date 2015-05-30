package a03;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 3
 */

public class IsoscelesRightTriangle {
	private int leg;

	public IsoscelesRightTriangle(int leg) {
		this.leg = leg;
	}
	
	public double hypotenuse(){
		return Math.hypot(leg, leg);
	}
	
	public int getLeg() {
		return leg;
	}
	
	@Override
	public String toString() {
		return "IsoscelesRightTriangle(" + leg + ")";
	}
}
