package Week11Day3;

import Week11Day3.Node;

public class StackInterfaceList implements iStack 
{
	public Node Header;
	public Node Tail;
	
	public StackInterfaceList() {
		this.Header = null;
		this.Tail = null;
	}
	
	//append()
	public void Append(Node node) {
		if (this.IsEmpty()) {
			this.Header = node;
			this.Tail = node;
		} else {
			this.Tail.NextNode = node;
			node.PreNode = this.Tail;
			this.Tail = node;
		}
	}
	
	//prepend()
	public void Prepend(Node node) {
		if (this.IsEmpty()) {
			this.Header = node;
			this.Tail = node;
		} else {
			node.NextNode = this.Header;
			this.Header.PreNode = node;
			this.Header = node;
		}
	}

	
	//Remove()
	public void Remove(Node node) {
		if (node == this.Header && node == this.Tail) {
		//node it both the tail and the header
			this.Header = null;
			this.Tail = null;
		} else if (node == this.Tail) {
		//node is the tail
			//.....-> 2 -> 3 -> null
			Node pre = node.PreNode;
			pre.NextNode = null;
			node.PreNode = null;
			this.Tail = pre;
		} else if (node == this.Header) {
		//node is the header
			Node next = node.NextNode;
			node.NextNode = null;
			next.PreNode = null;
			this.Header = next;
		} else {
		//all generic cases
			node.PreNode.NextNode = node.NextNode;
			node.NextNode.PreNode = node.PreNode;
			node.NextNode = null;
			node.PreNode = null;
		}
	}
	@Override
	public void Push(Node node) {
		this.Append(node);
	}

	@Override
	public Node Pop() {
		Node returnNode = this.Tail;
		this.Remove(returnNode);
		return returnNode;
	}

	@Override
	public Node Peek() {
		return this.Tail;
	}

	@Override
	public int GetLength() {
		int length = 0;
		Node node = this.Header;
		while (node != null) {
			length++;
			node = node.NextNode;
		}
		return length;
	}

	@Override
	public boolean IsEmpty() {
		return this.Header == null;
	}
	
	public void PrintStack()
	{
		Node node = this.Header;
		for (int i = 0; i < this.GetLength(); i ++)
		{
			System.out.print(node.Payload + ", ");
			node = node.NextNode;
		}
		System.out.println();
	}
	
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
	
	public void SelectionSort(boolean ascending) 
	{
		if(ascending)
		{
		    // Create tracking variable
		    Node currentNode = this.Header;
		    
		    // Outer loop to iterate over each node
		    for (int i = 0; i < this.GetLength(); i++)
		    {
		        // More tracking variables
		        Node currentSmallestNode = currentNode;
		        Node nextNode = currentNode.NextNode;
		        
		        // Find the smallest in the remaining list
		        while (nextNode != null) {
		            if (currentSmallestNode.Payload.compareTo(nextNode.Payload) > 0) 
		            {
		                currentSmallestNode = nextNode;
		            }
		            nextNode = nextNode.NextNode;
		        }
		        
		        // Swap payloads if a smaller node was found
		        if (currentSmallestNode != currentNode) 
		        {
		            String temp = currentNode.Payload;
		            currentNode.Payload = currentSmallestNode.Payload;
		            currentSmallestNode.Payload = temp;
		        }
		        
		        // Move to the next node in the outer loop
		        currentNode = currentNode.NextNode;
		    }
		}
		
		else
		{
		    // Create tracking variable
		    Node currentNode = this.Header;
		    
		    // Outer loop to iterate over each node
		    for (int i = 0; i < this.GetLength(); i++)
		    {
		        // More tracking variables
		        Node currentSmallestNode = currentNode;
		        Node nextNode = currentNode.NextNode;
		        
		        // Find the smallest in the remaining list
		        while (nextNode != null) {
		            if (currentSmallestNode.Payload.compareTo(nextNode.Payload) <= 0) 
		            {
		                currentSmallestNode = nextNode;
		            }
		            nextNode = nextNode.NextNode;
		        }
		        
		        // Swap payloads if a smaller node was found
		        if (currentSmallestNode != currentNode) 
		        {
		            String temp = currentNode.Payload;
		            currentNode.Payload = currentSmallestNode.Payload;
		            currentSmallestNode.Payload = temp;
		        }
		        
		        // Move to the next node in the outer loop
		        currentNode = currentNode.NextNode;
		    }
		}

	}
	
