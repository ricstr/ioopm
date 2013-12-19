import static org.junit.Assert.*;

import org.junit.Test;


public class LightTest {

	@Test
	public void test() {

		/**
		 * Testing of isGreen, isGreenS and timeStep with Period = 3 (0, 1, 2, 3) and greenPeriod = 1 (0, 1).
		 * isGreen tells us if the light is green or not, true if time <= 1.
		 * isGreenS tells us if the light is green or not in text, true if time <= 1.
		 * timeStep increments the time with 1. Starts at 0. Resets to 0 if time > period.
		 * */

		Light testLight = new Light(3, 1);


		// time = 0 (G)
		assertTrue(testLight.isGreen());
		assertTrue(testLight.color() == "Green");

		// time = 1 (G)
		testLight.step(); // time++
		assertTrue(testLight.isGreen()); 
		assertTrue(testLight.color() == "Green");

		// time = 2 (R)
		testLight.step(); // time++
		assertFalse(testLight.isGreen()); 
		assertTrue(testLight.color() == "Red");

		// time = 3 (R)
		testLight.step(); // time++
		assertFalse(testLight.isGreen()); 
		assertTrue(testLight.color() == "Red");

		// time = 0 (G)
		testLight.step(); // time++
		assertTrue(testLight.isGreen()); 
		assertTrue(testLight.color() == "Green");

	}

}