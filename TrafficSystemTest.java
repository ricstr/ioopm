import static org.junit.Assert.*;

import org.junit.Test;


public class TrafficSystemTest {

	@Test
	public void test() {
		/**
		 * All created Cars have destination 1.
		 */

		TrafficSystem testTS = new TrafficSystem();
		// r0: [null, null]
		// r1: [null]
		// r2: [null]
		// time: 0
		// s1 & s2: G

		testTS.step();
		assertTrue(testTS.overflow == 0);
		assertTrue(testTS.cars == 0);
		// r0: [null, newCar]
		// r1: [null] - Exited cars: 0
		// r2: [null]
		// time: 1
		// s1 & s2: G

		testTS.step();
		assertTrue(testTS.overflow == 0);
		assertTrue(testTS.cars == 0);
		// r0: [Car, newCar]
		// r1: [null] - Exited cars: 0
		// r2: [null]
		// time: 2
		// s1 & s2: R

		testTS.step();
		assertTrue(testTS.overflow == 0);
		assertTrue(testTS.cars == 0);
		// r0: [Car, newCar]
		// r1: [Car] - Exited cars: 0
		// r2: [null]
		// time: 3
		// s1 & s2: R

		testTS.step();
		assertTrue(testTS.overflow == 0);
		assertFalse(testTS.cars == 1);
		// r0: [Car, newCar]
		// r1: [Car] - Exited cars: 1
		// r2: [null]
		// time: 0
		// s1 & s2: G

		testTS.step();
		assertTrue(testTS.overflow == 0);
		assertFalse(testTS.cars == 2);
		// r0: [Car, newCar]
		// r1: [Car] - Exited cars: 2
		// r2: [null]
		// time: 1
		// s1 & s2: G

		testTS.step();
		assertTrue(testTS.overflow == 0);
		assertFalse(testTS.cars == 2);
		// r0: [Car, newCar]
		// r1: [Car] - Exited cars: 2
		// r2: [null]
		// time: 2
		// s1 & s2: R



	}

}