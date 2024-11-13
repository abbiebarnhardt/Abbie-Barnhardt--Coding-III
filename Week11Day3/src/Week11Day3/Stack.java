package Week11Day3;

public abstract class Stack 
{
	public abstract void Push(Node node);
	
	public abstract Node Pop();
	
	public abstract Node Peek();
	
	public abstract int GetLength();
	
	public abstract boolean IsEmpty();
	
	public abstract void PrintStack();
	
	public abstract boolean InsertAfter(Node preNode, Node newNode);
	
	public abstract void SelectionSort(boolean asceding);
	
	public abstract void BubbleSort(boolean ascending);
	
	public abstract boolean isExpValid(String expression);
	
}
