package a02;

import java.util.Random;

/**
 * A class that allows you to update your GPS coordinates
 * @author andrew
 *
 */
public class Gps {
	private String name;
	private GpsCoordinates position;
	private Random update = new Random();
	
	/**
	 * Initializes your GPS device with its name and position
	 * @param name This is your GPS device's name
	 * @param position Your GPS position from the GpsCoordinates class
	 */
	public Gps(String name, GpsCoordinates position) {
		this.name = name;
		//this.position = position;
		// Data security below
		this.position = new GpsCoordinates(position.getLatitude(), position.getLongitude());
	}
	
	/**
	 * Calling this method will update your GPS position
	 */
	public void updatePosition(){
		position.setLatitude(((5 * update.nextDouble()) - 2.5) + position.getLatitude());
		position.setLongitude(((5 * update.nextDouble()) - 2.5) + position.getLongitude());
	}
	
	public GpsCoordinates getPosition(){
		//return position;
		// Data security below
		return new GpsCoordinates(position.getLatitude(), position.getLongitude());
	}
	
	/**
	 * Makes a string that includes the name followed by the current position
	 */
	@Override
	public String toString(){
		return "myGPS: " + name + ": " + position;
	}
}
