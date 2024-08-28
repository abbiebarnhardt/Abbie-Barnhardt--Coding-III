package homework_08_28_24;
import java.util.Random;

public class Salesman {

	String name;
	float sales;
	
	public Salesman(String name, float sales) 
	{
		this.name = name;
		this.sales = sales;
	}

	public static void main(String[] args) 
	{
		String[] randomNames = {"Bill", "Joe", "Sally", "Greta", "Coco", "Steve", "George", "Susan", "Jill", "Karmen"};
		Salesman [] allSales = new Salesman[10];
		for (int i = 0; i < allSales.length; i++)
		{
			allSales[i] = new Salesman(randomNames[i], (float)((Math.random())* 17891.1));
		}
		
		for(int i = 0; i < allSales.length; i++)
		{
			System.out.println("Name: " + allSales[i].name +  ", Sales: " + allSales[i].sales);
		}
		System.out.println();
		
		getTopFive(allSales);
	}
	
	public static Salesman[] getTopFive(Salesman[] allSales)
	{
		Salesman[] sortSales = allSales;
		for(int i = 0; i < sortSales.length; i++)
		{
			for (int j = i+1; j < sortSales.length; j++)
			{
				float temp = (float)(0);
				if (sortSales[j].sales > sortSales[i].sales)
				{
					temp = sortSales[i].sales;
					sortSales[i].sales = sortSales[j].sales;
					sortSales[j].sales = temp;
				}
			}
		}
		
		for(int i = 0; i < allSales.length; i++)
		{
			System.out.println("Name: " + sortSales[i].name +  ", Sales: " + sortSales[i].sales);
		}
		
		System.out.println();
		
		Salesman[] top5 = new Salesman[5];
		for (int i = 0; i <sortSales.length; i++)
		{
			top5[i] = sortSales[i];
			System.out.println("Name: " + top5[i].name +  ", Sales: " + top5[i].sales);
		}
		return top5;
	}
}
