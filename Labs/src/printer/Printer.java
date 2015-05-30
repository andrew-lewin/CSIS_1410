package printer;

public abstract class Printer {
	int serialNumber;

	public Printer(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	abstract void print();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " #" + serialNumber;
	}
	
}
