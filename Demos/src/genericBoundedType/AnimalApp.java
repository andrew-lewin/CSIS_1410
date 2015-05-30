package genericBoundedType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AnimalApp {
	private static final Random random = new Random();
	
	public static void main(String[] args) {
		// Use the wrapper because Arrays.asList is immutable, but ArrayList<>(Arrays.asList()) is mutable
		List<Animal> animals = new ArrayList<>(Arrays.asList(new Animal(), new Animal(), new Animal()));
		List<Mammal> mammals = new ArrayList<>(Arrays.asList(new Mammal(), new Mammal()));
		List<Cat> cats = new ArrayList<>(Arrays.asList(new Cat(), new Cat()));
		
		System.out.println("Animals: " + animals);
		System.out.println("Mammals: " + mammals);
		System.out.println("Cats: " + cats);
		
		System.out.println(getRandomElement(animals));
		System.out.println(getRandomElementWithMethodNotFromObject(mammals));
	}
	
	private static <E> E getRandomElement(List<E> list){
		return list.get(random.nextInt(list.size()));
	}
	
	private static Animal getRandomElementWithMethodNotFromObject(List<? extends Animal> list){
		Animal returnThis = list.get(random.nextInt(list.size()));
		System.out.println("Index from animal with id: " + returnThis.getId());
		return returnThis;
	}
}
