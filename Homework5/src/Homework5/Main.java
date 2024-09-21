package Homework5;

public class Main 
{
	public static void main(String[] args) 
	{
		fib(10);
		fib(8);
		fib(22);
		fib(3);
		fib(9);
	}

	public static int fib(int value)
	{
		int [] tracker = new int[value];
		tracker[0]= 1;
		tracker[1] = 1;
		int counter = 2;
		
		while (counter < value)
		{
			tracker[counter] = tracker[counter-1]+ tracker[counter-2];
			counter++;
		}
		System.out.println("Value: " + value);
		System.out.println("Counter: " + counter);
		System.out.println("Result: " + tracker[value-1]);
		System.out.println();
		return tracker[value-1];
	}
}


