package SortingHomework;
import java.util.Random;

public class Main {

	public static void main(String[] args) 
	{
		int[] array = randomArray(100000,1,100000000);
		int[] arrayOne = cloneArray(array);
		int[] arrayTwo = cloneArray(array);
		int[] arrayThree = cloneArray(array);
		int[] arrayFour = cloneArray(array);
		
		long startTime = System.currentTimeMillis();
		selectionSort(arrayOne);
		Long endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayOne.length + " took selection sort " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		bubbleSort(arrayTwo);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayTwo.length + " took bubble sort " + (endTime - startTime) + " milliseconds to complete");
		
		startTime = System.currentTimeMillis();
		insertionSort(arrayThree);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting a random array of size " + arrayThree.length + " took insertion sort  " + (endTime - startTime) + " milliseconds to complete");
	}
	
	public static void printArray(int [] arr)
	{
	   for(int i = 0; i < arr.length; i++)
	   {
		   System.out.print(arr[i] + ", ");
	   }
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
	
	public static int[] selectionSort(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i+1; j < arr.length; j++)
			{
				if (arr[j] < arr[i])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	
		//printArray(arr);
		System.out.println();
		return arr;
	}
	
	public static int[] bubbleSort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length-1-i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//printArray(arr);
		System.out.println();
		return arr;
	}
	
	public static int[] insertionSort(int[] arr)
	{
		for (int i= 0; i < arr.length-1; i++)
		{
			int j = i+1;
			while (j>0 && arr[j-1] > arr[j])
			{
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j = j-1;
			}
		}
		
		//printArray(arr);
		System.out.println();
		return arr;
	}

}
