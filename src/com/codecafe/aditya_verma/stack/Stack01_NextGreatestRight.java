package com.codecafe.aditya_verma.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Finds the next greater element to the right for each element in an array.
 * This class provides two implementations:
 * 1. LeetCode variant: Given two arrays (nums1, nums2), find next greater element in nums2 for each element of nums1
 * 2. Simple variant: Given a single array, find next greater element to the right for each element
 */
public class Stack01_NextGreatestRight {

    /**
     * LeetCode Problem: Next Greater Element I
     *
     * Given two arrays nums1 and nums2:
     * - nums1 is a subset of nums2 (all elements of nums1 are in nums2)
     * - For each element in nums1, find the next greater element in nums2
     * - The "next greater" means: after the position where the element is found in nums2,
     *   find the first element that is strictly greater than it
     *
     * Algorithm (Brute Force):
     * 1. For each element in nums1, find its position in nums2
     * 2. Search from that position to the right to find the first greater element
     * 3. If not found, return -1
     *
     * Example: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * - 4: Position 2 in nums2, no element > 4 to the right, result = -1
     * - 1: Position 0 in nums2, first element > 1 is 3, result = 3
     * - 2: Position 3 in nums2, no element > 2 to the right, result = -1
     * Output: [-1, 3, -1]
     *
     * @param nums1 - array to find answers for (subset of nums2)
     * @param nums2 - array where we search for the next greater element
     * @return array of same length as nums1 with next greater elements (-1 if not found)
     *
     * Time Complexity: O(n*m) - for each element in nums1, we search in nums2
     * Space Complexity: O(n) - for the result array
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ni = nums1.length;
        int nj = nums2.length;
        int[] ans = new int[ni];

        // For each element in nums1
        for (int i = 0; i < ni; i++) {
            // Step 1: Find the position of nums1[i] in nums2
            int equal = -1;
            for (int j = 0; j < nj; j++) {
                if (nums1[i] == nums2[j]) {
                    equal = j;
                    break;
                }
            }

            // If element not found in nums2 (shouldn't happen as nums1 is subset of nums2)
            if (equal == -1) {
                ans[i] = -1;
            } else {
                // Step 2: Search from position equal+1 to find the first greater element
                for (int j = equal + 1; j < nj; j++) {
                    if (nums1[i] < nums2[j]) {
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }

            // Handle the case where result remains 0 (which should be -1)
            if (ans[i] == 0) ans[i] = -1;
        }
        return ans;
    }

    /**
     * Finds the next greater element to the right for each element in a single array.
     * For each element, returns the nearest element on its right that is strictly greater than it.
     * If no such element exists, returns -1.
     *
     * Algorithm (Monotonic Stack - Optimal):
     * - Use a decreasing monotonic stack to efficiently find the next greater element
     * - Process array from right to left
     * - For each element:
     *   1. Pop all elements from stack that are <= current element
     *      (they cannot be the next greater element)
     *   2. If stack is not empty, top element is the next greater element to the right
     *   3. If stack is empty, no greater element exists to the right
     *   4. Push current element to stack
     *
     * Example: [12, 3, 6, 6, 2]
     * Output:  [-1, 6, -1, -1, 6]
     * - 12: no element > 12 to right, so -1
     * - 3: 6 is to right and 6 > 3, so 6
     * - 6 (index 2): no element > 6 to right, so -1
     * - 6 (index 3): next element is 2 which is < 6, so -1
     * - 2: 6 is to right and 6 > 2, so 6
     *
     * @param arr - input array of integers
     * @return array where result[i] = next greater element to right of arr[i] (-1 if none exists)
     *
     * Time Complexity: O(n) - each element is pushed and popped at most once
     * Space Complexity: O(n) - for the stack and result array
     */
    public static int[] nextLargerElementToRight(int[] arr) {
        // code here
        int n = arr.length;

        // Initialize result array to store answers
        int[] result = new int[n];

        // Stack stores array elements (in decreasing order from bottom to top)
        Stack<Integer> stack = new Stack<>();

        // Process array from right to left to find elements to the right
        for (int i = n - 1; i >= 0; i--) {
            // Pop all elements from stack that are smaller or equal to current element
            // These elements cannot be the next greater element to current element
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();

            // After popping, if stack is empty, no greater element exists to the right
            // Otherwise, top of stack is the next greater element to the right
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack for consideration by elements to its left
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case for nextLargerElementToRight
        // Input: [12, 3, 6, 6, 2]
        // Expected: [-1, 6, -1, -1, 6]
        int[] nums = {12, 3, 6, 6, 2};
        System.out.println(Arrays.toString(nextLargerElementToRight(nums)));
    }
}


