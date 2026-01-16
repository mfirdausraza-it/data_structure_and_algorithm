package com.codecafe.dsa_pattern.two_pointer;

public class RemoveDuplicate {
	
	// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
	/**
	 * Given a sorted array nums, remove the duplicates in-place such that each
	 * element appears only once and returns the new length.
	 * Do not allocate extra space for another array, you must do this by
	 * modifying the input array in-place with O(1) extra memory.
	 */
	
	
	/**
	 * Two Pointer Approach
	 * first pointer (unique) to track the position of the last unique element
	 * second pointer (right) to explore the array
	 * When a new unique element is found, 
	 * increment the first pointer and update the value at that position
	 * Finally, return the count of unique elements
	 */
    public int removeDuplicates(int[] nums) {
    	//Initialize the first pointer
        int unique = 0;
        //Iterate through the array with the second pointer
        for(int right = 1; right<nums.length; right++){
        	//Check if the current element is different from the last unique element
            if(nums[unique] != nums[right]){
            	//If it's different, increment the first pointer and update the value
                nums[++unique] = nums[right];
            }
        }
        //Return the count of unique elements
        // ++unique because returning the length, so we need to add 1 to the index
        return ++unique;
    }

}
