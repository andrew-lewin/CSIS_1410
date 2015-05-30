package genericBoundedType;

public class Animal {
	private static int count;
	private int id;

	public Animal() {
		id = ++count;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + id;
	}
	
}
