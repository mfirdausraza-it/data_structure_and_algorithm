package com.codecafe.dsa_pattern.two_pointer;

public class RemoveTargetElement {
	
	//https://leetcode.com/problems/remove-element/
	
	/**
	 * Given an integer array nums and an integer val, 
	 * remove all occurrences of val in nums in-place. 
	 * The order of the elements may be changed. 
	 * Then return the number of elements in nums which are not equal to val.	
	 */
	
	/**
	 * Two Pointer Approach
	 * first pointer (i) to track the position of the next non-val element
	 * second pointer (j) to explore the array
	 * When a non-val element is found,
	 * increment the first pointer and update the value at that position
	 * Finally, return the count of non-val elements
	 */
	
	public int removeElement(int[] nums, int val) {
		// Initialize the first pointer
		int i = 0;
		// Iterate through the array with the second pointer
		for (int j = 0; j < nums.length; j++) {
			// Check if the current element is different from val
			if (nums[j] != val) {
				// If it's different, increment the first pointer and update the value
				nums[i++] = nums[j];
			}
		}
		// Return the count of non-val elements
		return i;
	}

}
