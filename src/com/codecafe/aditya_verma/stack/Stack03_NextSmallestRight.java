package com.codecafe.aditya_verma.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Finds the next smaller element to the right for each element in an array.
 * For each element, this finds the nearest element on its right that is smaller than it.
 * If no such element exists, returns -1.
 * 
 * Problem Statement:
 * Given an array arr[], find the next smaller element for each element in order of their 
 * appearance in the array. The next smaller element of an element is the nearest element 
 * on the right which is smaller than the current element. If there does not exist next 
 * smaller element, then the answer is -1.
 * 
 * Example: [4, 8, 5, 2, 25]
 * Output:  [2, 5, 2, -1, -1]
 * - 4: next element is 8 (not smaller), then 5 (not smaller), then 2 (smaller), so 2
 * - 8: next element is 5 (smaller), so 5
 * - 5: next element is 2 (smaller), so 2
 * - 2: no element smaller than 2 to the right, so -1
 * - 25: no element smaller than 25 to the right (array ends), so -1
 */
public class Stack03_NextSmallestRight {

    /**
     * Finds the next smaller element to the right for each element using a monotonic stack.
     * 
     * Algorithm (Increasing Monotonic Stack):
     * - Use an increasing monotonic stack to maintain potential smaller elements
     * - Process array from right to left (to find elements to the right)
     * - For each element from right to left:
     *   1. Pop all elements from stack that are >= current element
     *      (they cannot be the next smaller element)
     *   2. If stack is not empty after popping, top element is the next smaller element
     *   3. If stack is empty, no smaller element exists to the right
     *   4. Push current element to stack for consideration by elements to its left
     * 
     * @param arr - input array of integers
     * @return array where result[i] = next smaller element to right of arr[i] (-1 if none exists)
     * 
     * Time Complexity: O(n) - each element is pushed and popped at most once
     * Space Complexity: O(n) - for the stack and result array
     */
    static int[] nextSmallerEle(int[] arr) {
        // code here
        int n = arr.length;

        // Initialize result array to store the next smaller element for each index
        int[] result = new int[n];
        
        // Stack maintains elements in increasing order from bottom to top
        // Stores actual values (not indices) since we don't need indices for this problem
        Stack<Integer> stack = new Stack<>();
        
        // Process array from right to left to find elements to the right
        for(int i = n-1; i>=0; i--){
            // Pop all elements from stack that are >= current element
            // These elements cannot be the next smaller element to current element
            // because they are not smaller than current
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            
            // After popping, if stack is not empty, top element is the next smaller element
            // If stack is empty, no smaller element exists to the right of current element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element to stack for potential use as next smaller for elements to its left
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case: [4, 8, 5, 2, 25]
        // Expected output: [2, 5, 2, -1, -1]
        // - 4 → 2 (nearest smaller to right)
        // - 8 → 5 (nearest smaller to right)
        // - 5 → 2 (nearest smaller to right)
        // - 2 → -1 (no smaller element to right)
        // - 25 → -1 (no smaller element to right)
        int[] nums = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerEle(nums)));
    }
}
