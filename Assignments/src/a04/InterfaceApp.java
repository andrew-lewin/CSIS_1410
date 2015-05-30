package a04;

/*
 * Andrew Lewin
 * CSIS 1410
 * Assignment 4
 */

public class InterfaceApp {
	public static void main(String[] args) {
		Rectangle myRectangle = new Rectangle(6, 3);
		Square mySquare = new Square(5);
		IsoscelesRightTriangle myTriangle = new IsoscelesRightTriangle(6);
		Circle myCircle = new Circle(5);
		
		System.out.println(myRectangle + "\n");
		System.out.println(mySquare + "\n");
		System.out.println(myTriangle + "\n");
		System.out.println(myCircle);
		
		System.out.println("Diamter: " + myCircle.diameter());
		System.out.printf("Circumference: %.1f\n\n", myCircle.circumference());
		
		System.out.println("Shape Array:");
		System.out.println("---------------");
		
		Shape[] myShapes = {mySquare, myRectangle, myTriangle, myCircle};
		
		for (Shape shape : myShapes){
			System.out.println(shape);
			System.out.printf("Perimeter: %.1f\n", shape.perimeter());
			System.out.printf("Area: %.1f\n", shape.area());
			if (shape instanceof Printable){
				((Printable) shape).print();
			}
			System.out.println();
		}

	}

}
