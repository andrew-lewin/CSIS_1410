package generics;

import java.util.Arrays;

public class Generics {
	public static void main(String[] args) {
		Character[] myArray = {'A', 'E', 'I', 'O', 'U'};
		
		System.out.println("Swapping el 0 and 1");
		System.out.println(Arrays.toString(myArray));
		swap(myArray, 0, 1);
		System.out.println(Arrays.toString(myArray));
		System.out.println();
		
		System.out.println("Resetting original array");
		swap(myArray, 0, 1);
		System.out.println(Arrays.toString(myArray));
		System.out.println(Arrays.toString(reverse(myArray)));
	}
	
	public static <T> void swap(T[] myArray, int index1, int index2) {
		T temp = myArray[index1];
		myArray[index1] = myArray[index2];
		myArray[index2] = temp;
	}
	
	public static <T> T[] reverse(T[] myArray) {
		T[] reverseArray = Arrays.copyOf(myArray, myArray.length);
		for (int i = 0, j = reverseArray.length - 1; i < myArray.length; i++, j--) {
			reverseArray[j] = myArray[i];
		}
		return reverseArray;
		
	}

}
