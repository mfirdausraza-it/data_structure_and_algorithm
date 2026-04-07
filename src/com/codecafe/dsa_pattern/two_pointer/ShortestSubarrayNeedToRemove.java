package com.codecafe.dsa_pattern.two_pointer;

import java.util.Stack;

public class ShortestSubarrayNeedToRemove {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int prefix = 0, suffix = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) prefix++;
            else break;
        }
        if (prefix == n - 1) return 0;

        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] <= arr[i]) suffix--;
            else break;
        }
        int i = 0, j = suffix;
        int minRemove = Math.min(n - prefix - 1, suffix);
        while (i <= prefix && j < n) {
            if (arr[i] <= arr[j]) {
                minRemove = Math.min(minRemove, j - i - 1);
                i++;
            } else j++;
        }
        return minRemove;
    }

    public static void main(String[] args) {
        ShortestSubarrayNeedToRemove obj = new ShortestSubarrayNeedToRemove();
//        int[] arr = {1,2,3,10,4,2,3,5};
        int[] arr = {1, 2, 3, 10, 0, 7, 8, 9};
//        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(obj.findLengthOfShortestSubarray(arr));
    }
}
