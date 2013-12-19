public class Simulation {

    public static void main(String [] args) {
	TrafficSystem autobahn = new TrafficSystem();
	
	for (int i = 0; i<60; i++){

	     try {
		Thread.sleep(100);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    
	    autobahn.print();
	    autobahn.step();
          }
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder

	autobahn.printStatistics();


    }
}
