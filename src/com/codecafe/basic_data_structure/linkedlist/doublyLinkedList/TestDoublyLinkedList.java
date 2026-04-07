package com.codecafe.basic_data_structure.linkedlist.doublyLinkedList;

import com.sun.jdi.IntegerValue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(4);
        dll.add(5);
        dll.addFirst(3);

        System.out.println(dll.getHead());
        System.out.println(dll.getTail());

        dll.printforward();
        dll.reverse();
        dll.printforward();

        System.out.println(dll.getHead());
        System.out.println(dll.getTail());

        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer();
//        queue.p

        Stack<Integer> stack = new Stack<>();
//        stack.push();

    }
}
