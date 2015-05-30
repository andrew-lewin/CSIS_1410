package printer;

public class InkjetPrinter extends Printer {
	private int remainingCartridge;
	public InkjetPrinter(int serialNumber) {
		super(serialNumber);
		this.remainingCartridge = 100;
	}
	
	int getRemainingCartridge(){
		return remainingCartridge;
	}
	
	@Override
	void print() {
		if (remainingCartridge > 0){
			remainingCartridge -= 10;
			System.out.println("InkjetPrinter is printing. Remaining cartridge: " + remainingCartridge + "%");
		} else {
			System.out.println("You have no cartridge left, fool.");
		}
	}

}
