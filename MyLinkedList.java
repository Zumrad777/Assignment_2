package mystructures;

public class MyLinkedList<T> implements MyList<T> {
    // Node class to store each element and its reference to the next node
    private class Node {
        T data;  // Data of the node
        Node next;  // Reference to the next node in the list

        Node(T data) { this.data = data; }  // Constructor to initialize node with data
    }

    private Node head;  // Reference to the first node in the list
    private int size;  // Size of the linked list

    // Method to add an element to the end of the list
    public void add(T element) {
        Node newNode = new Node(element);  // Create a new node with the given data
        if (head == null)  // If the list is empty, make the new node the head
            head = newNode;
        else {  // Otherwise, traverse to the end of the list and add the new node
            Node current = head;
            while (current.next != null)  // Traverse to the last node
                current = current.next;
            current.next = newNode;  // Add the new node at the end
        }
        size++;  // Increment the size of the list
    }

    // Method to get the element at a specific index
    public T get(int index) {
        checkIndex(index);  // Ensure the index is valid
        Node current = getNode(index);  // Get the node at the specified index
        return current.data;  // Return the data stored in the node
    }

    // Method to set a new value at a specific index
    public void set(int index, T element) {
        checkIndex(index);  // Ensure the index is valid
        getNode(index).data = element;  // Set the new data at the specified index
    }

    // Method to remove an element at a specific index
    public T remove(int index) {
        checkIndex(index);  // Ensure the index is valid
        Node removed;  // Node to store the removed element
        if (index == 0) {  // If removing the first element
            removed = head;  // Store the head node
            head = head.next;  // Make the next node the new head
        } else {  // If removing an element other than the first
            Node prev = getNode(index - 1);  // Get the node just before the one to remove
            removed = prev.next;  // Store the node to remove
            prev.next = removed.next;  // Skip the removed node
        }
        size--;  // Decrement the size of the list
        return removed.data;  // Return the data of the removed node
    }

    // Method to get the size of the list
    public int size() {
        return size;  // Return the current size of the list
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;  // The list is empty if size is 0
    }

    // Method to clear the entire list
    public void clear() {
        head = null;  // Set the head to null, removing all references to nodes
        size = 0;  // Reset the size to 0
    }

    // Helper method to get the node at a specific index
    private Node getNode(int index) {
        Node current = head;  // Start from the head of the list
        for (int i = 0; i < index; i++)  // Traverse the list until the specified index
            current = current.next;
        return current;  // Return the node at the specified index
    }

    // Helper method to check if an index is within valid bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size)  // If index is out of bounds
            throw new IndexOutOfBoundsException("Index: " + index);  // Throw an exception
    }
}
