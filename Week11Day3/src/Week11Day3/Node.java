package Week11Day3;

public class Node 
{
	public String Payload;
	public Node NextNode;
	public Node PreNode;
	
	public Node(String payload)
	{
		this.Payload = payload;
		this.NextNode = null;
		this.PreNode = null;
	}
}
