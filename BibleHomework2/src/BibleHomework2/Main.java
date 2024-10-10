package BibleHomework2;

public class Main {

	public static void main(String[] args) 
	{
		//There is not enough information provided
		//Since it was not disclosed, I will assume that everyone starts at age 18
		//Also unclear if those under 18 can be trained, is the rule they can't be trained or train, or just can't train
		//Since it was not disclosed, I will assume they cannot be trained until they are 18
		
		//population, starting number, number trained at once, years to train, birth age, death age, training age
		homework2(7700000000.0, 13.0, 2.0, 3.0, 30.0, 72.0, 18.0);
		System.out.println(homework2(7700000000.0, 13.0, 2.0, 3.0, 30.0, 72.0, 18.0) + " years");
	}
	
	public static double homework2(double worldPopulation, double startingNumberOfDisciples, double numberTrainedAtOnce, double yearsToTrain, double ageGiveBirth, double ageDied, double oldEnoughToTrain)
	{
		//create tracking variables
		double totalTimeElapsed = 0.0;
		double totalPopulation = worldPopulation;
		double totalDisciples = startingNumberOfDisciples;
		double totalOfAgePopulation = 0.0;
		
		//create generation arrays, it is possible for up to 3 generations to be alive at a time
		//generation population, age
		double [] genOne = {worldPopulation, oldEnoughToTrain};
		double [] genTwo = new double[3];
		double [] genThree = new double[3];
		
		//while loop stops when everyone is a disciple
		while (totalPopulation > totalDisciples)
		{
			//if they are old enough to have a kid
			if (genOne[1] == ageGiveBirth)
			{
				//update the population to account for birth, "make" the array for the new generation
				totalPopulation = totalPopulation + (genOne[0] /2);
				genTwo[0] = genOne[0]/2;
				genTwo[1] = 0.0;
				System.out.println("Gen Two Born");
			}
				
			//if they are old enough to have a kid
			if (genTwo[1] == ageGiveBirth)
			{
				//update the population to account for birth, "make" the array for the new generation
				totalPopulation = totalPopulation + (genTwo[0] /2);
				genThree[0] = genTwo[0]/2;
				genThree[1] = 0.0;
				System.out.println("Gen Three Born");
			}
			

			//if they are old enough to have a kid
			if (genThree[1] == ageGiveBirth)
			{
				//update the population to account for birth, "make" the array for the new generation
				totalPopulation = totalPopulation + (genTwo[0] /2);
				genOne[0] = genThree[0]/2;
				genOne[1] = 0.0;
				System.out.println("Gen One ReBorn");
			}
			
			if(genOne[1] ==18)
			{
				totalOfAgePopulation = totalOfAgePopulation + genOne[0];
			}
			
			if(genTwo[1] ==18)
			{
				totalOfAgePopulation = totalOfAgePopulation + genTwo[0];
			}
			
			if(genThree[1] ==18)
			{
				totalOfAgePopulation = totalOfAgePopulation + genThree[0];
			}
			
			//subtract the disciples that are under age
			
			totalDisciples = startingNumberOfDisciples * Math.pow(numberTrainedAtOnce +1, ((totalTimeElapsed+3)/yearsToTrain));
			
			double totalOfAgeDisciples = (totalDisciples)*(totalOfAgePopulation)/totalPopulation;
			double totalUnderAgeDisciples = totalDisciples- totalOfAgeDisciples;
			totalDisciples = totalDisciples- totalUnderAgeDisciples;
			
			
			//update ages, have to make sure the generation exists
			if(genOne[1] != 0 | totalTimeElapsed ==0)
			{
				genOne[1] = genOne[1] + yearsToTrain;
			}
			
			if(genTwo[1] != 0 | totalTimeElapsed == (ageGiveBirth- oldEnoughToTrain))
			{
				genTwo[1] = genTwo[1] + yearsToTrain;
			}
			
			if(genThree[1] != 0 | totalTimeElapsed == ageGiveBirth + (ageGiveBirth- oldEnoughToTrain))
			{
				genThree[1] = genThree[1] + yearsToTrain;
			}

			
			//check if they are old enough to die
			if (genOne[1] >= ageDied)
			{
				//calculate how many disciples were in this generation and update total disciples, total population, and total of age population to account for death
				double generationDisciples = (totalDisciples * genOne[0])/ totalPopulation;
				totalDisciples = totalDisciples - generationDisciples;
				totalPopulation = totalPopulation - genOne[0];
				totalOfAgePopulation = totalOfAgePopulation - genOne[0];
				genOne[0] = 0.0;
				genOne[1] = 0.0;
			}
			
			//check if they are old enough to die
			if (genTwo[1] >= ageDied)
			{
				//calculate how many disciples were in this generation and update total disciples, total population, and total of age population to account for death
				double generationDisciples = (totalDisciples * genTwo[0])/ totalPopulation;
				totalDisciples = totalDisciples - generationDisciples;
				totalPopulation = totalPopulation - genTwo[0];
				totalOfAgePopulation = totalOfAgePopulation - genTwo[0];
				genTwo[0] = 0.0;
				genTwo[1] = 0.0;
			}
			
			//check if they are old enough to die
			if (genThree[1] >= ageDied)
			{
				//calculate how many disciples were in this generation and update total disciples, total population, and total of age population to account for death
				double generationDisciples = (totalDisciples * genThree[0])/ totalPopulation;
				totalDisciples = totalDisciples - generationDisciples;
				totalPopulation = totalPopulation - genThree[0];
				totalOfAgePopulation = totalOfAgePopulation - genThree[0];
				genThree[0] = 0.0;
				genThree[1] = 0.0;
			}
			
			totalTimeElapsed = totalTimeElapsed + yearsToTrain;
			
			System.out.println("Total Population: " + totalPopulation);
			System.out.println("Total Disciples: " + totalDisciples);
			System.out.println("Total Years Elapsed: " + totalTimeElapsed);
			System.out.println();
		}
		
		return totalTimeElapsed;
	}
}
