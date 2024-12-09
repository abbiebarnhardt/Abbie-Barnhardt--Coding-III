package BinarySearchTree;

public class Stack {
    private Object[] stackArray;
    private int top;

    public Stack() {
        stackArray = new Object[100];  // Use Object[] to bypass Node-specific typing
        top = -1;
    }

    public void Push(Object node) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = node;
        }
    }

    public Node Pop() {
        if (top >= 0) {
            return (Node) stackArray[top--];  // Manual cast
        }
        return null;
    }

    public boolean IsEmpty() {
        return top == -1;
    }
}
