package CeaserCipher;

public class Main 
{

	public static void main(String[] args) 
	{
		//testing if it has to go back to the start of the alphabet
		ceaserCipher("zebra", 2);
		//testing shifting the opposite direction
		ceaserCipher("A cat", -3);
		//testing my name for funsies
		ceaserCipher("Abbie Barnhardt", 19);
		//testing a string with non-leters
		ceaserCipher("d0g", 2);
	}

	public static String ceaserCipher(String plainText, int shift)
	{
		//print the original text
		System.out.println("Plain Text: " + plainText);
		
		//make the alphabet for creating the cipher text
		String alphabet ="abcdefghijklmnopqrstuvwxyz";
		
		//create black cipher text so we can add to it each time we shift a letter
		String cipherText ="";
		
		//go through each character in the plain text
		for(int i = 0; i < plainText.length(); i++)
		{
			//find the index of that character in the alphabet
			int ogIndex = characterSearch(plainText.substring(i, i+1));

			//if it is in the alphabet
			if(ogIndex >= 0)
			{
				//find the shifted letter. Use mod in case the shift requires it to go back to the start of the alphabet
				int newIndex = (ogIndex+ shift) % alphabet.length(); 
				//if you are shifting to the right, make the new index positive so we can index the alphabet string
				if(newIndex <0)
				{
					//make the index positive so we can index the alphabet
					newIndex = newIndex + alphabet.length();
				}
				//if it is uppercase
				if (Character.isUpperCase(plainText.substring(i, i+1).charAt(0)))
                {
					//add the uppercase version of the character to the cipher text
                    cipherText += alphabet.substring(newIndex, newIndex + 1).toUpperCase();
                }
				//if it is lowercase
                else
                {
                	//add the lowercase version of the character to the cipher text
                    cipherText += alphabet.substring(newIndex, newIndex + 1);
                }
				
			}
			//if the character is a space
			else if (ogIndex == -2)
			{
				//add a space to the cipher text
				cipherText = cipherText+ " ";
			}
			
			//if the character is not in the alphabet and is not a space
			else if (ogIndex ==-1)
			{
				//error
				System.out.println("Error: Illegal Character");
				return "";
			}
				
			
		}
		//print and return the cipher text
		System.out.println("Cipher Text: " + cipherText);
		return cipherText;
	}
	
	
	public static int characterSearch(String character)
	{
		//create the alphabet for parsing
		String alphabet ="abcdefghijklmnopqrstuvwxyz";
		
		//go through the alphabet until it finds the letter
		for(int i =0; i < alphabet.length(); i++)
		{
			//if it finds the letter
			if (alphabet.substring(i, i+1).equals(character.toLowerCase()))
			{
				//return the index
				return i;
			}
		}
		
		//if the character is a space
		if (character.equals(" "))
		{
			return -2;
		}
		
		//if the character is not a letter or space
		return -1;
	}
}
