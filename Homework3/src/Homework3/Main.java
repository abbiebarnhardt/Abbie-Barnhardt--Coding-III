package Homework3;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println(isAllUnique("stack"));
		System.out.println(isAllUnique("unique"));
	}
	
	public static Boolean isAllUnique(String string)
	{
		for (int i = 0; i < string.length(); i++)
		{
			String temp = string.substring(i, i+1);
			for (int j = i+1; j < string.length(); j++)
			{
				if (temp.equals(string.substring(j, j+1)))
				{
					return false;
				}
			}
		}
		return true;
	}
}
