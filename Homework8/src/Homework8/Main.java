package Homework8;

import java.util.Random;

public class Main {

	public static void main(String[] args) 
	{
		int[] array = randomArray(100000,1,10000000);
		int[] arrayOne = cloneArray(array);
		int[] arrayTwo = cloneArray(array);
		int[] arrayThree = cloneArray(array);
		int[] arrayFour = cloneArray(array);
		int[] arrayFive = cloneArray(array);
		int[] arraySix = cloneArray(array);
		System.out.println();
		
		int[] gaps = getGaps(arrayOne.length);
		
		double startTime = System.currentTimeMillis();
		shellSort(arrayOne, gaps);
		double endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayOne.length + " took shell sort  " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		shellSort(arrayTwo, gaps);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayTwo.length + " took shell sort  " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		shellSort(arrayThree, gaps);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayThree.length + " took shell sort  " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		shellSort(arrayFour, gaps);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayFour.length + " took quick sort  " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		shellSort(arrayFive, gaps);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayFive.length + " took quick sort  " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		shellSort(arraySix, gaps);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arraySix.length + " took quick sort  " + (endTime - startTime) + " milliseconds to complete");
		
		
	}
	
	public static void printArray(int [] arr)
	{
	   for(int i = 0; i < arr.length; i++)
	   {
		   System.out.print(arr[i] + ", ");
	   }
	   System.out.println();
	}
	
	public static int[] randomArray(int size, int min, int max)
	{
		if (max-min+1 >= size)
		{
			int [] arr = new int[max-min+1];
			
			for (int i = 0; i < (max-min +1); i++)
			{
				arr[i] = min+i;
			}
			
			shuffle(arr);
			int[] shuffledArray = new int[size];
			for(int i=0; i < size; i++)
			{
				shuffledArray[i] = arr[i];
			}

			//printArray(shuffledArray);
			System.out.println("Generate Array Done");
			System.out.println();
			return shuffledArray;
		}
		else
		{
			return null;
		}

	}
	
	public static void shuffle(int[] arr)
	{
		Random random = new Random();
		for (int i = 0; i < arr.length/2; i++)
		{
			int firstIndex = random.nextInt((arr.length - 1));
			int secondIndex = random.nextInt((arr.length - 1));
			int temp = arr[firstIndex];
			arr[firstIndex] = arr[secondIndex];
			arr[secondIndex] = temp;
		}
	}
	
	public static int[] cloneArray(int[] arr)
	{
		int [] clone = new int [arr.length];
		
		for(int i = 0; i < arr.length; i++)
		{
			clone[i] = arr[i];
		}
		
		System.out.println("Clone Array Done");
		return clone;
	}
	
	public static int[] shellSort(int[] arr, int[] gaps)
	{
		//go through for each number in gaps
		//g keeps track of which gap we are currently using
	    for (int g = 0; g < gaps.length; g++) 
	    {
		  //make the sub arrays using the gaps
	    	//i keeps track of how many sub arrays are made
	      for (int i = 0; i < gaps[g]; i++) 
	      {
    	   //more making the sub arrays
	       //j keeps track of which numbers are in which sub arrays
		  	   for (int j = i + gaps[g]; j < arr.length; j += gaps[g]) 
			   {
		  		  //do insertion sort
		  		  //k is for moving the element within the sub array
			      int k = j;
			      while (k - gaps[g] >= i && arr[k] < arr[k - gaps[g]]) 
			      {
			    	 //swap the numbers
			         int temp = arr[k];
			         arr[k] = arr[k - gaps[g]];
			         arr[k - gaps[g]] = temp;
			         k -= gaps[g];
			      }
			   }
	      }
	   }
	   
	   //print sorted array
	   //printArray(arr);
	   return arr;
	}
	
	public static int[] getGaps(int size)
	{
		int counter = 1;
		double temp = 0;
		
		while(temp < size)
		{
			temp = Math.pow(2,counter) -1;
			counter++;
		}
		
		int [] gaps = new int[counter-2];
		
		for (int i = 0; i < gaps.length; i++)
		{
			gaps[i] = (int)(Math.pow(2,i+1) -1);
			//System.out.println(gaps[i]);
		}
		
		System.out.println("Done Making Gaps");
		System.out.println();
		return gaps;
	}
	
	public static int[] quicksort(int [] arr, int start, int end)
	{
		   // base case, make sure there are enough elements to try to sort
		   if (end <= start) 
		   {
		      return null;
		   }
		   
		   // if there are, then call quicksort on the high and low partitions
		   else 
		   {
			   //partition the values and determine the last value in the low partition
			   
			   //find the middle value to set the pivot
			   int middle = start + (end - start) / 2;
			   int pivot = arr[middle];
			   
			   // "low" and "high" start at the ends of the array segment
			   // and move towards each other.
			   int low = start;
			   int high = end;
			   
			   while (low < high) {
			      // Increment low while numbers[low] < pivot
			      while (arr[low] < pivot) {
			         low = low + 1;
			      }
			      
			      // Decrement high while pivot < numbers[high]
			      while (pivot < arr[high]) {
			         high = high - 1;
			      }
			      
			      // Make sure low and high haven't crossed each other
			      if (low < high) 
			      {
			    	  //switch a low and high element
			         int temp = arr[low];
			         arr[low] = arr[high];
			         arr[high] = temp;
			         low++;
			         high--;
			      }
			   }

			   // Recursively sort the low and high partitions
			   quicksort(arr, start, high);
			   quicksort(arr, high + 1, end);
		   }

		return arr;
	}

}
