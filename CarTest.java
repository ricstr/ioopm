import static org.junit.Assert.*;

import org.junit.Test;


public class CarTest {

	@Test
	public void test() {

		/**
		 * Testing of Car.
		 * */

		Car testCar = new Car(42, 100);
		
	
		// get_bornTime
		assertTrue(testCar.getborntime() == 42);
		assertFalse(testCar.getborntime() == 1337);

		// get_dest
		assertTrue(testCar.getdest() == 2);
		assertFalse(testCar.getdest() == 1);
		assertFalse(testCar.getdest() == 0);


		//---//


		Car testCar2 = new Car(47, 0);


		// get_bornTime
		assertTrue(testCar2.getborntime() == 47);
		assertFalse(testCar2.getborntime() == 1337);

		// get_dest
		assertTrue(testCar2.getdest() == 1);
		assertFalse(testCar2.getdest() == 2);
		assertFalse(testCar2.getdest() == 1337);

	}

}
