package Homework11;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Doubly Linked List");
		DoublyLinkedList list = new DoublyLinkedList();
		System.out.println(list.IsEmpty());
		Node seven = new Node(7);
		Node eight = new Node(8);
		list.Append(seven);
		Node one = new Node(1);
		list.Prepend(eight);
		Node two = new Node(2);
		list.Prepend(two);
		Node seven2 = new Node(7);
		list.Append(seven2);
		Node three = new Node (3);
		list.InsertAfter(eight, three);
		list.InsertAfter(seven, one);
		list.PrintList();
		list.newInsertionSort(false);

	}

}
