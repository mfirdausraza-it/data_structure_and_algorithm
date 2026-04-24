package com.codecafe.aditya_verma.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Finds the next greatest element to the left for each element in an array.
 * For each element, this finds the nearest element on its left that is greater than it.
 * If no such element exists, returns -1.
 * 
 * Example: [12, 3, 6, 6, 2]
 * Output:  [-1, 12, 12, 12, 6]
 * - 12: no element to its left, so -1
 * - 3: 12 is to the left and 12 > 3, so 12
 * - 6: 12 is to the left and 12 > 6, so 12
 * - 6: 12 is to the left and 12 > 6, so 12
 * - 2: 6 is to the left and 6 > 2, so 6
 */
public class Stack02_NextGreatestLeft {

    /**
     * Finds the next greater element to the left for each element using a monotonic stack.
     * 
     * Algorithm:
     * - Use a decreasing monotonic stack to maintain potential greater elements
     * - For each element from left to right:
     *   1. Pop all smaller or equal elements from stack (they can't be the answer for current or future elements)
     *   2. If stack is not empty, top element is the next greater element to the left
     *   3. Push current element to stack
     * 
     * @param nums - input array of integers
     * @return array where each index contains the next greater element to its left (-1 if none exists)
     * 
     * Time Complexity: O(n) - each element is pushed and popped at most once
     * Space Complexity: O(n) - for the stack and result array
     */
    public static int[] nextGreaterElementToLeft(int[] nums) {
        int n = nums.length;
        // Initialize result array to store the answer for each element
        int[] result = new int[n];

        // Use a deque (double-ended queue) to implement monotonic stack
        // Stores actual values (not indices) since we don't need indices here
        Deque<Integer> stack = new ArrayDeque<>();

        // Process each element from left to right
        for (int i = 0; i < n; i++) {
            // Pop all elements from stack that are smaller or equal to current element
            // These elements cannot be the next greater element to the left
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            
            // After popping, if stack is not empty, top element is the next greater element
            // If stack is empty, no greater element exists to the left
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element to stack for consideration as next greater for future elements
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case: [12, 3, 6, 6, 2]
        // Expected output: [-1, 12, 12, 12, 6]
        int[] nums = {12, 3, 6, 6, 2};
        System.out.println(Arrays.toString(nextGreaterElementToLeft(nums)));
    }
}
