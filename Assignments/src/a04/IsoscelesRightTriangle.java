package a04;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 4
 */

public class IsoscelesRightTriangle implements Shape, Printable{
	private int leg;
	private StringBuilder shape = new StringBuilder();

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

	@Override
	public void print() {
		shape.setLength(0);
		for (int i = 0; i < leg; i++){
			int j = 0;
			if ((i + 1) == leg){
				for (j = 0; j < leg; j++){
					shape.append("* ");
				}
			} else {
				while (j <= i){
					if ((j == 0) || (j == i)){
						shape.append("* ");
					} else {
						shape.append("  ");
					}
					j++;
				}
			}
			shape.append("\n");
		}
		shape.delete(shape.length() - 2, shape.length());
		System.out.println(shape.toString());
	}

	@Override
	public double perimeter() {
		return (Math.hypot(leg, leg) + (2 * leg));
	}

	@Override
	public double area() {
		return ((leg * leg) / 2);
	}
}
