package com.codecafe.aditya_verma.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpan {

    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(result));
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : result) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {100,80,60,70,60,75,85};
//        int[] nums = {100,80,90,120};
        System.out.println(calculateSpan(nums));
    }
}
