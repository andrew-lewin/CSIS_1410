package labCoin;

public enum Coin {
	CENT(2.5, 19.05), NICKEL(5.0, 21.21), DIME(2.268, 17.91), QUARTER(5.670, 24.26);
	
	private final double weight;
	private final double diameter;
	
	private Coin(double weight, double diameter) {
		this.weight = weight;
		this.diameter = diameter;
	}
	
	@Override
	public String toString() {
		return this.name() + " w:" + weight + " d:" + diameter;
	}
}
