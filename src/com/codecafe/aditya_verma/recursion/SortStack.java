package com.codecafe.aditya_verma.recursion;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(0);
        stack.add(3);
        stack.add(5);
        stack.add(4);
        stack.add(2);
        sortStack(stack);
        System.out.println(stack);
    }
    static void sortStack(Stack<Integer> stack){
        if(stack.size() == 1) return;
        int last = stack.pop();
        sortStack(stack);
        insert(stack,last);
    }

    static void insert(Stack<Integer> stack, int target){
        if(stack.isEmpty() || stack.peek()<=target){
            stack.push(target);
            return;
        }
        int last = stack.pop();
        insert(stack,target);
        stack.push(last);
    }

}
