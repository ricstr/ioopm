import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;

    private int arrivalInt;
    private int d2Int;
    private int greenTime1;
    private int greenTime2;
    private int periodTime;
    private int r0Length;
    private int r12Length;

    
    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling
    public int cars = 0;
    private int fastest;
    private int slowest;
    private int meen = 0;
    public int overflow = 0;
    
    private int time = 0;

    public TrafficSystem() {
	this.readParameters();
	this.r0 = new Lane(r0Length);
	this.r1 = new Lane(r12Length);
	this.r2 = new Lane(r12Length);
	this.s1 = new Light(periodTime, greenTime1);
	this.s2 = new Light(periodTime, greenTime2);
	
}

    public void readParameters() {
/*	this.arrivalInt = 50;
	this.d2Int = 25;
	this.greenTime1 = 8;
	this.greenTime2 = 5;
	this.periodTime = 15;
	this.r0Length = 10;
	this.r12Length = 5; */
	
	Properties prop = new Properties();
 
    	try {
               //load a properties file
    		prop.load(new FileInputStream("trafficsParam"));
 
               //get the property value and print it out
		this.arrivalInt =Integer.parseInt(prop.getProperty("arrivalInt"));
		this.d2Int =Integer.parseInt(prop.getProperty("d2Int"));
		this.greenTime1 =Integer.parseInt(prop.getProperty("greenTime1"));
		this.greenTime2 =Integer.parseInt(prop.getProperty("greenTime2"));
		this.periodTime =Integer.parseInt(prop.getProperty("periodTime"));
      	this.r0Length =Integer.parseInt(prop.getProperty("r0Length"));
		this.r12Length =Integer.parseInt(prop.getProperty("r12Length"));
 
    	} 
    	catch (IOException ex) {
    		ex.printStackTrace();
        }

	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 
    }

    public void step() {



       

	if (this.s1.isGreen()){

	    Car out1 = this.r1.getFirst();
	    
	    if (out1 != null){
		int time2 = time - out1.getborntime();
		if(time2 < fastest | cars == 0){
		    fastest =time2;
		}
		else if(time2 > slowest){
		    slowest = time2;
		}
		meen += time2;
		cars++;
	    	
	    }
	} 

	if (this.s2.isGreen()){
	    Car out2 = this.r2.getFirst();
	    
	    if (out2 != null){
		int time2 = time - out2.getborntime();
		if(time2 < fastest | cars == 0){
		    fastest = time2;
		}
		else if(time2 > slowest){
		    slowest = time2;
		}
		meen += time2;
		cars++;
	    	
	    }
	}
	this.r1.step();
	this.r2.step();
	

	
	if(this.r0.firstCar() != null){

	    Car temp = this.r0.firstCar();

	    //this.r0.firstCar().getdest()
	if ((temp.getdest() == 1) && this.r1.lastFree())
	    this.r1.putLast(this.r0.getFirst());
	else
	    if ((temp.getdest() == 2) && this.r2.lastFree())
		this.r2.putLast(this.r0.getFirst());
	}
	    

	//this.r1.step();
        //this.r2.step();
	this.r0.step();
	this.s1.step();
	this.s2.step();
	this.time++;

       	
    

	if((this.arrivalInt >= (Math.random()*100))) /*  && (this.r0.lastFree()))) */{
		Car ake = new Car(time, d2Int);
	   	try { 
		    this.r0.putLast(ake);
		     }
		catch (Lane.OverflowException e) { 
		  System.out.println("fullt i fil");
		  overflow++;
		  }
	   
	  
	}
	   
	

	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
	}

	
    public void printStatistics() {

	System.out.println("Total amount of cars that passed throuh was: " + cars);	
	System.out.println("The fastest car throuh the system had the time: " + fastest);
	System.out.println("The slowest car throuh the system had the time: " + slowest);
	System.out.println("The avrage time for the cars throuh the system was: " + meen/cars);
	System.out.println("Amount of overflows: " + overflow);
	

// Skriv statistiken samlad så här långt
    }

    public void print() {
	System.out.println(this.s1.color() + this.r1.toString() + "    " + this.r0.toString() + "\n" + this.s2.color() +  this.r2.toString() + "\n");
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }

}