
import java.util.Scanner;
//import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;


class Globals{
	static ForkJoinPool poolparty = new ForkJoinPool();
}
/////////////////////////////////////////////////////////////////////

public class Sort {

	public Sort() {
		// TODO Auto-generated constructor stub
	}
	
	private static boolean Sorted(int[] arr){
		boolean sorted = true;
		
		for(int i = 1; i<arr.length-1; i++){
			if(arr[i-1]>arr[i])
				sorted = false;
		}
		return sorted;
	}
	
	private static int[] RandomArr(int antal){
		int[] arr = new int[antal];
		int i = 0;
		java.util.Random r = new java.util.Random();
		r.setSeed(66);
		r.nextInt(1000);
		//arr[0] = 4;
		while(i<antal){
			arr[i] = r.nextInt(1000);
			++i;
		}
		arr[0] = 4;
			return arr;
	}

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the first number");
		//get user input for a
		int	a= reader.nextInt();
		reader.close();
		
		int[] array;
		
		for(int i = 0; i<10; i++){
			array = RandomArr(100000);
		//	Quicksort.insertionSort(array, 0, 999);
		//	Quicksort.sQsort(array);
			Quicksort.pQsort(array); 
			
		} 
		
	/*	array[0] = 2;
		array[1] = 5;
		array[2] = 1;
		array[3] = 0;
		array[4] = 9; */
		
		
		array = RandomArr(a);
		int[] array2 = array.clone();
	
		System.out.println(Sorted(array));
		
		long start = System.nanoTime();
		Quicksort.sQsort(array);
		System.out.println((System.nanoTime()) - start);
		
		long start2 = System.nanoTime();
		Quicksort.pQsort(array2);
		System.out.println((System.nanoTime()) - start2);
		
		//for(int i = 0; i<=4; i++)
		//System.out.println(array[i]);
	/*	int i = 0;
		while (i<=array.length-1){
			System.out.println(array[i]);
		i++;
		} */
			
		
		System.out.println(Sorted(array));
	}

}

