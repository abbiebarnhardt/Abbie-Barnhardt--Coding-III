package Homework10;

public class SinglyLinkedList 
{
	public SinglyLinkedListNode header;
	public int length; //not necessary
	
	//constructor
	public SinglyLinkedList() 
	{
		this.header = null;
		this.length = 0;
	}
	
	//return the length of the list
	public int GetLength() 
	{
		return this.length;
	}
	
	//check to see if the list is empty
	public boolean IsEmpty() 
	{
		return this.header == null;
	}
	
	//add node to the end of the list. If the list is empty, make it the head. Else, make it the tail
	public void Append(int value) 
	{
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		//if the list is empty, make the new node the head
		if (this.IsEmpty()) 
		{ 
			this.header = newNode;
			this.length++;
		} 
		
		//if the list is not empty, make the new node the tail
		else 
		{
			//find the current tail
			SinglyLinkedListNode tail = this.header;
			while(tail.nextNode != null) 
			{
				tail = tail.nextNode;
			}
			tail.nextNode = newNode;
			this.length++;
			//make the tail node's next be the newNode
		}
	}
	
	//add the new node to the front
	public void Prepend(int value) 
	{
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		newNode.nextNode = this.header;
		this.header = newNode;
		this.length++;
	}
	
	//insert the new node after a specific node
	public void InsertAfter(SinglyLinkedListNode a, int value) 
	{
		SinglyLinkedListNode b = a.nextNode;
		SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
		a.nextNode = newNode;
		newNode.nextNode = b;
		this.length++;
	}
	
	//delete the specified node from the list. If the node does not exist, return false
	public boolean Remove(SinglyLinkedListNode node) 
	{
		//if the list is empty, we do not need to check for it
		if (this.IsEmpty()) 
		{
			return false;
		} 
		else 
		{
			//check if the header is the specified node
			if (this.header == node) 
			{
				//if it is and is the only node in the list, remove the header and set length to 0
				if (this.header.nextNode == null) 
				{
					this.header = null;
					this.length = 0;
				} 
				//if it is but is not the only node in the list, set the header to the next element and reduce the length
				else 
				{
					this.header = this.header.nextNode;
					this.length--;
				}
				
				//get rid of the deleted node
				node.nextNode = null;
				
				//return true so it stops checking 
				return true;
			} 
			//if the specified node is not the header
			else 
			{
				//record the previous node so when the specified node is deleted, the pointers can be updated
				SinglyLinkedListNode previous = this.header;
				
				//while there are still elements to check
				while (previous.nextNode != null)
				{
					//check if the node is the specified one
					if (previous.nextNode == node) 
					{
						//change current the node to point to the node after the specified node
						previous.nextNode = previous.nextNode.nextNode;
						//reduce the length
						this.length--;
						//delete the node
						node.nextNode = null;
						//return so it stops checking
						return true;
					} 
					//continue to the next node
					else 
					{
						previous = previous.nextNode;
					}
				}
				
				//if all elements have been checked but the specified node has not been found, return false
				return false;
			}
		}
		
	}
	//return the first node that matches the specified node
	public SinglyLinkedListNode Search(int value) 
	{
		//create tracking variable
		SinglyLinkedListNode node = this.header;
		//while there are still elements left to check
		while (node != null) 
		{
			//if the node is the specified one
			if (node.payload == value) 
			{
				return node;
			} 
			//if it isn't, move onto the next node
			else 
			{
				node = node.nextNode;
			}
		}
		//if the element is not in the list, return null
		return null;
	}
	
	//print
	public void Print() 
	{
		System.out.println(this);
	}
	
	//object-oriented programming
	@Override
	public String toString() 
	{
		//if the list is empty, return 0 in string form
		if (this.IsEmpty()) 
		{
			return "(0){empty}";
		}
		
		//create a tracking variable
		SinglyLinkedListNode node = this.header;
		//get the length and the first node
		String output = "(" + this.GetLength() + ")" + "{"+ node;
		//move to the next node
		node = this.header.nextNode;
		//keep going through the list until you get to the end
		while (node != null) 
		{
			//add that node to the string
			output = output + ", " + node;
			//move to the next node
			node = node.nextNode;
		}
		//finish the output string
		output = output + "}";
		//return the string
		return output;
	}
	
	//print the list in reverse order
	public void PrintReverse() 
	{
		//if the list is empty, print string saying the list is empty
		if (this.IsEmpty()) 
		{
			System.out.println( "(0){empty}");
		}
		
		//create tracking variable
		SinglyLinkedListNode node = this.header;
		//make the node into a string
		String output = node.toString();
		//move to the next node
		node = this.header.nextNode;
		//while there are still elements left to add
		while (node != null)
		{
			//add the new node to the front of the string
			output = node + " < " + output;
			//move to the next node
			node = node.nextNode;
		}
		//print the reversed list
		System.out.println(String.format("(%d){%s}", this.GetLength(), output));
	}
	
	//Sort
	public void Sort(boolean asending) 
	{
		//how?
		//Selection sort
		//1 we pick a node, and find the smallest node starting from that node
		//2 swap the node with the found node
		//3 move to the next node, and repeat step 1 and step 2
		
		//Insertion Sort
		//it is a bad idea using singly linked list because we need to go backwards
		
		//quick sort
		//not a good algorithm for singly linked list, because we also need to go backwards
		
		//merge sort
		//a good algorithm to try on the singly linked list
	}
	
	//something is off...it itn't going through enough times
	public void BubbleSort(boolean ascending)
	{
		//if it's ascending, sort smallest to largest
		if(ascending)
		{
			//out loop, runs once per each element in the list
			for(int i=0; i < this.GetLength(); i++)
			{
				//make a tracker
				SinglyLinkedListNode node = this.header;
				//inner loop, go through each of the variable of the list
				for(int j=0; j < this.GetLength(); j++)
				{
					//if the two nodes to compare exist
					if(node!=null && node.nextNode != null)
					{	
						//if the right node is smaller than the left node
						if (node.payload > node.nextNode.payload) 
						{
							//record the node's value so we can use it in the search function later after node has been removed
							int search = node.payload;
							
							//make a new node in the right spot and delete the old one from the wrong spot
							this.InsertAfter(node.nextNode, node.payload);
							this.Remove(node);
							
							//Use search function to reassign node since the original was deleted
							node = this.Search(search);
						}
					}
					//move onto the next node
					if(node != null && node.nextNode!=null) 
					{
						node = node.nextNode;
					}

				}
			}
			//display the sorted list
			this.Print();
		}
		
		//if it's descending, sort largest to smallest
		else
		{
			for(int i=0; i < this.GetLength(); i++)
			{
				SinglyLinkedListNode node = this.header;
				for(int j=0; j < this.GetLength(); j++)
				{
					if(node!=null && node.nextNode != null)
					{	
						if (node.payload < node.nextNode.payload) 
						{
							int search = node.payload;
							this.InsertAfter(node.nextNode, node.payload);
							this.Remove(node);

							node = this.Search(search);
						}
					}
					if(node != null && node.nextNode!=null) 
					{
						node = node.nextNode;
					}

				}
			}
			this.Print();
		}
		
	}
}
