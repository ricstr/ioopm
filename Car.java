

public class Car {

    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng


    public Car(int time, int dest2Int){
        bornTime = time;
	if (dest2Int >= (Math.random()*100))
	dest = 2;
	    else
		dest = 1;
    }

	public int getdest(){
	    return this.dest;}

	public int getborntime(){
	    return this.bornTime;}


    // konstruktor och get-metoder
    

	public String toString() {
	    return "Car(bornTime=" + this.bornTime + "destination=" 
		+ this.dest;}
	



}
