package com.codecafe.aditya_verma.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Finds the next smallest element to the left for each element in an array.
 * For each element, this finds the nearest element on its left that is smaller than it.
 * If no such element exists, returns -1.
 * 
 * Problem Statement:
 * Given an array arr[], find the next smaller element for each element in order of their 
 * appearance in the array. The next smaller element of an element is the nearest element 
 * on the left which is smaller than the current element. If there does not exist next 
 * smaller element, then the answer is -1.
 * 
 * Example: [4, 5, 2, 10, 8]
 * Output:  [-1, 4, -1, 2, 2]
 * - 4: no element to its left, so -1
 * - 5: 4 is to the left and 4 < 5, so 4
 * - 2: no element smaller than 2 to the left (4 and 5 are both > 2), so -1
 * - 10: 2 is to the left and 2 < 10, so 2
 * - 8: 2 is to the left and 2 < 8, so 2
 */
public class Stack04_NextSmallestLeft {
    
    public static void main(String[] args) {
        // Test case: [4, 5, 2, 10, 8]
        // Expected: [-1, 4, -1, 2, 2]
        int[] arr = {4,5,2,10,8};
        int[] ans = nextSmallestLeft(arr);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Finds the next smaller element to the left for each element using a monotonic stack.
     * 
     * Algorithm (Increasing Monotonic Stack):
     * - Use an increasing monotonic stack to maintain elements in ascending order
     * - Process array from left to right
     * - For each element:
     *   1. Pop all elements from stack that are >= current element
     *      (they cannot be the next smaller element to the left)
     *   2. If stack is not empty after popping, top element is the next smaller element on left
     *   3. If stack is empty, no smaller element exists to the left
     *   4. Push current element to stack for consideration by future elements
     * 
     * The key insight: We maintain a stack of elements in increasing order, so the top is always
     * the smallest element in the stack, making it the best candidate for the next smaller to left.
     * 
     * @param arr - input array of integers
     * @return array where ans[i] = next smaller element to left of arr[i] (-1 if none exists)
     * 
     * Time Complexity: O(n) - each element is pushed and popped at most once
     * Space Complexity: O(n) - for the stack and result array
     */
    static int[] nextSmallestLeft(int[] arr){
        int n = arr.length;
        
        // Initialize result array to store the next smaller element for each index
        int[] ans = new int[n];
        
        // Stack maintains elements in increasing order from bottom to top
        // Top of stack contains the smallest element candidates
        Stack<Integer> stack = new Stack<>();
        
        // Process array from left to right to find elements to the left
        for(int i=0; i<n; i++){
            // Pop all elements from stack that are >= current element
            // These elements cannot be the next smaller element to the left
            // because they are not smaller than current
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            
            // After popping, if stack is not empty, top element is the next smaller element to the left
            // If stack is empty, no smaller element exists to the left of current element
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current element to stack for consideration as next smaller by future elements
            stack.push(arr[i]);
        }
        
        return ans;
    }
}


