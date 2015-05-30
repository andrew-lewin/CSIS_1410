package labQuadrotors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuadrotorApp {
	public static void main(String[] args) {
		//List<String> words = Arrays.asList("dog", "cat", "sit", "hat");
		//System.out.println(words);
		
		List<Quadrotor> rotors = new ArrayList<>(Arrays.asList(
				new Quadrotor(2, 4, 1), new Quadrotor(3, 4, 2), 
				new Quadrotor(4, 4, 3), new Quadrotor(5, 4, 1), 
				new Quadrotor(6, 4, 2), new Quadrotor(7, 4, 3)));
		
		System.out.println(rotors);
		changeOrientation(rotors);
		System.out.println(rotors);
		
		Quadrotor searchItem = new Quadrotor(4, 6, 2);
		
		System.out.println("Rotors " + (rotors.contains(searchItem) ? "does " : "doesn't " ) + "contain " + searchItem);
		System.out.println();
		
		System.out.println("There are " + rotors.size() + " rotors");
		
		
		rotors.remove(searchItem);
		
		System.out.println(rotors.size());
		
	}
	
	private static void changeOrientation(List<Quadrotor> list) {
		for (Quadrotor rotor : list){
			int temp = rotor.getX();
			rotor.setX(rotor.getY());
			rotor.setY(temp);
		}
	} 
}
