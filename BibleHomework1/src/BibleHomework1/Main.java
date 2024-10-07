package BibleHomework1;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println(question1(7700000000.0, 13, 2, 3));
		System.out.println(question2(7700000000.0, 13, 50, 3));

	}
	
	public static double question1(double population, int startingNumberOfDisciples, int numberTrainedAtOnce, int numberOfYearsToTrain) 
	{
		double result;
		
		result = Math.log((population)/ startingNumberOfDisciples)/ Math.log(numberOfYearsToTrain)*numberOfYearsToTrain;
		
		return result;
	}
	
	public static double question2(double population, double startingNumberOfDisciples, double totalYearsToTrain, double numberOfYearsToTrain)
	{
		double result;
		
		result = Math.pow((population/startingNumberOfDisciples), (numberOfYearsToTrain/totalYearsToTrain))-1;

		return result;
	}
}
