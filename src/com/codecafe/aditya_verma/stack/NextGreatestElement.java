package com.codecafe.aditya_verma.stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class NextGreatestElement {
    /**
     * This a leetcode problems where you would have two arrays
     *
     * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
     * and determine the next greater element of nums2[j] in nums2.
     * If there is no next greater element, then the answer for this query is -1.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ni = nums1.length;
        int nj = nums2.length;
        int[] ans = new int[ni];
        for(int i = 0; i<ni; i++){
            int equal = -1;
            for(int j = 0; j<nj; j++){
                if(nums1[i] == nums2[j]){
                    equal = j;
                    break;
                }
            }
            if(equal == -1){
                ans[i] = -1;
            }else{
                for(int j = equal+1; j<nj; j++){
                    if(nums1[i] < nums2[j]){
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }
            if(ans[i] == 0) ans[i] = -1;
        }
        return ans;
    }

    /**
     *
     * For this you would be given an array, you have to
     * find the immediate next greater element towards right
     *
     * You are given an array arr[] of integers, the task is to find the next greater element
     * for each element of the array in order of their appearance in the array.
     * Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
     * If there does not exist next greater of current element, then next greater element for current element is -1.
     */

    public static int[] nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;

        int[] result = new int[n];
        result[n-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);

        for(int i = n-2; i>=0; i--){

            while(!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {12,3,6,6,2};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.println(Arrays.toString(nextLargerElement(nums)));
    }
}
