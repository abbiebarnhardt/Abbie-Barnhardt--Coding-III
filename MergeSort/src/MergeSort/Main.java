package MergeSort;

import java.util.Random;

public class Main {

	public static void main(String[] args) 
	{
		int[] array = randomArray(100000,1,1000000);
		int[] arrayOne = cloneArray(array);
		int[] arrayTwo = cloneArray(array);
		int[] arrayThree = cloneArray(array);
		
		
		double startTime = System.currentTimeMillis();
		mergeSort(arrayOne, 0 , arrayOne.length-1);
		double endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayOne.length + " took merge sort  " + (endTime - startTime) + " milliseconds to complete");

		startTime = System.currentTimeMillis();
		mergeSort(arrayTwo, 0 , arrayTwo.length-1);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayTwo.length + " took merge sort  " + (endTime - startTime) + " milliseconds to complete");

		startTime = System.currentTimeMillis();
		mergeSort(arrayThree, 0 , arrayThree.length-1);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayThree.length + " took merge sort  " + (endTime - startTime) + " milliseconds to complete");

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
	   
    public static int[] mergeSort(int[] arr, int i, int j) 
    {
    	if (i < j)
    	{
    		//Call merge sort on the left and right halves
    		mergeSort(arr, i, (i+j)/2);
    		mergeSort(arr, (i+j)/2+ 1, j);
    		
    		
    		// Merge left and right partition in sorted order
    		//declare variables needed for merging
    		int left = i;
    		int right = (i+j)/2 + 1;
    		int mid = (i+j)/2;
    		
    		//go through left mini array and right mini array
    		while (left <= mid && right <=j)
    		{
    			//if the left variable is already smaller, no switching needed
    			if(arr[left] <= arr[right])
    			{
    				left++;
    			}
    			
    			//if not, must switch
    			else 
    			{
    				//switch values
    				//keep track of the variable on the right, shift everything right
    				int value = arr[right];
    				int index = right;
    				
    				while (index != left)
    				{
    					arr[index] = arr[index-1];
    					index--;
    				}
    				
    				//put the value that was at right at left
    				arr[left] = value;
    				
    				//increment so we can check the next numbers
    				left++;
    				mid++;
    				right++;
    						
    			}
    		}
    		
		}
    	
    	return arr;
	}
}
