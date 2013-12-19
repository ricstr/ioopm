public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int _period, int _green) {
	this.period = _period;
	this.green = _green;
	this.time = 0;}

    public void    step() {
	if (this.time < this.period){
	    this.time++;}
	else{
	    this.time = 0;}
       // Stegar fram klocka ett steg
    }

    public boolean isGreen(){
	return (this.time<=this.green);
	// Returnerar true om time<green, annars false

}
    
    public String color(){
	if (isGreen()){
	    return "Green";
	}
	else
	    return "Red";
    }

    public String  toString()  {
     return "Light(period=" + this.period + "time=" 
		+ this.time + "green=" + this.green;}

	
}
