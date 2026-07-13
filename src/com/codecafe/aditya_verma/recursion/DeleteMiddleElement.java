package com.codecafe.aditya_verma.recursion;

import java.util.Stack;

public class DeleteMiddleElement {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(0);
        stack.add(3);
        stack.add(5);
        stack.add(4);
        stack.add(2);
        System.out.println(stack);
        deleteMiddle(stack);
        System.out.println(stack);
    }

    //k = size/2+1
    //old = [1,2,3,4,5] -- remove 3
    //even = [1,2,3,4,5,6] -- remove 4

    static void deleteMiddle(Stack<Integer> stack){
        int n = stack.size();
        int k = n/2;
        delete(stack,k);
    }

    static void delete(Stack<Integer> stack, int k){
        if(k == 1){
            stack.pop();
            return;
        }

        int temp = stack.pop();
        k--;
        delete(stack,k);
        stack.push(temp);
    }
}
