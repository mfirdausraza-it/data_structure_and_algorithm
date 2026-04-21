package com.codecafe.aditya_verma.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NextGreatestElementToLeft {


    public static int[] nextGreaterElementToLeft(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {12, 3, 6, 6, 2};
        System.out.println(Arrays.toString(nextGreaterElementToLeft(nums)));
    }
}
