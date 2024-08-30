package homework_08_28_24;
import java.util.Random;

public class Salesman {

	private String name;
	private float sales;
	
	public Salesman(String name, float sales) 
	{
		this.name = name;
		this.sales = sales;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public float getSales()
	{
		return this.sales;
	}
	
	public void setSales(float newSales)
	{
		this.sales = newSales;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}
	
	public static Salesman[] getTopFive(Salesman[] allSales)
	{
		Salesman[] sortSales = allSales;
		Salesman[] top5 = new Salesman[5];
		for(int i = 0; i < 5; i++)
		{
			for (int j = i+1; j < sortSales.length; j++)
			{
				float temp = 0;
				if (sortSales[j].getSales() > sortSales[i].getSales())
				{
					temp = sortSales[i].getSales();
					sortSales[i].setSales(sortSales[j].getSales());
					sortSales[j].setSales(temp);
				}
			}
			
			top5[i] = sortSales[i];
			System.out.println("Name: " + top5[i].getName() +  ", Sales: " + top5[i].getSales());
		}

		return top5;
	}
}
