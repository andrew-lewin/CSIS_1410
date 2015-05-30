package labCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LabCollections {

	public static void main(String[] args) {
		List<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));
		List<Character> vowels = new ArrayList<>();
		
		Collections.rotate(letters, 1);
		Collections.addAll(vowels, 'o', 'i', 'o', 'u', 'o');
		
		System.out.println(letters);
		System.out.println(vowels);
		System.out.println();
		
		if (Collections.disjoint(letters, vowels)){
			System.out.println("letters and vowels don't have anything in common");
		} else {
			System.out.println("Dey has tings in commonz");
		}
		Collections.replaceAll(vowels, 'o', 'a');
		Collections.swap(letters, 1, letters.size() - 2);
		
		System.out.println(letters);
		System.out.println(vowels);
		System.out.println();
		
		Collections.sort(letters);
		System.out.printf("Index of letter e: %d\n", Collections.binarySearch(letters, 'e'));
		Collections.shuffle(letters);
		Collections.rotate(vowels, -3);
		
		System.out.println(letters);
		System.out.println(vowels);

	}

}
