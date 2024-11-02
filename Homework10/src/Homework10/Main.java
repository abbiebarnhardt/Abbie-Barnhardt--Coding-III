package Homework10;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("hello, singly linked list");
		SinglyLinkedList list = new SinglyLinkedList();
		list.Append(17);
		list.Prepend(9);
		list.Append(8);;
		list.Prepend(7);
		list.Append(2);
		list.Prepend(-1);
		list.Append(5);
		list.Append(6);
		list.Sort(true);
		list.Print();
		list.BubbleSort(false);
		list.BubbleSort(true);

	}

}
