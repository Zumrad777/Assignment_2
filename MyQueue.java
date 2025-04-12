package mystructures;

public class MyQueue<T> {
    // Use a MyLinkedList to implement the queue
    private MyLinkedList<T> list = new MyLinkedList<>();

    // Method to add an element to the end of the queue (enqueue operation)
    public void enqueue(T element) {
        list.add(element);  // Add the element to the end of the list (rear of the queue)
    }

    // Method to remove and return the front element from the queue (dequeue operation)
    public T dequeue() {
        if (list.isEmpty())  // Check if the queue is empty
            throw new IllegalStateException("Queue is empty");  // Throw an exception if the queue is empty
        return list.remove(0);  // Remove and return the first element in the list (front of the queue)
    }

    // Method to view the front element without removing it (peek operation)
    public T peek() {
        if (list.isEmpty())  // Check if the queue is empty
            throw new IllegalStateException("Queue is empty");  // Throw an exception if the queue is empty
        return list.get(0);  // Return the first element in the list (front of the queue)
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();  // Return whether the list (queue) is empty
    }

    // Method to get the size of the queue
    public int size() {
        return list.size();  // Return the size of the list (number of elements in the queue)
    }

    // Method to clear all elements from the queue
    public void clear() {
        list.clear();  // Clear all elements in the list (effectively clearing the queue)
    }
}
