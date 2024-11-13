package Week11Day3;

public class Main {

	public static void main(String[] args) 
	{
		Stack stack = new IntListStack();
		stack.Peek();
		stack.Pop();
		stack.Push(new Node("f"));
		stack.Push(new Node("b"));
		stack.Push(new Node("d"));
		stack.Push(new Node("a"));
		Node node = new Node("e");
		Node node2 = new Node("c");
		stack.Push(node);
		stack.InsertAfter(node, node2);
		System.out.println("Original Stack");
		stack.PrintStack();
		stack.BubbleSort(false);
		System.out.println("Stack in Descending Order Using Bubble Sort");
		stack.PrintStack();
		stack.SelectionSort(true);
		System.out.println("Stack in Ascending Order Using Selection Sort");
		stack.PrintStack();
		System.out.println();
	
		stack.isExpValid("(1 + 2 * (3 -1) ) / (1 + 1)");
		stack.isExpValid("1 + 2 * (3 -1) / (1 + 1)");
		System.out.println();
		
		iStack stack1 = new StackInterfaceList();
		stack1.Peek();
		stack1.Pop();
		stack1.Push(new Node("g"));
		stack1.Push(new Node("z"));
		stack1.Push(new Node("a"));
		stack1.Push(new Node("c"));
		Node node3 = new Node("y");
		Node node4 = new Node("z");
		stack1.Push(node3);
		stack1.InsertAfter(node3, node4);
		System.out.println("Original Stack");
		stack1.PrintStack();
		stack1.BubbleSort(false);
		System.out.println("Stack in Descending Order Using Bubble Sort");
		stack1.PrintStack();
		stack1.SelectionSort(true);
		System.out.println("Stack in Ascending Order Using Selection Sort");
		stack1.PrintStack();
		System.out.println();
		
		stack1.isExpValid("(1 + 2 * (3 -1) ) / (1 + 1)");
		stack1.isExpValid("1 + 2 * (3 -1) / (1 + 1)");
		

	}

}
