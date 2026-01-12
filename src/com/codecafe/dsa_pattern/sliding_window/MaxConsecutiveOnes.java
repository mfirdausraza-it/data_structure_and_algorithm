package com.codecafe.dsa_pattern.sliding_window;

public class MaxConsecutiveOnes {
	/**
	 * Given a binary array nums and an integer k, return the maximum number of
	 * consecutive 1's in the array if you can flip at most k 0's.
	 */
	
	// Sliding Window Approach
	public int longestOnes_V1(int[] nums, int k) {
		int left = 0, maxLen = 0, n = nums.length;
		int maxRepeatOnesCount = 0;
		int[] freq = new int[2];
		for (int right = 0; right < n; right++) {
			int rightEle = nums[right];
			freq[rightEle]++;

			// Count of maximum repeating 1's in the current window
			if (rightEle == 1)
				maxRepeatOnesCount++;
			// check if window is valid
			while (right - left + 1 - maxRepeatOnesCount > k) {
				int leftEle = nums[left];
				freq[leftEle]--;
				left++;
				/*
				 * Update count of maximum repeating 1's in the current window Because our
				 * target fixed to flip 0's to 1's so we have to maintain count of 1's in the
				 * current window for valid window check If we overestimated the count of 1's
				 * (by not decreasing when removing 1), we would think we need fewer flips →
				 * keep invalid window → wrong answer.
				 */
				if (leftEle == 1)
					maxRepeatOnesCount--;
			}
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}
	
	// Sliding Window Approach
	public int longestOnes_V2(int[] nums, int k) {
		int left = 0, maxLen = 0, n = nums.length;
		int zeroCount = 0;
		for (int right = 0; right < n; right++) {
			// count 0's in the current window
			if (nums[right] == 0)
				zeroCount++;
			// check if we have more than 'k' 0's in the current window
			while (zeroCount > k) {
				// shrink the window from the left
				// decrease the count of 0's as we are removing left element
				if (nums[left] == 0)
					zeroCount--;
				left++;
			}
			// update the maximum length of valid window
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}
}