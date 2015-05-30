package balloon;

public class BalloonApp {

	public static void main(String[] args) {
		Balloon balloonA = new Balloon(Size.XS, true);
		Balloon balloonB = balloonA;
		Balloon balloonC = new Balloon(Size.XS, true);
		Balloon balloonD = new Balloon(Size.XL, false);
		
		System.out.println("balloonA : " + balloonA);
		System.out.println("balloonB : " + balloonB);
		System.out.println("balloonC : " + balloonC);
		System.out.println("balloonD : " + balloonD);
		System.out.println();
		
		System.out.println("Comparing one and the same instance");
		System.out.println("-----------------------------------");
		System.out.println("balloonA == balloonB : " + (balloonA == balloonB));
		System.out.println("balloonA.equals(balloonB) : " + (balloonA.equals(balloonB)));
		System.out.println();
		
		System.out.println("Comparing two different instances with the same content");
		System.out.println("-----------------------------------");
		System.out.println("balloonA == balloonC : " + (balloonA == balloonC));
		System.out.println("balloonA.equals(balloonC) : " + (balloonA.equals(balloonC)));
		System.out.println();
		
		System.out.println("Comparing two completely different instances");
		System.out.println("-----------------------------------");
		System.out.println("balloonA == balloonD : " + (balloonA == balloonD));
		System.out.println("balloonA.equals(balloonD) : " + (balloonA.equals(balloonD)));
		System.out.println();
	}

}
