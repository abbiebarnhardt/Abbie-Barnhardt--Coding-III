package HashTable;

import java.util.Random;

public class HashTableChaining {
	public int Size;
	public List[] Table;
	
	public HashTableChaining(int InitialSize) {
		this.Size = InitialSize;
		this.Table = new List[this.Size];
	    for (int i = 0; i < this.Size; i++) 
	    {
	        this.Table[i] = new List(); 
	    }
	}
	
	public int HashingFunction(int key) {
		return key % this.Size;
	}
	
	public void Insert(int key, String value) 
	{
		int index = HashingFunction(key);
		Node newNode = new Node();
		newNode.Key = key;
		newNode.Value = value;
		this.Table[index].Append(newNode);
	}
	
	public Node Search(int key) {
		int index = HashingFunction(key);
		return this.Table[index].Search(key);
	}
	
	public void Remove(int key) {
		int index = HashingFunction(key);
		this.Table[index].Remove(key);
	}
	
	public void Display() 
	{
		//go through each bucket
		for(int i = 0; i < Size; i ++)
		{
			System.out.print("Bucket " + i + " : ");
			//initialize tracker node
			Node currentNode = Table[i].Head;
			//while there is a node
			while (currentNode != null)
			{
				//print the node
				System.out.print(currentNode.Value + ", ");
				//move onto the next node
				currentNode = currentNode.NextNode;
			}
			
			System.out.println();

		}
		System.out.println();
	}
	
	//create a method for filling the hash table with random numbers
	public void fillHashTable(int max, int size )
	{
		Random rn = new Random();
		for(int i = 0; i < size; i++)
		{
			//generate a random number from 0 to max
			int answer = rn.nextInt(max);
			//insert the random number into the hash table
			this.Insert(answer, Integer.toString(answer));
			
		}
		
	}


}