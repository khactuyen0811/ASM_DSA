package dsa;

class LinkedQueue {
    private class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node front, rear;
    private int size;

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) front = rear = newNode;
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        int x = front.data;
        front = front.next;
        size--;
        if (front == null) rear = null;
        return x;
    }

    public int front() {
        if (isEmpty()) throw new RuntimeException("Queue empty");
        return front.data;
    }

    public boolean isEmpty() { return front == null; }
    public int size() { return size; }
}