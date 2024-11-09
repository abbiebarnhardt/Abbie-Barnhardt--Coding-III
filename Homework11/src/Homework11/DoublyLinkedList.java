package Homework11;

public class DoublyLinkedList <T>
{
	//Doubly Linked List variables
	public Node<T> Header;
	public Node<T> Tail;
	
	//Doubly Linked List constructor
	public DoublyLinkedList() 
	{
		this.Header = null;
		this.Tail = null;
	}
	
	//Check if the list is empty
	public boolean IsEmpty() 
	{
		return this.Header == null;
	}
	
	//Return the number of nodes in the list
	public int GetLength() 
	{
		int length = 0;
		Node<T> node = this.Header;
		while (node != null) 
		{
			length++;
			node = node.NextNode;
		}
		return length;
	}
	
	//Add a node to the end of the list
	public void Append(Node<T> node) 
	{
		if (this.IsEmpty()) 
		{
			this.Header = node;
			this.Tail = node;
		} 
		else 
		{
			this.Tail.NextNode = node;
			node.PreNode = this.Tail;
			this.Tail = node;
		}
	}
	
	//add a node to the front of the list
	public void Prepend(Node<T> node) 
	{
		if (this.IsEmpty()) 
		{
			this.Header = node;
			this.Tail = node;
		} 
		else 
		{
			node.NextNode = this.Header;
			this.Header.PreNode = node;
			this.Header = node;
		}
	}
	
	//insert node after preNode
	public boolean InsertAfter(Node preNode, Node node) 
	{
		//we do append if preNode is the tail
		if (preNode == this.Tail) 
		{
			this.Append(node);
			return true;
		} 
		
		//if list is empty
		else if (preNode == null) 
		{
			return false;
		} 
		
		//all other cases
		else 
		{
			Node next = preNode.NextNode;
			preNode.NextNode = node;
			node.NextNode = next;
			next.PreNode = node;
			node.PreNode = preNode;
			return true;
		}
	}
	
	//insert node before nextNode
	public boolean InsertAhead(Node nextNode, Node node) 
	{
		//if nextNode is the header
		if (nextNode == this.Header) 
		{
			this.Prepend(node);
			return true;
		} 
		//if nextNode is null
		else if (nextNode == null) 
		{
			return false;
		} 
		//all other cases
		else 
		{
			Node pre = nextNode.PreNode;
			pre.NextNode = node;
			node.NextNode = nextNode;
			nextNode.PreNode = node;
			node.PreNode = pre;
			return true;
		}
	}
	
	//remove a node from the list
	public void Remove(Node node) 
	{
		//if it is the only element in the list
		if (node == this.Header && node == this.Tail) 
		{
			this.Header = null;
			this.Tail = null;
		} 
		//if it is the tail
		else if (node == this.Tail) 
		{
			Node pre = node.PreNode;
			pre.NextNode = null;
			node.PreNode = null;
			this.Tail = pre;
		} 
		//if it is the header
		else if (node == this.Header) 
		{
			Node next = node.NextNode;
			node.NextNode = null;
			next.PreNode = null;
			this.Header = next;
		} 
		//regular case
		else 
		{
			node.PreNode.NextNode = node.NextNode;
			node.NextNode.PreNode = node.PreNode;
			node.NextNode = null;
			node.PreNode = null;
		}
	}
	
	//this is the method find the last instance of the matching node from the beginning
	public Node<T> Search(T value)
	{
		Node node = this.Tail;
		while (node != null) 
		{
			if (node.Payload == value) 
			{
				return node;
			}
			node = node.PreNode;
		}
		return null;
	}
	
	public void PrintList()
	{
		Node currentNode = this.Header;
		while(currentNode !=null)
		{
			System.out.print(currentNode.Payload + ", ");
			currentNode = currentNode.NextNode;
		}
		System.out.println();
	}
	
	public void newInsertionSort(boolean ascending) 
	{
		if(ascending)
		{
			//create the tracking node
		    Node<T> currentNode = this.Header.NextNode;

		    //while the node exists (stops after the tail)
		    while (currentNode != null) 
		    {
		    	//keep track of the node that we will need to move onto next, after we finish moving the current node around
		        Node<T> nextNode = currentNode.NextNode;
		        
		        //keep track of the previous node
		        Node<T> insertPosition = currentNode.PreNode;

		        // if the nodes need to be switched
		        while (insertPosition != null && (insertPosition).compareTo(currentNode) == 1) 
		        {
		            insertPosition = insertPosition.PreNode;
		        }

		        //remove current node
		        this.Remove(currentNode);
		        
		        //if it needs to be reinserted at the header, prepend
		        if (insertPosition == null) 
		        {
		            this.Prepend(currentNode);
		        } 
		        
		        //if not, insert it into the right spot
		        else 
		        {
		            this.InsertAfter(insertPosition, currentNode);
		        }

		        //move onto the next node of the unsorted portion
		        currentNode = nextNode;
		    }
		}
		
		else
		{
			//create the tracking node
		    Node<T> currentNode = this.Header.NextNode;

		    //while the node exists (stops after the tail)
		    while (currentNode != null) 
		    {
		    	//keep track of the node that we will need to move onto next, after we finish moving the current node around
		        Node<T> nextNode = currentNode.NextNode;
		        
		        //keep track of the previous node
		        Node<T> insertPosition = currentNode.PreNode;

		        // if the nodes need to be switched
		        while (insertPosition != null && (insertPosition).compareTo(currentNode) == -1) 
		        {
		            insertPosition = insertPosition.PreNode;
		        }

		        //remove current node
		        this.Remove(currentNode);
		        
		        //if it needs to be reinserted at the header, prepend
		        if (insertPosition == null) 
		        {
		            this.Prepend(currentNode);
		        } 
		        
		        //if not, insert it into the right spot
		        else 
		        {
		            this.InsertAfter(insertPosition, currentNode);
		        }

		        //move onto the next node of the unsorted portion
		        currentNode = nextNode;
		    }
		}
		
	    
	    this.PrintList();
	}
}
