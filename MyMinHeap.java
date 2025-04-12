
package mystructures;

import java.util.ArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap = new ArrayList<>(); // Internal storage for the heap

    public void add(T element) {
        if (element == null) throw new NullPointerException("Null values are not allowed");
        heap.add(element);               // Add element to the end
        heapifyUp(heap.size() - 1);      // Restore heap property by bubbling up
    }

    public T peek() {
        if (heap.isEmpty())
            throw new IllegalStateException("Cannot peek from an empty heap");
        return heap.get(0); // The minimum element is always at index 0
    }

    public T poll() {
        if (heap.isEmpty())
            throw new IllegalStateException("Cannot poll from an empty heap");
        T result = heap.get(0);                      // Save the min element
        T last = heap.remove(heap.size() - 1);       // Remove the last element
        if (!heap.isEmpty()) {
            heap.set(0, last);                       // Move last element to the root
            heapifyDown(0);                          // Restore heap property by bubbling down
        }
        return result;                               // Return the min element
    }

    public int size() {
        return heap.size(); // Return the number of elements in the heap
    }

    public boolean isEmpty() {
        return heap.isEmpty(); // Check if the heap is empty
    }

    public void clear() {
        heap.clear(); // Remove all elements from the heap
    }

    // Move the element at 'index' up to maintain heap order
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2; // Index of the parent node
            if (heap.get(index).compareTo(heap.get(parent)) >= 0)
                break; // Heap property is satisfied
            swap(index, parent); // Swap with parent
            index = parent;      // Move up to parent index
        }
    }

    // Move the element at 'index' down to maintain heap order
    private void heapifyDown(int index) {
        int left, right, smallest;
        while (true) {
            left = 2 * index + 1;  // Index of left child
            right = 2 * index + 2; // Index of right child
            smallest = index;     // Start by assuming current is smallest

            // Check if left child is smaller
            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;

            // Check if right child is smaller
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest == index)
                break; // Heap property is satisfied

            swap(index, smallest); // Swap with the smaller child
            index = smallest;      // Move down to new position
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
