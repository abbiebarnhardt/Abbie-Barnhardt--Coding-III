package BinarySearchTree;

import java.util.Random;

public class BinarySearchTree 
{
    private Node root;

    //constructor, first node inserted will become root
    public BinarySearchTree() {
        root = null;
    }

    // insert a new node
    public void insert(int key, String value) 
    {
    	//create a new node
        Node newNode = new Node();
        newNode.Key = key;
        newNode.Value = value;

        //if there is no root yet, make the new node the root
        if (root == null) 
        {
            root = newNode;
            return;
        }

        //start at the root and traverse until you find the right place to insert
        Node current = root;
        while (current != null) 
        {
        	//if the new node is less that the current node, go to the left child
            if (key < current.Key) 
            {
            	//if the left child doesn't exist, make the new node the left child
                if (current.LeftChild == null) 
                {
                    current.LeftChild = newNode;
                    return;
                }
                
                //set the current node as the left child to keep moving
                current = current.LeftChild;
            } 
            //if the new node is greater than or equal to the current node, go to the right child
            else
            {
            	//if the right child doesn't exist, make the new node the right child
                if (current.RightChild == null) 
                {
                    current.RightChild = newNode;
                    return;
                }
                //set the current node as the right child to keep moving
                current = current.RightChild;
            } 
        }
    }
    
    public void delete(int key) 
    {
        //create tracker variables, start with the root
        Node current = root;
        Node parent = null;

        //find the requested node, can't use the search method because we also need the node's parent
        while (current != null && current.Key != key) 
        {
            parent = current;
            if (key < current.Key) 
            {
                current = current.LeftChild;
            } 
            else 
            {
                current = current.RightChild;
            }
        }

        // if the node wasn't found, stop
        if (current == null) 
        {
            System.out.println("Node not found");
            return;
        }

        //if the node has no children
        if (current.LeftChild == null && current.RightChild == null) 
        {
        	//if the node is the root, make it null
            if (current == root) 
            {
                root = null;
            } 
            //if the node is a child, make it null, but you have to go through the parent
            else if (parent.LeftChild == current) 
            {
                parent.LeftChild = null;
            } 
            else 
            {
                parent.RightChild = null;
            }
        }

        //if the node has one child
        else if (current.LeftChild == null) 
        {
        	//if the node to delete is the root, make the right child the new root
            if (current == root) 
            {
                root = current.RightChild;
            } 
            //reassign the child nodes
            else if (parent.LeftChild == current) 
            {
                parent.LeftChild = current.RightChild;
            } 
            else 
            {
                parent.RightChild = current.RightChild;
            }
        } 
        //same as above
        else if (current.RightChild == null) 
        {
            if (current == root) 
            {
                root = current.LeftChild;
            } 
            else if (parent.LeftChild == current) 
            {
                parent.LeftChild = current.LeftChild;
            } 
            else 
            {
                parent.RightChild = current.LeftChild;
            }
        }

        //node has two children
        else 
        {
            //find the successor
            Node successor = current.RightChild;
            Node successorParent = current;

            //find the leftmost child of the right subtree
            while (successor.LeftChild != null) 
            {
                successorParent = successor;
                successor = successor.LeftChild;
            }

            //replace current with the in-order successor
            current.Key = successor.Key;
            current.Value = successor.Value;

            //delete the successor
            if (successorParent.LeftChild == successor) 
            {
                successorParent.LeftChild = successor.RightChild;
            } 
            else 
            {
                successorParent.RightChild = successor.RightChild;
            }
        }
    }

    
    

    //search for a node
    public Node search(int key) 
    {
    	//start at the root, and move until there are no more nodes to logically guess
        Node current = root;
        while (current != null) 
        {
        	//if they match, return the value
            if (key == current.Key) 
            {
            	System.out.println(key);
                return current;
            } 
            //if the node you are searching for is less than the current node, move to the left child
            else if (key < current.Key) 
            {
                current = current.LeftChild;
            } 
            //if the node you are searching for is greater than the current node, move to the right child
            else 
            {
                current = current.RightChild;
            }
        }
        System.out.println("Node Not Found");
        return null;
    }

    //print the tree
    public void PrintTree() 
    {
        String leftKey;
        String rightKey;
    	//if the tree is empty, print that
        if (root == null) 
        {
            System.out.println("Tree is empty");
            return;
        }
        
        //print the root and its children
        else 
        {
        	if(root.LeftChild != null)
            {
            	leftKey = String.valueOf(root.LeftChild.Key);
            }
            else 
            {
            	leftKey = "None";
            }
            
            if(root.RightChild != null)
            {
            	rightKey = String.valueOf(root.RightChild.Key);
            }
            else 
            {
            	rightKey = "None";
            }
        	System.out.println("Root: " + root.Value + ", Left Child: " + leftKey + ", Right Child: " + rightKey);
        }

        //Make a stack for traversel and add the left and right child nodes of the root
        Stack stack = new Stack();
        if (root.LeftChild != null) 
        {
            stack.Push(root.LeftChild);
        }
        if (root.RightChild != null) 
        {
            stack.Push(root.RightChild);
        }

        //while there are still items to print
        while (!stack.IsEmpty())
        {
        	//current node = the head of the stack
            Node currentNode = stack.Pop();


            //get the values of the current node's left and right children
            if(currentNode.LeftChild != null)
            {
            	leftKey = String.valueOf(currentNode.LeftChild.Key);
            }
            else 
            {
            	leftKey = "None";
            }
            
            if(currentNode.RightChild != null)
            {
            	rightKey = String.valueOf(currentNode.RightChild.Key);
            }
            else 
            {
            	rightKey = "None";
            }

            // print the current node and its children
            System.out.println("Parent: " + currentNode.Key + ", Left Child: " + leftKey + ", Right Child: " + rightKey);

            // add the right and left children to the stack
            if (currentNode.RightChild != null) {
                stack.Push(currentNode.RightChild);
            }
            if (currentNode.LeftChild != null) {
                stack.Push(currentNode.LeftChild);
            }
        }
        System.out.println();
    }

    //method to fill the tree with random numbers
    public void insertRandomNumbers(int min, int max)
    {
    	int[] numbers = new int[max-min +1];
    	for(int i =0; i<= max-min; i++)
    	{
    		numbers[i] = i+ min;
    	}
    	
        Random rand = new Random();
        for (int i = numbers.length - 1; i > 0; i--) 
        {
            // Generate a random index from 0 to i
            int j = rand.nextInt(i + 1);
            
            // Swap elements at i and j
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        
        for(int i = 0; i < numbers.length; i++)
        {
        	this.insert(numbers[i], Integer.toString(numbers[i]));
        }
    }
    
    public static int randomNumber(int min, int max)
    {
    	Random random = new Random();
        return random.nextInt(max+1) + min;
    }
}
