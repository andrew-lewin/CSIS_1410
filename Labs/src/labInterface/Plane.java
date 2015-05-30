package labInterface;

public class Plane implements Flyable
{
	private final int numberOfEngines;
	private final String model;

	public Plane(int engines, String m)
	{
		numberOfEngines = engines;
		model = m;
	}

	@Override
	public String toString()
	{
		return String.format("%s with %d engines", model, numberOfEngines);
	}

	public void launch() {
		System.out.println("Rolling until take-off");
	}

	public void land() {
		System.out.println("Rolling to a stop");
	}
}
