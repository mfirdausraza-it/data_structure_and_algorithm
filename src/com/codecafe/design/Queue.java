package com.codecafe.design;

public class Queue<T> {

    // Head → front of queue (for removal)
    // Tail → end of queue (for insertion)
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Generic Node class
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // ✅ Add element at the end (O(1))
    public boolean offer(T data) {
        Node<T> node = new Node<>(data);

        // If queue is empty
        if (head == null) {
            head = tail = node; // both point to same node
        } else {
            tail.next = node;  // attach at end
            tail = node;       // move tail
        }

        size++;
        return true;
    }

    // ✅ Remove element from front (O(1))
    public T pop() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }

        Node<T> temp = head;
        head = head.next;

        // If queue becomes empty after removal
        if (head == null) {
            tail = null;
        }

        temp.next = null; // help GC
        size--;

        return temp.data;
    }

    // Return current size
    public int getSize() {
        return size;
    }

    // Peek front element
    public T peek() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.offer("My");
        queue.offer("name");
        queue.offer("is");
        queue.offer("Don");

        // Print and remove elements
        while (queue.getSize() > 0) {
            System.out.print(queue.pop() + " ");
        }
    }
}