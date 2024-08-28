package WeekOneDayTwo;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[] {10,5,8,9,17,21};
		int temp = array[0];
		for (int i = 0 ; i <array.length; i++)
		{
			if (array[i] > temp)
			{
				temp = array[i];
			}
		}
		
		Main obj = new Main();
		
		System.out.println(temp);
		System.out.println(FindMax(array));
		System.out.print(obj.FindMax_1(array));
	}

	public static int FindMax(int[] input)
	{
		int temp = input[0];
		
		for (int i = 0 ; i <input.length; i++)
		{
			if (input[i] > temp)
			{
				temp = input[i];
			}
		}
		
		return temp;
		
	}
	
	public int FindMax_1(int[] input)
	{
		int temp = input[0];
		
		for (int i = 0 ; i <input.length; i++)
		{
			if (input[i] > temp)
			{
				temp = input[i];
			}
		}
		
		return temp;
		
	}
}


