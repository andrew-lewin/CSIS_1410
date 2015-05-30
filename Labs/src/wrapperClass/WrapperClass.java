package wrapperClass;

import java.util.Arrays;
import java.util.List;

public class WrapperClass {
	public static void main(String[] args) {
		byte byteMin = Byte.MIN_VALUE;
		byte byteMax = Byte.MAX_VALUE;
		short shortMin = Short.MIN_VALUE;
		short shortMax = Short.MAX_VALUE;
		int intMin = Integer.MIN_VALUE;
		int intMax = Integer.MAX_VALUE;
		long longMin = Long.MIN_VALUE;
		long longMax = Long.MAX_VALUE;
		
		System.out.printf(
				"   Byte: %-25d%-25d\n" +
				"  Short: %-25d%-25d\n" +
				"Integer: %-25d%-25d\n" +
				"   Long: %-25d%-25d\n", 
				byteMin, byteMax, shortMin, shortMax, intMin, intMax, longMin, longMax);
		System.out.println();
		
		//List<char> myList = new Arrays.asList('a', 'A', '#', '6');
		
		char myList[] = {'a', 'A', '#', '6'};
		
		for (char character : myList){
			System.out.println(evaluation(character));
		}
		
	}
	
	private static String evaluation(char c){
		if (Character.isUpperCase(c)){
			return "letter uppercase";
		} else if (Character.isLetter(c)){
			return "letter";
		} else if (Character.isDigit(c)){
			return "number";
		} else {
			return "";
		}
		
	}

}
