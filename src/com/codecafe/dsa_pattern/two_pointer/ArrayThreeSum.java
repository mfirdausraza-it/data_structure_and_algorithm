package com.codecafe.dsa_pattern.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {

	    // Step 1: Sort the array to use two-pointer technique
	    Arrays.sort(nums);
	    int n = nums.length;
	    // This list will store all unique triplets whose sum is zero
	    List<List<Integer>> list = new ArrayList<>();
	    // Step 2: Fix the first element one by one
	    for (int i = 0; i < n; i++) {
	        // Skip duplicate values for the first element to avoid duplicate triplets
	        if (i > 0 && nums[i] == nums[i - 1]) continue;
	        // Step 3: Use two pointers for the remaining part of the array
	        int j = i + 1;     // left pointer
	        int k = n - 1;     // right pointer
	        // Step 4: Move pointers until they meet
	        while (j < k) {
	            // Calculate the sum of the triplet
	            int sum = nums[i] + nums[j] + nums[k];
	            // Case 1: Triplet sum equals zero
	            if (sum == 0) {
	                // Add the valid triplet to the result list
	                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                // Move both pointers to look for next possible triplet
	                j++;
	                k--;
	                // Skip duplicate values for the second element
	                while (j < k && nums[j] == nums[j - 1]) j++;
	                // Skip duplicate values for the third element
	                while (j < k && nums[k] == nums[k + 1]) k--;
	            }
	            // Case 2: Sum is less than zero → need a bigger value
	            else if (sum < 0) {
	                j++; // move left pointer forward
	            }
	            // Case 3: Sum is greater than zero → need a smaller value
	            else {
	                k--; // move right pointer backward
	            }
	        }
	    }
	    // Step 5: Return all unique triplets
	    return list;
	}
	
	
	// fixed one number and solve for two sum problem
	// for the remaining part of the array
	public List<List<Integer>> threeSum_HashMap(int[] nums) {

		// Get the length of the input array
		int n = nums.length;

		// Use a Set to store unique triplets and avoid duplicates automatically
		Set<List<Integer>> result = new HashSet<>();
		// Special case: if array contains exactly 3 elements,
		// directly check whether their sum is zero
		if (n == 3) {
			if (nums[0] + nums[1] + nums[2] == 0) {
				result.add(List.of(nums[0], nums[1], nums[2]));
			}
			// Convert set to list and return
			return new ArrayList<>(result);
		}
		// Sort the array to bring numbers into a fixed order,
		// which helps in handling duplicates and consistent triplet ordering
		Arrays.sort(nums);
		// Iterate through each element and treat it as the first number of the triplet
		for (int i = 0; i < n; i++) {
			// Fix the current number and calculate the target sum for remaining two numbers
			int sum = nums[i];
			int target = -1 * sum;
			// Map is used to store numbers and their indices seen so far
			// for the current 'i' to find two numbers that add up to 'target'
			Map<Integer, Integer> map = new HashMap<>();
			// Traverse the rest of the array after index 'i'
			for (int j = i + 1; j < n; j++) {
				// Check if the complement (target - nums[j]) already exists in the map
				if (map.containsKey(target - nums[j])) {
					// If found, a valid triplet is formed
					// Add it to the result set to avoid duplicate triplets
					result.add(List.of(nums[i], nums[j], nums[map.get(target - nums[j])]));
				} else {
					// Otherwise, store the current number with its index in the map
					map.put(nums[j], j);
				}
			}
		}
		// Convert the result set to a list before returning
		return new ArrayList<>(result);
	}



}
