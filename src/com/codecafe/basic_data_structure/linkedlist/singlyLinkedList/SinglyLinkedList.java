package com.codecafe.basic_data_structure.linkedlist.singlyLinkedList;

public class SinglyLinkedList {

    Node head;

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public SinglyLinkedList(){
        head = null;
    }

    void print(){
        if(head == null){
            System.out.print("null");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data);
            temp = temp.next;
            if(temp!=null) System.out.print("->");
        }
        System.out.println();
    }


    void add(int data){
        Node node = new Node(data);

        if(head == null){
            head = node;
        }

        Node temp = head;
        while(temp.next!=null)
            temp = temp.next;

        temp.next = node;
    }

}
