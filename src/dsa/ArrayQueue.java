package dsa;

class ArrayQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public ArrayQueue(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x) {
        if (size == capacity) throw new RuntimeException("Queue full");
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int dequeue() {
        if (size == 0) throw new RuntimeException("Queue empty");
        int x = arr[front];
        front = (front + 1) % capacity;
        size--;
        return x;
    }

    public int front() {
        if (size == 0) throw new RuntimeException("Queue empty");
        return arr[front];
    }

    public boolean isEmpty() { return size == 0; }
}