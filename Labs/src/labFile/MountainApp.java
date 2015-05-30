package labFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MountainApp {
	public static void main(String[] args) {
		List<Mountain> mountainList = new LinkedList<>();
		
		
		try(Scanner myScanner = new Scanner(MountainApp.class.getResourceAsStream("Mountains.csv"))) {
			while (myScanner.hasNextLine()) {
				Mountain newMountain = getMountain(myScanner.nextLine());
				if (newMountain != null){
					mountainList.add(newMountain);
				}
			}
		} 
		for (Mountain mountain : mountainList) {
			System.out.println(mountain);
		}
		
	}

	private static Mountain getMountain(String nextLine) {
		try {
			String[] el = nextLine.split(",");
			String name = el[0];
			int number = Integer.parseInt(el[1]);
			boolean bool = Boolean.parseBoolean(el[2]);
			return new Mountain(name, number, bool);
			
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.err.printf("%s could not be read in as a mountain.%n", nextLine);
		}
		
		return null;
		
	}
}
