package mystructures;

import java.util.ArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap = new ArrayList<>();

    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public T peek() {
        if (heap.isEmpty())
            throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public T poll() {
        if (heap.isEmpty())
            throw new IllegalStateException("Heap is empty");
        T result = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return result;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0)
                break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        int left, right, smallest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest == index)
                break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
