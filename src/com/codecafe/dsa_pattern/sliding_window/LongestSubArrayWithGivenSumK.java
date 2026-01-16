package com.codecafe.dsa_pattern.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSumK {
	
	static int longestSubArrayWithGivenSumK(int[] nums, int k) {
		
		int len = 1;
		int max = 0;
		while(len<=nums.length) {
			for(int i=0; i<nums.length+1-len; i++) {
				int sum=0;
				for(int j=i; j<i+len; j++) {
					sum+=nums[j];
					System.out.print(nums[j]);
				}
				if(sum==k) max = Math.max(max, len);
				System.out.println("->");
			}
			System.out.println();
			len++;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1, 1, 1, 1};
		System.out.println(lenOfLongSubarr_PrefixSum(nums,nums.length,3));
		System.out.println(lenOfLongSubarr_SlidingWindow(nums,nums.length,3));
		System.out.println(minSubArrayLen_PrefixSum(7, new int[] {2,3,1,2,4,3}));
		System.out.println(minSubArrayLen_SlidingWindow(7, new int[] {2,3,1,2,4,3}));
	}
	
	
	//Approach using HashMap and PREFIX SUM
    public static int lenOfLongSubarr_PrefixSum(int A[], int N, int K) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<N; i++) {
        	sum+=A[i];
        	if(sum == K) max = i+1;
        	if(map.containsKey(sum-K)) {
        		max = Math.max(max, i - map.get(sum-K));
        	}else {
        		map.put(sum, i);
        	}
        }
        return max;
    }
    
    
    //Approach using HashMap and SLIDING WINDOW
    public static int lenOfLongSubarr_SlidingWindow(int A[], int N, int K) {
    	
    	int left = 0, sum = 0, max = Integer.MIN_VALUE;
    	for(int right = 0; right<N; right++) {
			sum+=A[right];
			while(sum>K) {
				sum-=A[left];
				left++;
			}
			if(sum == K) {
				max = Math.max(max, right-left+1);
			}
		}
		return max;
    }
    
    /**
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum is greater than or 
     * equal to target. If there is no such subarray, return 0 instead.
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     */
    public static int minSubArrayLen_PrefixSum(int target, int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0] == target ? 1 : 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
        	sum+=nums[i];
        	if(sum == target) min = i+1;
        	if(map.containsKey(sum-target)) {
        		min = Math.min(min, i-map.get(sum-target));
        	}else {
        		map.put(sum, i);
        	}
        }
        return min;
    }
    
    //Approach using SLIDING WINDOW
    public static int minSubArrayLen_SlidingWindow(int target, int[] nums) {
    	
		int n = nums.length;
		int left = 0, sum = 0, min = Integer.MAX_VALUE;
		for(int right = 0; right<n; right++) {
			sum+=nums[right];
			while(sum>=target) {
				min = Math.min(min, right-left+1);
				sum-=nums[left];
				left++;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
    }

}