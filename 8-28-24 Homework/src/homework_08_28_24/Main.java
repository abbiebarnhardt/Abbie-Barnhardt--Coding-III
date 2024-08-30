package homework_08_28_24;

public class Main {

	public static void main(String[] args)
	{
		String[] randomNames = {"Stan", "Joe", "Sally", "Greta", "Coco", "Steve", "George", "Susan", "Jill", "Karmen"};
		Salesman [] allSales = new Salesman[10];
		for (int i = 0; i < allSales.length; i++)
		{
			allSales[i] = new Salesman(randomNames[i], (float)((Math.random())* 17891.1));
		}
		
		for(int i = 0; i < allSales.length; i++)
		{
			System.out.println("Name: " + allSales[i].getName() +  ", Sales: " + allSales[i].getSales());
		}
		System.out.println();
		
		Salesman.getTopFive(allSales);		
	}

}
