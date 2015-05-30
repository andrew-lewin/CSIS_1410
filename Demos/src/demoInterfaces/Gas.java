package demoInterfaces;

public class Gas implements Flammable{
	private String odor;

	public Gas(String odor) {
		this.odor = odor;
	}

	@Override
	public String toString() {
		return "Smells like " + odor;
	}

	@Override
	public void enflame() {
		System.out.println("KABOOM!");
		
	}
	
	
}
