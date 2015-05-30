package a04;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 4
 */

public class Rectangle implements Shape, Printable{
	private int length;
	private int width;
	private StringBuilder shape = new StringBuilder();
	
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

	@Override
	public void print() {
		shape.setLength(0);
		for (int i = 0; i < width; i++){
			if ((i == 0) || ((i + 1) == width)){
				for (int j = 0; j < length; j++){
					shape.append("* ");
				}
			} else{
				for (int j = 0; j < length; j++){
					if ((j == 0) || ((j + 1) == length)){
						shape.append("* ");
					} else {
						shape.append("  ");
					}
				}
			}
			shape.append("\n");
		}
		shape.delete(shape.length() - 2, shape.length());
		System.out.println(shape.toString());
		
	}

	@Override
	public double perimeter() {
		return (2 * length) + (2 * width);
	}

	@Override
	public double area() {
		return length * width;
	}
}
