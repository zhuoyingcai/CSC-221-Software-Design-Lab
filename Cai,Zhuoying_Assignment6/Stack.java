import java.util.EmptyStackException;

public class Stack<T>
{
    private Node<T> first;

    /**
     * The Node class is used in stack.
     * A node has capability to store data and points to the address of next node.
     */
    private class Node<T>
    {
        private T item;
        private Node<T> next;
    }

    /**
     * Class constructor that initialized null to the first node.
     */
    public Stack()
    {
        first = null;
    }

    /**
     * This method check if the stack is empty.
     * @return boolean This returns true if the first node in the stack is null or
     *                  returns false if the first node is not null.
     */
    public boolean empty()
    {
        return first == null;
    }

    /**
     * This method is used to push/insert one item on the top of the stack.
     * @param item This is the item to push into the stack.
     */
    public void push(T item)
    {
        Node<T> previousNode = first;
        first = new Node<>();
        first.item = item;
        first.next = previousNode;
    }

    /**
     * This method is used to pop/delete one item on the top of the stack.
     * @return user defined type This returns the item on the top of the stack.
     */
    public T pop()
    {
        if (empty())
            throw new EmptyStackException();

        T item = first.item;
        first = first.next;

        return item;
    }

    /**
     * This method is used to check the item on the top of the stack without popping it.
     * @return user define type This returns the value of the item on the top of the stack.
     */
    public T peek()
    {
        if (empty())
            throw new EmptyStackException();

        return first.item;
    }
}
