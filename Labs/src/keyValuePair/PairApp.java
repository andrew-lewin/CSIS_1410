package keyValuePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairApp {
	public static void main(String[] args) {
		KeyValuePair<String, Integer> p1 = new KeyValuePair<>("SLC", 189899);
		KeyValuePair<String, Integer> p2 = new KeyValuePair<>("NY", 8244910);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		
		p1 = p2;
		System.out.println();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		
		List<KeyValuePair<String, Integer>> cities = new ArrayList<>(Arrays.asList(
				new KeyValuePair<>("SLC", 189899),
				new KeyValuePair<>("NY", 8244910),
				new KeyValuePair<>("LA", 3819702),
				new KeyValuePair<>("SF", 812826)));
		System.out.println();
		
		System.out.println("Original list");
		for (KeyValuePair<String, Integer> city : cities) {
			System.out.println(city);
		}
		
		System.out.println("\nSorted list");
		Collections.sort(cities);
		for (KeyValuePair<String, Integer> city : cities) {
			System.out.println(city);
		}
	}

}
