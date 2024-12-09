package BinarySearchTree;

public class Node 
{
    public Node LeftChild;   // Left child
    public Node RightChild;  // Right child
    public int Key;
    public String Value;

    // Constructor to initialize the node
    public Node() 
    {
        this.LeftChild = null;
        this.RightChild = null;
        this.Key = 0;
        this.Value = "";
    }
}