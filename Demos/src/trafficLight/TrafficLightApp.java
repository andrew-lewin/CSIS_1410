package trafficLight;

public class TrafficLightApp {
	public static void main(String[] args) {
		TrafficLight redLight = TrafficLight.RED;
		System.out.println(redLight);
		System.out.println();
		
		for (TrafficLight light : TrafficLight.values()) {
			System.out.println(light);
		}
		System.out.println();
		
		TrafficLight.increaseDuration();
		
		for (TrafficLight light : TrafficLight.values()) {
			System.out.println(light);
		}
		
		
	}

}
