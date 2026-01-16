package com.codecafe.dsa_pattern.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	// https://leetcode.com/problems/two-sum/description/
	/**
	 * Given an array of sorted numbers and a target sum,
	 * find a pair in the array whose sum is equal to the given target.
	 */

	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		//check for edge case
		if (n == 2) {
			return new int[] { 0, 1 };
		}
		//create a map to store the complement and its index
		Map<Integer, Integer> map = new HashMap<>();
		//iterate through the array
		for (int i = 0; i < n; i++) {
			//calculate the complement
			int complement = target - nums[i];
			//check if the complement is already in the map
			if (map.containsKey(complement)) {
				//if yes, return the indices
				return new int[] { map.get(complement), i };
			}
			//if not, add the current number and its index to the map
			map.put(nums[i], i);
		}
		return new int[] {};
	}

}
