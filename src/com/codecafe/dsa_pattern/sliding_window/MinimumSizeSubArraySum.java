package com.codecafe.dsa_pattern.sliding_window;

public class MinimumSizeSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        // Current sum of the window [start, end]
        int windowSum = 0;

        // Track the smallest valid window length found so far
        int minLen = Integer.MAX_VALUE;

        // Left pointer of the sliding window
        int start = 0;

        // Right pointer expands the window
        for (int end = 0; end < n; end++) {
            // Add the current element to the window sum
            windowSum += nums[end];

            // While the current window sum is >= target, try to shrink from the left
            while (start <= end && windowSum >= target) {
                // Update minimum length with current window size
                minLen = Math.min(minLen, end - start + 1);

                // Shrink the window from the left to see if we can get a smaller one
                windowSum -= nums[start];
                start++;
            }
        }

        // If minLen was never updated, no valid subarray exists → return 0
        // Otherwise return the smallest length found
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // 2
        System.out.println(minSubArrayLen(4, new int[]{1,4,4})); // 1
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // 0
    }
}
