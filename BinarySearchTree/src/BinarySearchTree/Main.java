package BinarySearchTree;

public class Main 
{

	public static void main(String[] args) 
	{
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("Original Tree:");
		/*tree.insert(100, "100");
		tree.insert(150, "150");
		tree.insert(50, "50");
		tree.insert(25, "25");
		tree.insert(75, "75");
		tree.insert(125, "125");
		tree.insert(175, "175");*/
		tree.insertRandomNumbers(0, 9);
		System.out.println("Here");
		tree.PrintTree();
		
		int num = BinarySearchTree.randomNumber(0, 9);
		tree.delete(num);
		System.out.print("Delete " + num + ", ");
		num = BinarySearchTree.randomNumber(0, 9);
		tree.delete(num);
		System.out.print(num + ", ");
		num = BinarySearchTree.randomNumber(0, 9);
		tree.delete(num);
		System.out.println(num);
		tree.PrintTree();
		
		System.out.println("Search for 3 Random Numbers");
		num = BinarySearchTree.randomNumber(0, 9);
		System.out.print("Searching for " + num + ": ");
		tree.search(num);
		num = BinarySearchTree.randomNumber(0, 9);
		System.out.print("Searching for " + num + ": ");
		tree.search(num);
		num = BinarySearchTree.randomNumber(0, 9);
		System.out.print("Searching for " + num + ": ");
		tree.search(num);
		

	}

}
