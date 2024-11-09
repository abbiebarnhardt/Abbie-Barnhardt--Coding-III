package Homework11;

public class Node <T>
{
	//Node variables
	public T Payload;
	public Node<T> PreNode;
	public Node<T> NextNode;
	
	//Node constructor
	public Node(T payload)
	{
		this.PreNode = null;
		this.NextNode = null;
		this.Payload = payload;
	}
	
	//Create a copy of a node
	public Node<T> clone()
	{
		Node newNode = new Node(this.Payload);
		newNode.Payload = this.Payload;
		return newNode;
	}
	
	//if this is equal to another, return 0
	//if this is larger than another, return 1(positive)
	//if this is smaller, return -1(negative)
	public int compareTo(Node another) 
	{
		if (this.Payload instanceof Integer) 
		{
			if ((int)this.Payload > (int)another.Payload) 
			{
				return 1;
			} 
			else if ((int)this.Payload < (int)another.Payload) 
			{
				return -1;
			} 
			else 
			{
				return 0;
			}
		} 
		else if (this.Payload instanceof String) 
		{
			return ((String)this.Payload).compareTo((String)another.Payload);
		} 
		else 
		{
			return 0;
		}
	}
}
