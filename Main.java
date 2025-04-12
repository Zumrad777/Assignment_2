import mystructures.*;

public class Main {
    public static void main(String[] args) {
        // MyArrayList
        System.out.println("===== MyArrayList =====");
        MyList<String> arrayList = new MyArrayList<>();
        arrayList.add("Toy");
        arrayList.add("Car");
        arrayList.add("Book");
        System.out.println("Element at 1: " + arrayList.get(1));
        arrayList.set(1, "Ball");
        System.out.println("Updated element at 1: " + arrayList.get(1));
        arrayList.remove(0);
        System.out.println("Element at 0 after removal: " + arrayList.get(0));
        // MyLinkedList
        System.out.println("\n===== MyLinkedList =====");
        MyList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("Element at index 2: " + linkedList.get(2));
        linkedList.remove(1);
        System.out.println("Element at index 1 after removal: " + linkedList.get(1));

        //  MyStack
        System.out.println("\n===== MyStack =====");
        MyStack<String> stack = new MyStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Popped from stack: " + stack.pop());
        System.out.println("New top: " + stack.peek());

        //  MyQueue
        System.out.println("\n===== MyQueue =====");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front of queue: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("New front: " + queue.peek());

        //  MyMinHeap
        System.out.println("\n===== MyMinHeap =====");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(50);
        heap.add(30);
        heap.add(20);
        heap.add(40);
        System.out.println("Min element: " + heap.peek());
        System.out.println("Removed min: " + heap.poll());
        System.out.println("New min: " + heap.peek());
    }
}
