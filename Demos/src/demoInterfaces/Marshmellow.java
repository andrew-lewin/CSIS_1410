package demoInterfaces;

public class Marshmellow implements Flammable{
	private double size;

	public Marshmellow(double size) {
		this.size = size;
	}
	
	public Marshmellow() {
		this.size = 5;
	}


	@Override
	public String toString() {
		return "Your mashmellow has size " + size;
	}

	@Override
	public void enflame() {
		System.out.println(":(");
		
	}
	
}
