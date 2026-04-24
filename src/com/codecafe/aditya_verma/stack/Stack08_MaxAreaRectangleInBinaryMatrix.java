package com.codecafe.aditya_verma.stack;

import java.util.Arrays;
import java.util.Stack;

public class Stack08_MaxAreaRectangleInBinaryMatrix {

    // Driver code to test the maximalRectangle function
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix)); // Output: 6
    }

    /**
     * Finds the maximal rectangle area in a binary matrix (contains only 0 and 1).
     * Algorithm: Uses the histogram approach where each row is treated as the base of a histogram.
     * For each row, we calculate the height of consecutive 1s above it, then find the maximum
     * area rectangle in that histogram using the Next Smaller Element approach.
     *
     * @param matrix - input binary matrix which contains only 0 and 1 as characters
     * @return maximum area of rectangle that can be formed with 1s in the matrix
     * Time Complexity: O(n * m) where n is number of rows and m is number of columns
     * Space Complexity: O(m) for the histogram array
     */
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m  =  matrix[0].length;
        // mah stores the height of histogram for each column (number of consecutive 1s above current row)
        int[] mah = new int[m];
        int maxArea = 0;
        
        // Process each row as the base of histogram
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Build histogram: increment height if current element is 1, reset to 0 if it's 0
                // This represents how many consecutive 1s are stacked vertically
                mah[j] = matrix[i][j] != '0' ? mah[j]+1 : 0;
            }
            
            // For current histogram, find the maximum area rectangle
            maxArea = Math.max(maxArea, mah(mah));
        }
        return maxArea;
    }


    /**
     * Calculates the maximum area rectangle in a histogram.
     * Uses the monotonic stack approach with Next Smaller Element.
     * For each bar, width = right_smaller - left_smaller - 1
     * Area = height * width
     *
     * @param nums - array representing heights of histogram bars
     * @return maximum area that can be formed in the histogram
     * Time Complexity: O(n) - each element is pushed and popped once
     * Space Complexity: O(n) for the stacks and result arrays
     */
    static int mah(int[] nums) {
        int n = nums.length, maxArea = 0;
        // nsr[i] = index of next smaller element to the right (or n if not found)
        int[] nsr = nsr(nums);
        // nsl[i] = index of next smaller element to the left (or -1 if not found)
        int[] nsl = nsl(nums);
        
        // Calculate area for each bar as the base
        for (int i = 0; i < n; i++) {
            // Width is the range where this bar is the minimum height
            int base = nsr[i] - nsl[i] - 1;
            // Area = width * height (height is nums[i])
            maxArea = Math.max(maxArea, base * nums[i]);
        }
        return maxArea;
    }


    /**
     * Finds the index of the next smaller element to the right for each element.
     * Uses a monotonic decreasing stack approach.
     * Processes array from right to left to find the nearest smaller element on the right side.
     *
     * @param nums - input array
     * @return array where result[i] = index of next smaller element to right (or n if none exists)
     * Time Complexity: O(n)
     * Space Complexity: O(n) for stack and result array
     */
    static int[] nsr(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop all elements from stack that are >= current element
            // (they cannot be the next smaller element)
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            
            // If stack is empty, no smaller element exists on right, use n
            // Otherwise, top of stack is the index of next smaller element
            result[i] = stack.isEmpty() ? n : stack.peek();
            // Push current index for processing elements to its left
            stack.push(i);
        }
        return result;
    }


    /**
     * Finds the index of the next smaller element to the left for each element.
     * Uses a monotonic decreasing stack approach.
     * Processes array from left to right to find the nearest smaller element on the left side.
     *
     * @param nums - input array
     * @return array where result[i] = index of next smaller element to left (or -1 if none exists)
     * Time Complexity: O(n)
     * Space Complexity: O(n) for stack and result array
     */
    static int[] nsl(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Traverse from left to right
        for (int i = 0; i < n; i++) {
            // Pop all elements from stack that are >= current element
            // (they cannot be the next smaller element)
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            
            // If stack is empty, no smaller element exists on left, use -1
            // Otherwise, top of stack is the index of next smaller element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Push current index for processing elements to its right
            stack.push(i);
        }
        return result;
    }
}
