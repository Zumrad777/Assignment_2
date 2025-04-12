package mystructures;

public class MyStack<T> {
    // Use a MyLinkedList to implement the stack
    private MyLinkedList<T> list = new MyLinkedList<>();

    // Method to add an element to the top of the stack (push operation)
    public void push(T element) {
        list.add(element);  // Add the element to the end of the list (top of the stack)
    }

    // Method to remove and return the top element from the stack (pop operation)
    public T pop() {
        if (list.isEmpty())  // Check if the stack is empty
            throw new IllegalStateException("Stack is empty");  // Throw an exception if the stack is empty
        return list.remove(list.size() - 1);  // Remove and return the last element in the list (top of the stack)
    }

    // Method to view the top element without removing it (peek operation)
    public T peek() {
        if (list.isEmpty())  // Check if the stack is empty
            throw new IllegalStateException("Stack is empty");  // Throw an exception if the stack is empty
        return list.get(list.size() - 1);  // Return the last element in the list (top of the stack)
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();  // Return whether the list (stack) is empty
    }

    // Method to get the size of the stack
    public int size() {
        return list.size();  // Return the size of the list (number of elements in the stack)
    }

    // Method to clear all elements from the stack
    public void clear() {
        list.clear();  // Clear all elements in the list (effectively clearing the stack)
    }
}
