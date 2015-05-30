package a05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VectorTest {
	double[] data1 = { -1.0, 2.0, 3.12345, 4.0 };
    double[] data2 = { 5.0, -2.0, 4.0, 1.0 };
    double[] data3 = { 1.0, 2.0 };

    final Vector vectorOne = new Vector(data1);
    final Vector vectorTwo = new Vector(data2);
    final Vector vectorShort = new Vector(data3);
    
    final double delta = 0.00001;
    
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testComponentAt() {
		assertEquals(-1.0, vectorOne.componentAt(0), delta);
		assertEquals(3.12345, vectorOne.componentAt(2), delta);
		assertEquals(2.0, vectorOne.componentAt(1), delta);
	}

	@Test
	public void testPlus() {
		final double[] plusData = { 4.0, 0.0, 7.12345, 5.0 };
		final Vector plusVectorExpected = new Vector(plusData);
		
		for (int i = 0; i < 4; i++){
			// Since we know componentAt() is working from the previous test, I feel safe doing this
			assertEquals(plusVectorExpected.componentAt(i), vectorOne.plus(vectorTwo).componentAt(i), delta);
		}

	}
	
	@Test(expected = RuntimeException.class)
	public void testPlusException() {
		vectorOne.plus(vectorShort);
	}

	@Test
	public void testMinus() {
		final double[] minusData = { -6.0, 4.0, -0.87655, 3.0 };
		final Vector minusVectorExpected = new Vector(minusData);
		
		for (int i = 0; i < 4; i++){
			assertEquals(minusVectorExpected.componentAt(i), vectorOne.minus(vectorTwo).componentAt(i), delta);
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testMinusException() {
		vectorOne.minus(vectorShort);
	}

	@Test
	public void testTimes() {
		final double[] timesData = { -10.0, 20.0, 31.2345, 40.0 };
		final Vector timesVectorExpected = new Vector(timesData);
		
		for (int i = 0; i < 4; i++){
			assertEquals(timesVectorExpected.componentAt(i), vectorOne.times(10).componentAt(i), delta);
		}
	}

	@Test
	public void testDistanceTo() {
		assertEquals(7.85928, vectorOne.distanceTo(vectorTwo), delta);
		
	}
	
	@Test(expected = RuntimeException.class)
	public void testDistanceToException() {
		vectorOne.distanceTo(vectorShort);
	}

}
