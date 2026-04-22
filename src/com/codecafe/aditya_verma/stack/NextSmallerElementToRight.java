package com.codecafe.aditya_verma.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToRight {

    /**
     * Input: arr[] = [4, 8, 5, 2, 25]
     * Output: [2, 5, 2, -1, -1]
     */

    static int[] nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerEle(nums)));
    }
}
