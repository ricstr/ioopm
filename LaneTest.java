import static org.junit.Assert.*;

import org.junit.Test;


public class LaneTest {

	@Test
	public void test() {

		/**
		 * Testing of Lane.
		 */

		Lane testLane = new Lane(3); // [null, null, null] ==> [0, 1, 2]
		Car testCar = new Car(1, 0); // testCar (bornTime = 1, dest = 1)
		Car testCar2 = new Car(2, 100); // testCar (bornTime = 2, dest = 2)
		//Car testCar3 = new Car(3, 1); // testCar (bornTime = 3, dest = 1)

		// (1) lastFree, [null, null, ->null<-]
		assertTrue(testLane.lastFree() == true);  
		assertNull(testLane.getFirst());


		//--PUTLAST--//
		// (2) 3putLast, [null, null, ->testCar<-]
		testLane.putLast(testCar);
		assertFalse(testLane.lastFree());

		// lastFree, [null, null, ->testCar<-]
		assertTrue(testLane.lastFree() == false);

		//--STEP--//
		// (3) laneStep
		testLane.step();

		// lastFree, [null, testCar, ->null<-]
		assertTrue(testLane.lastFree() == true);
		assertNull(testLane.getFirst());


		//--PUTLAST--//
		// putLast [null, testCar, ->testCar<-]
		testLane.putLast(testCar2);
		assertFalse(testLane.lastFree());
		assertNotNull(testLane.theLane[1]);

		// lastFree, [null, testCar, ->testCar2<-]
		assertTrue(testLane.lastFree() == false);
		assertNull(testLane.theLane[0]);

		//--STEP--// [->testCar<-, ->testCar2<-, null]
		testLane.step();

		// lastFree, [testCar, testCar2, ->null<-]
		assertTrue(testLane.lastFree() == true);
		assertNotNull(testLane.theLane[0]);

		// (5) firstCar, [->testCar<-, testCar2, null]
		Car firstTestCar = testLane.firstCar();
		assertTrue(firstTestCar == testCar);
		assertTrue(firstTestCar.getdest() == 1);
		assertTrue(firstTestCar.getborntime() == 1);
		assertNotNull(testLane.theLane[0]);

		// (6) rmFirstCar, [->null<-, testCar2, null]
		testLane.getFirst();
		assertNull(testLane.theLane[0]);

		//--STEP--// [->testCar<-, null, null]
		testLane.step();

		// (7) getFirst, [->null<-, null, null]
		Car getFirstTestCar = testLane.getFirst();
		assertTrue(getFirstTestCar == testCar2);
		assertTrue(getFirstTestCar.getdest() == 2);
		assertTrue(getFirstTestCar.getborntime() == 2);
		assertNull(testLane.theLane[0]);
		
		
		// [null, null, null]

		
		// (1) lastFree
		// (2) firstFree
		// (3) putLast
		// (4) laneStep
		// (5)firstCar
		// (6)rmFirstCar
		// (7)getFirst

	}

}