	public void BubbleSort(boolean ascending)
	{
		if(ascending)
		{
			//go through each time
		    for (int i = 0; i < this.GetLength(); i++) 
		    {
		    	//tracker variable
		        Node currentNode = this.Header;
		        
		        //check each set of nodes
		        for (int j = 0; j < this.GetLength(); j++) 
		        { 
		        	//if they need to be swapped
		            if (currentNode.NextNode != null && currentNode.Payload.compareTo(currentNode.NextNode.Payload) > 0) 
		            {
		            	//swap them
		                String temp = currentNode.Payload;
		                currentNode.Payload = currentNode.NextNode.Payload;
		                currentNode.NextNode.Payload = temp;
		            }
		            //move onto the next node
		            currentNode = currentNode.NextNode;
		        }
		    }
		}
		else
		{
			{
				//go through each time
			    for (int i = 0; i < this.GetLength(); i++) 
			    {
			    	//tracker variable
			        Node currentNode = this.Header;
			        
			        //check each set of nodes
			        for (int j = 0; j < this.GetLength(); j++) 
			        { 
			        	//if they need to be swapped
			            if (currentNode.NextNode != null && currentNode.Payload.compareTo(currentNode.NextNode.Payload) < 0) 
			            {
			            	//swap them
			                String temp = currentNode.Payload;
			                currentNode.Payload = currentNode.NextNode.Payload;
			                currentNode.NextNode.Payload = temp;
			            }
			            //move onto the next node
			            currentNode = currentNode.NextNode;
			        }
			    }
			}
		}

	}
	
	public boolean isExpValid(String expression)
	{
		//get rid of the spaces for consistency
		String removeSpaces = "";
		for(int i = 0; i < expression.length(); i++)
		{
			if(!expression.substring(i, i+1).equals(" "))
			{
				removeSpaces = removeSpaces + expression.substring(i, i+1);
			}
		}
		
		//make counters to ensure all () are in sets
		int OpeningCounter =0;
		int ClosingCounter =0;
		
		for (int i = 0; i < removeSpaces.length(); i++)
		{
			//keep track off all the (
			if(removeSpaces.substring(i, i+1).equals("("))
			{
				OpeningCounter++;
			}
			
			//keep track of all the )
			if(removeSpaces.substring(i, i+1).equals(")"))
			{
				ClosingCounter++;
			}
		}
		
		//if these numbers are not equal, not al () are in sets and it is not valid
		if(OpeningCounter != ClosingCounter)
		{
			System.out.println("Not Valid: not all () were closed");
			return false;
		}

		
		//make sure everything before the division sign is in ()
		String beforeDivision= "";
		int substringCounter = 0;
		//create string with everything before the division sign
		while (!removeSpaces.substring(substringCounter, substringCounter+1).equals("/") & substringCounter < removeSpaces.length())
		{
			beforeDivision = beforeDivision + removeSpaces.substring(substringCounter, substringCounter+1);
			substringCounter++;
		}

		//make string with everything that is after the division sign
		String afterDivision = removeSpaces.substring(substringCounter+1);
		
		//check for the sets of ()
		String afterDivisionFirstCharacter = afterDivision.substring(0,1);
		String afterDivisionLastCharacter = afterDivision.substring(afterDivision.length() -1);
		
		
		String beforeDivisionFirstCharacter = beforeDivision.substring(0, 1);
		String beforeDivisionLastCharacter = beforeDivision.substring(beforeDivision.length() -1);
		
		
		//if everything before the division sign is not in (), it is not valid
		if (!(beforeDivisionFirstCharacter.equals("(") && beforeDivisionLastCharacter.equals(")")))
		{
			System.out.println("Not Valid: characters before division sign must be contained in ()");
			return false;
		}
		
		//if everything after the division sign is not in (), it is not valid
		if (!(afterDivisionFirstCharacter.equals("(") && afterDivisionLastCharacter.equals(")")))
		{
			System.out.println("Not Valid: characters after division sign must be contained in ()");
			return false;
		}
		
		else
		{
			System.out.println("Valid");
			return true;
		}
	}

}
