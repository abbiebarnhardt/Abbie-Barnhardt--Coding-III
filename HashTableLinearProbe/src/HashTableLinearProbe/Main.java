package HashTableLinearProbe;

public class Main {

	public static void main(String[] args) 
	{
		HashTable hashTable = new HashTable(10);
		System.out.println("Add three random:");
		hashTable.fill(3,100);
		hashTable.Display();
		
		System.out.println("Add two specific:");
		hashTable.Insert(22, "Value22");
		hashTable.Insert(19, "Value19");
		hashTable.Display();
		
		System.out.println("Add three more random:");
		hashTable.fill(3, 100);
		hashTable.Display();
		
		System.out.println("Add two more specific:");
		hashTable.Insert(3, "Value3");
		hashTable.Insert(47, "Value47");
		hashTable.Display();
		
		System.out.println("Add ten more random:");
		hashTable.fill(10, 100);
		hashTable.Display();
		
		System.out.println("Remove 22 and 3:");
		hashTable.Remove(22);
		hashTable.Remove(3);
		
		hashTable.Display();
		
		System.out.println("Check to see if new value was added:");
		hashTable.Insert(25, "Value25");
		hashTable.Display();
		
		System.out.println(hashTable.Search(19));
		System.out.println(hashTable.Search(47));
		

	}

}
