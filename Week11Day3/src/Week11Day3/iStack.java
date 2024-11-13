package Week11Day3;

public interface iStack 
{
public void Push(Node node);
	
	public Node Pop();
	
	public Node Peek();
	
	public int GetLength();
	
	public boolean IsEmpty();
	
	public abstract void PrintStack();
	
	public abstract boolean InsertAfter(Node preNode, Node newNode);
	
	public abstract void SelectionSort(boolean ascending);
	
	public abstract void BubbleSort(boolean ascending);
	
	public abstract boolean isExpValid(String expression);
}
