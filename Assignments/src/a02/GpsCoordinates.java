package a02;

/**
 * A class that stores a set of latitude and longitude coordinates
 * 
 * @author andrew
 *
 */
public class GpsCoordinates {
	private double latitude;
	private double longitude;
	
	/**
	 * Initializes new GPS coordinates
	 * 
	 * @param lat Latitude coordinate you'd like to initialize
	 * @param lon Longitude coordinate you'd like to initialize
	 */
	public GpsCoordinates(double lat, double lon) {
		this.latitude = lat;
		this.longitude = lon;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double lat) {
		this.latitude = lat;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double lon) {
		this.longitude = lon;
	}
	
	/**
	 * returns a formatted string of the coordinates to 6 decimal places
	 * 
	 * @return String in the format, "Latitude: __ Longitude __"
	 */
	@Override
	public String toString() {
		return String.format("%.6f, %.6f", latitude, longitude);
	}
	
	
}
