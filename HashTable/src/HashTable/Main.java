
package HashTable;
import java.util.Random;

public class Main {

	public static void main(String[] args) 
	{
		HashTableChaining hashTable = new HashTableChaining(10);
		hashTable.Insert(24, "24");
		hashTable.Insert(2, "2");
		hashTable.fillHashTable(1000, 10);
		hashTable.Insert(19, "19");
		hashTable.Insert(15, "15");
		hashTable.fillHashTable(1000, 10);
		hashTable.Insert(222,"222");
		hashTable.Insert(7,  "7");
		hashTable.Display();
		
		hashTable.Remove(19);
		hashTable.Remove(24);
		hashTable.Remove(7);
		hashTable.Display();
		
		System.out.println(hashTable.Search(2));
		System.out.println(hashTable.Search(15));
		System.out.println(hashTable.Search(222));
		


	}
	

}
