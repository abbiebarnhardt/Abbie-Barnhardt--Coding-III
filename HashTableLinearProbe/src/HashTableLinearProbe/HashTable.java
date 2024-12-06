package HashTableLinearProbe;

import java.util.Random;

public class HashTable {

    public int Size;
    public Item[] Table;

    // Constructor to initialize the hash table
    public HashTable(int Size) {
		this.Size = Size;
		this.Table = new Item[Size];
		//we need to give the initial array each item
		//empty-since-start flag
		//empty-after-removal
		//common item
		for(int i = 0; i < this.Size; i++) {
			this.Table[i] = new Item();
		}
	}
	
	public int Hashing(int Key) {
		return Key % this.Size;
	}
	
	//return true when success
	//return false when the table is full or there is nothing to update
	public boolean Insert(int key, String value) {
		int index = Hashing(key);
		Item toCheck = this.Table[index];
		int count = 0;
		while (count < this.Size) {
			if (toCheck.Flag == ItemFlag.empty_since_start ||
					toCheck.Flag == ItemFlag.empty_after_removal) {
				Item newItem = new Item(key, value);
				this.Table[index] = newItem;
				return true;
			} else if (toCheck.Key == key) {
				toCheck.Value = value; //upate
				return true;
			} else {
				index++;
				if (index == this.Size) {
					index = 0;
				}
				toCheck = this.Table[index];
				count++;
			}
		}
		return false;
	}

    // search for an item
    public Item Search(int key) 
    {
    	//make variables
        int count = 0;
        int index = Hashing(key);
        Item toCheck = this.Table[index];
        //look through the whole hash table
        while (count < this.Size) 
        {
            //if you find the item
            if (toCheck.Flag == ItemFlag.normal && toCheck.Key == key) 
            {
            	//return it
                return toCheck;
            }
            
            //if the item isn't found, 
            //increase the count to make sure you don't go through multiple times
            count++;
            //increase the count to go to the next bucket
            index++;
            //if you've reached the last bucket, go back to the first
            if (index == this.Size) 
            {
                index = 0;
            }
            //check the next bucket
            toCheck = this.Table[index];
        }
        //if you never find it, return null
        return null;
    }

    // remove an item
    public void Remove(int key) 
    {
    	//find the requested item
        Item item = Search(key);
        //if it exists
        if (item != null) 
        {
        	//remove it
            item.Flag = ItemFlag.empty_after_removal;
        } 
    }
    

    // display the contents of the hash table
    public void Display() 
    {
    	//go through the hash table
        for (int i = 0; i < this.Size; i++) 
        {
        	//set the current item
            Item item = this.Table[i];
            //if there is an item, print it
            if (item != null && item.Flag != ItemFlag.empty_since_start && item.Flag != ItemFlag.empty_after_removal) {
                System.out.println("Bucket " + i + ": " + item.Key);
            }
            //if there isn't, print nothing
            else
            {
            	System.out.println("Bucket " + i + " ");
            }
        }
        System.out.println();
    }

    // fill the hash table with random integers
    public void fill(int number, int max) 
    {
    	//make random thingy
        Random random = new Random();
        //go through however many times as requested
        for (int i = 0; i < number; i++) 
        {
        	//generate a random number and insert it into the hash table
            int key = random.nextInt(max);
            String value = "Value" + key;
            this.Insert(key, value);
        }
    }
}
