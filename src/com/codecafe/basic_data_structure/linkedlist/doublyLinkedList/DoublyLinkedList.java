package com.codecafe.basic_data_structure.linkedlist.doublyLinkedList;

public class DoublyLinkedList {

     Node head;
     Node tail;
     int size;

    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    Integer getHead(){
        if(head == null) return null;
        return head.data;
    }

    Integer getTail(){
        if(tail == null) return null;
        return tail.data;
    }

    void printforward(){
        if(head == null) System.out.println("null");
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) System.out.print("<->");
        }
        System.out.println();
    }

    void printBackward() {
        if (tail == null) { System.out.println("null"); return; }
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.prev;
            if (temp != null) System.out.print("<->");
        }
        System.out.println();
    }

    void printforward(Node node){
        if(node == null) return;
        while(node!=null){
            System.out.print(node.data);
            node = node.next;
            if(node!=null) System.out.print("<->");
        }
        System.out.println();
    }

    void addFirst(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        head.prev = node;
        node.next = head;

        head = node;
        size++;
    }

    void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.prev = tail;

        tail = node;
        size++;
    }


    void reverse() {
        if (head == null || head.next == null) return;

        Node curr = head;
        Node temp = null;

        // Swap next and prev for every node
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            // move to next node (which is prev after swap)
            curr = curr.prev;
        }

        // swap head and tail
        temp = head;
        head = tail;
        tail = temp;
    }

}
