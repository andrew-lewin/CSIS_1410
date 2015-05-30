package demoBoundedType;

public class DemoBoundedType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = smallest("Cory", "Ben", "Aaron");
		System.out.printf("Smallest (Cory, Ben, Aaron): %s%n", word);
		
		Integer number = smallest(12, 4, 6);
		System.out.printf("Smallest (12, 4, 6): %s%n", number);
		
	}
	
	public static <T extends Comparable<T>> T smallest(T x, T y, T z) {
		T result = x;
		
		if (y.compareTo(result) < 0) {
			result = y;
		}
		if (z.compareTo(result) < 0) {
			result = z;
		}
		
		return result;
	}

}
