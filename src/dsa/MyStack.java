package dsa;

public class MyStack {
    // Node inner class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top; // đỉnh stack
    private int size;

    public MyStack() {
        top = null;
        size = 0;
    }

    // Push - thêm phần tử lên đỉnh (O(1))
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop - lấy phần tử khỏi đỉnh (O(1))
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Peek - xem phần tử đỉnh (O(1))
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    // isEmpty - kiểm tra rỗng (O(1))
    public boolean isEmpty() {
        return top == null;
    }

    // Size - số phần tử
    public int size() {
        return size;
    }

    // Display - in stack từ đỉnh xuống đáy (O(n))
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node current = top;
        System.out.print("Top -> ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("(bottom)");
    }

    // Main để test
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println("=== Stack Operations (LIFO) ===\n");

        System.out.println("1. Push 10, 20, 30:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Size: " + stack.size() + "\n");

        System.out.println("2. Peek top element: " + stack.peek() + "\n");

        System.out.println("3. Pop element: " + stack.pop());
        stack.display();
        System.out.println("Size: " + stack.size() + "\n");

        System.out.println("4. Pop remaining elements:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\n");

        System.out.println("5. Try pop on empty stack (will throw exception):");
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}