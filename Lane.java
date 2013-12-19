
public class Lane {

   public static  class OverflowException extends RuntimeException {

       public OverflowException() {
	   super();
       }

       public OverflowException(String msg){
	   super(msg);}

	// Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    public Car[] theLane;

    public Lane(int n) {
	this.theLane = new Car[n];
       
	// Konstruerar ett Lane-objekt med plats för n fordon
    }

    public void step() {


       	int n = this.theLane.length;
	    for (int i = 1; i <= n-1; i++){
	      if (this.theLane[i-1] == null) {
		  this.theLane[i-1] = this.theLane[i];
		  this.theLane[i] = null;}
		    } 

	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }

    public Car getFirst() {
	Car first = this.theLane[0];
	this.theLane[0] = null;
	return  first;
	
	// Returnera och tag bort bilen som står först
    }

    public Car firstCar() {
	    return this.theLane[0];
	// Returnera bilen som står först utan att ta bort den
    }


    public boolean lastFree() {
	int lenght = this.theLane.length;
	return (this.theLane[lenght-1] == null);
	    
	// Returnera true om sista platsen ledig, annars false
    }

     public void putLast(Car c) throws OverflowException  {
	int lenght = this.theLane.length;
	if (this.lastFree()){
	    this.theLane[lenght - 1] = c;}
	else {
	 System.out.println("test");
         throw new OverflowException(); } 



	// Ställ en bil på sista platsen på vägen
	// (om det går).
     }

    public String toString() {
	String returnString = "";
	int lenght = this.theLane.length;
	for(int i = 0; i <= lenght-1; i++){
	    if(this.theLane[i] == null){
		returnString = (returnString + "- ");	
	    }
	    else{
		returnString = (returnString + "[" + this.theLane[i].getdest() + "] ");
	    }
	}
	    return returnString;

    }
    
}