package labJUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMultiply() {
		MyClass tester = new MyClass();
		
		assertEquals("Result", 50, tester.multiply(10, 5));
	}

}
