package com.codecafe.aditya_verma.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaOfHistogram {

    public static int getMaxArea(int[] arr) {
        // code here
        int n = arr.length;
        int[] left = smallerElementToLeft(arr);
        int[] right = smallerElementToRight(arr);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int area = ((right[i] - left[i]) -1) * arr[i];
            maxArea = Math.max(maxArea,area);
            System.out.println(maxArea);
        }
        return maxArea;
    }

    static int[] smallerElementToRight(int[] nums){
        int n = nums.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }

    static int[] smallerElementToLeft(int[] nums){
        int n = nums.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++){
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8,3,2,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(smallerElementToRight(nums)));
        System.out.println(Arrays.toString(smallerElementToLeft(nums)));
        System.out.println(getMaxArea(nums));
    }
}
