package printer;

public class LaserPrinter extends Printer {
	private int remainingToner;
	
	public LaserPrinter(int serialNumber) {
		super(serialNumber);
		this.remainingToner = 100;
	}
	
	int getRemainingToner(){
		return remainingToner;
	}
	
	@Override
	void print() {
		if (remainingToner > 0){
			remainingToner -= 10;
			System.out.println("LaserPrinter is printing. Remaining toner: " + remainingToner + "%");
		} else {
			System.out.println("Yo, ur toners r empty, dawg");
		}
		
	}

}
