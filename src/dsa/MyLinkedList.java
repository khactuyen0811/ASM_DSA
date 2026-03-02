package dsa;

public class MyLinkedList {
    // Node inner class
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // First node
    private int size;  // Number of nodes

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    // 1. Append (thêm vào cuối) - O(n)
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // 2. Prepend (thêm vào đầu) - O(1)
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 3. Delete by value (xoá theo giá trị) - O(n)
    public boolean deleteByValue(int value) {
        if (head == null) return false;

        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    // 4. Traverse (in danh sách) - O(n)
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 5. Search (tìm kiếm) - O(n)
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Main để test (chạy thử để chụp ảnh console)
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println("=== Linked List Operations ===\n");

        System.out.println("1. Appending 10, 20, 30:");
        list.append(10);
        list.append(20);
        list.append(30);
        list.traverse();
        System.out.println("Size: " + list.getSize() + "\n");

        System.out.println("2. Prepending 5:");
        list.prepend(5);
        list.traverse();
        System.out.println("Size: " + list.getSize() + "\n");

        System.out.println("3. Search for 20: " + list.search(20));
        System.out.println("Search for 99: " + list.search(99) + "\n");

        System.out.println("4. Delete 20:");
        list.deleteByValue(20);
        list.traverse();
        System.out.println("Size: " + list.getSize() + "\n");

        System.out.println("5. Delete 100 (not exist): " + list.deleteByValue(100));
        list.traverse();
    }
}