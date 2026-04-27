package com.codecafe.aditya_verma.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Finds the maximum area of a rectangle that can be formed in a histogram.
 * 
 * Problem: Given an array representing heights of histogram bars, find the largest
 * rectangular area that can be formed. The rectangle can only use consecutive bars.
 * 
 * Example: [8, 3, 2, 2, 1]
 * The largest rectangle would be formed using bars with heights [3, 2, 2] = area of 6
 * (width 3 * height 2)
 * 
 * Algorithm: Uses monotonic stack approach with Next Smaller Element indices:
 * 1. Find the index of the nearest smaller element to the RIGHT for each bar
 * 2. Find the index of the nearest smaller element to the LEFT for each bar
 * 3. For each bar, calculate area = height * (right_smaller_index - left_smaller_index - 1)
 * 4. Return the maximum area found
 */
public class Stack07_MaxAreaOfHistogram {

    /**
     * Calculates the maximum area of a rectangle in a histogram.
     * 
     * For each bar, the width of the largest rectangle with that bar as the minimum height
     * is determined by the distances to the nearest smaller bars on both sides.
     * 
     * @param arr - array representing histogram bar heights
     * @return the maximum area of rectangle that can be formed
     * 
     * Time Complexity: O(n) - each helper method runs in O(n), called sequentially
     * Space Complexity: O(n) - for left, right arrays and stack
     */
    public static int getMaxArea(int[] arr) {
        // code here
        int n = arr.length;
        // Find index of nearest smaller element to the left for each bar
        int[] left = smallerElementToLeft(arr);
        // Find index of nearest smaller element to the right for each bar
        int[] right = smallerElementToRight(arr);
        
        // Initialize with MIN_VALUE to handle cases with negative heights (though typically non-negative)
        int maxArea = Integer.MIN_VALUE;
        
        // Calculate area for each bar as the minimum height and find maximum
        for(int i = 0; i<n; i++){
            // Width = right boundary - left boundary - 1
            // (subtract 1 because left and right are indices of smaller elements, not inclusive)
            // Area = width * height
            int area = ((right[i] - left[i]) - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
            System.out.println(maxArea);
        }
        return maxArea;
    }

    /**
     * Finds the index of the nearest smaller element to the RIGHT for each element.
     * 
     * Uses a monotonic decreasing stack, processing from right to left.
     * For each element, pops all elements >= current element (they can't be the answer).
     * The remaining top of stack (if exists) is the nearest smaller element to the right.
     * 
     * @param nums - input array of histogram heights
     * @return array where result[i] = index of nearest smaller element to right
     *         (-1 if no smaller element exists to the right)
     * 
     * Time Complexity: O(n) - each element pushed/popped once
     * Space Complexity: O(n) - for stack and result array
     */
    static int[] smallerElementToRight(int[] nums){
        int n = nums.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Process from right to left
        for(int i = n-1; i>=0; i--){
            // Pop all elements that are >= current element
            // These cannot be the nearest smaller element to the right
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            
            // After popping, if stack is empty, no smaller element exists on right
            // Otherwise, top of stack is the index of nearest smaller element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current index for processing elements to its left
            stack.push(i);
        }
        return result;
    }

    /**
     * Finds the index of the nearest smaller element to the LEFT for each element.
     * 
     * Uses a monotonic decreasing stack, processing from left to right.
     * For each element, pops all elements >= current element (they can't be the answer).
     * The remaining top of stack (if exists) is the nearest smaller element to the left.
     * 
     * @param nums - input array of histogram heights
     * @return array where result[i] = index of nearest smaller element to left
     *         (-1 if no smaller element exists to the left)
     * 
     * Time Complexity: O(n) - each element pushed/popped once
     * Space Complexity: O(n) - for stack and result array
     */
    static int[] smallerElementToLeft(int[] nums){
        int n = nums.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Process from left to right
        for(int i = 0; i<n; i++){
            // Pop all elements that are >= current element
            // These cannot be the nearest smaller element to the left
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            
            // After popping, if stack is empty, no smaller element exists on left
            // Otherwise, top of stack is the index of nearest smaller element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Push current index for processing elements to its right
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case: [8, 3, 2, 2, 1]
        // Expected: Maximum area is 6 (formed by bars with heights 3, 2, 2 with width 3)
        int[] nums = {8,3,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(smallerElementToRight(nums)));
        System.out.println(Arrays.toString(smallerElementToLeft(nums)));
        System.out.println(getMaxArea(nums));
    }
}


