package trafficLight;

public enum TrafficLight {
	RED(50), YELLOW(5), GREEN(45);
	
	private int duration;

	private TrafficLight(int duration) {
		this.duration = duration;
	}
	
	public static void increaseDuration() {
		for (TrafficLight light : values()) {
			light.duration *= 2;
		}
	}
	
	public static void decreaseDuration() {
		for (TrafficLight light : values()) {
			light.duration *= 0.5;
		}
	}
	
	@Override
	public String toString() {
		return this.name() + ":" + duration;
	}
	
}
