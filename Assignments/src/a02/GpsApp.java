package a02;

public class GpsApp {
	public static void main(String[] args){
		GpsCoordinates slc = new GpsCoordinates(40.760671, -111.891122);
		
		//Don't need to call toString
		System.out.println("GPS Coordinates of SLC: " + slc.toString());
		System.out.println();
		
		Gps myGPS = new Gps("Garmin", slc);
		
		//Don't need to call toString because it's already going to be a string from the concatenation
		System.out.println(myGPS.toString());
		System.out.println();
		
		for (int i = 0; i < 3; i++){
			myGPS.updatePosition();
			System.out.println("position update" + (i+1) + ": " + myGPS.getPosition());
		}
		
	}
}
