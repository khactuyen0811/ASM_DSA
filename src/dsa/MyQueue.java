package dsa;

public class MyQueue {
    // Node inner class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front; // đầu queue (nơi dequeue)
    private Node rear;  // cuối queue (nơi enqueue)
    private int size;

    public MyQueue() {
        front = rear = null;
        size = 0;
    }

    // Enqueue - thêm vào cuối (O(1))
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue - lấy từ đầu (O(1))
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Front - xem phần tử đầu (O(1))
    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    // isEmpty - kiểm tra rỗng (O(1))
    public boolean isEmpty() {
        return front == null;
    }

    // Size - số phần tử
    public int size() {
        return size;
    }

    // Display - in queue từ front đến rear (O(n))
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        System.out.print("Front -> ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("<- Rear");
    }

    // Main để test
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        System.out.println("=== Queue Operations (FIFO) ===\n");

        System.out.println("1. Enqueue 10, 20, 30:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        System.out.println("Size: " + queue.size() + "\n");

        System.out.println("2. Front element: " + queue.front() + "\n");

        System.out.println("3. Dequeue element: " + queue.dequeue());
        queue.display();
        System.out.println("Size: " + queue.size() + "\n");

        System.out.println("4. Dequeue remaining elements:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\n");

        System.out.println("5. Try dequeue on empty queue (will throw exception):");
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
