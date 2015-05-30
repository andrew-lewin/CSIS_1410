package a02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GpsTest {
	private GpsCoordinates testCoordinates = new GpsCoordinates(20.023452345, -643.613);
	private Gps myGPS = new Gps("Bob", testCoordinates);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGps() {
		GpsCoordinates testCoordinates2 = new GpsCoordinates(-123.932453, 0.0000011);
		Gps testGPS = new Gps("'!@#$%^&*()_+asd1234567890", testCoordinates2);
		assertEquals("myGPS: '!@#$%^&*()_+asd1234567890: -123.932453, 0.000001", testGPS.toString());
	}

	@Test
	public void testUpdatePosition() {
		double latitude = testCoordinates.getLatitude();
		double longitude = testCoordinates.getLongitude();
		double newLatitude;
		double newLongitude;
		
		for (int i = 0; i < 100000; i++){
			myGPS.updatePosition();
			newLatitude = testCoordinates.getLatitude();
			newLongitude = testCoordinates.getLongitude();
			
			if (-2.5 > (latitude - newLatitude) || (latitude - newLatitude) > 2.5){
				fail("Latitude was wrong");
			}
			
			if (-2.5 > (longitude - newLongitude) || (longitude - newLongitude) > 2.5){
				fail("Longitude was wrong");
			}
			
			latitude = newLatitude;
			longitude = newLongitude;
		}
	}

	@Test
	public void testGetPosition() {
		assertEquals(testCoordinates, myGPS.getPosition());
	}

	@Test
	public void testToString() {
		assertEquals("myGPS: Bob: 20.023452, -643.613000", myGPS.toString());
	}

}
