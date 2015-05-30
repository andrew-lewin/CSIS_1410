package demoInterfaces;

public class FlammableApp {
	public static void main(String[] args) {
		Gas gas = new Gas("pungent");
		System.out.println(gas);
		gas.enflame();
		
		Marshmellow marshmellow = new Marshmellow();
		System.out.println(marshmellow);
		marshmellow.enflame();

	}

}
