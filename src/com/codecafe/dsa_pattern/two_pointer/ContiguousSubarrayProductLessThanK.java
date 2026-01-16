package com.codecafe.dsa_pattern.two_pointer;

public class ContiguousSubarrayProductLessThanK {
	
	//Brute Force Approach
	// Generate All subarray of length 1 to n.
	// check product of each subarray
    public static int numSubarrayProductLessThanK_I(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) {
        	return nums[0] < k ? 1 : 0;
        }
        int count = 0;
        int len = 1;
        while(len <= n) {
			for(int i = 0; i <= n - len; i++) {
				int product = 1;
				for(int j = i; j < i + len; j++) {
					product *= nums[j];
					if(product >= k) {
						break;
					}
				}
				if(product < k) {
					count++;
				}
			}
			len++;
		}
        return count;
    }
    
    
    //Optimal Approach - Sliding Window
    public int numSubarrayProductLessThanK_II(int[] nums, int k) {
    	// Edge case: If k is less than or equal to 1,
    	// no subarray can have a product less than k
        if (k <= 1) return 0;
        int n = nums.length; 
        int left = 0,count = 0;
        long product = 1;
        // Expand the window by moving the right pointer
        for(int right = 0; right<n; right++) {
        	// Multiply the current element to the product
        	product*=nums[right];
        	// Shrink the window from the left if the product is >= k
        	while(product >= k) {
        		// Divide the product by the leftmost element and move the left pointer
        		product = product/nums[left++];
        	}
        	// All subarrays ending at 'right' with starting index from 'left' to 'right' are valid
        	count+=right-left+1;
        }
        return count;
    }

}
