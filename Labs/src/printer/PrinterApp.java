package printer;

import java.util.ArrayList;

public class PrinterApp {
	public static void main(String[] args) {
		InkjetPrinter myInkjet = new InkjetPrinter(1234567);
		System.out.println(myInkjet);
		System.out.println(myInkjet.getRemainingCartridge());
		System.out.println();
		
		LaserPrinter myLaser = new LaserPrinter(7654321);
		System.out.println(myLaser);
		System.out.println(myLaser.getRemainingToner());
		System.out.println();
		
		System.out.println("List of Printers:");
		ArrayList<Printer> printers = new ArrayList<>();
		printers.add(myInkjet);
		printers.add(myLaser);
		
		for (Printer printer : printers){
			for (int i = 0; i < 11; i++){
				printer.print();
				
			}
			System.out.println();
		}
		

	}

}
