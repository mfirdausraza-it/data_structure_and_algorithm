package com.codecafe.dsa_pattern.sliding_window;

public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        // intialize maxAvg with NEGATIVE_INFINITY
        // because avg could be big negative value
        double sum = 0, maxAvg = Double.NEGATIVE_INFINITY;
        int left = 0, n = nums.length;
        //Expand the window by including nums[right]
        for(int right = 0; right<n; right++){
            //expand window by including nums[right]
            sum+=nums[right];
            //check for valid window
            while(right-left+1>=k){
                //calculate maxAvg
                maxAvg = Math.max(maxAvg,sum/k);
                // slide the window by excluding nums[left]
                sum-=nums[left++];
            }
        }
        return maxAvg;
    }


    public static void main(String[] args) {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        System.out.println(findMaxAverage.findMaxAverage(new int[]{1,12,-5,-6,50,3},4)); // 12.75
        System.out.println(findMaxAverage.findMaxAverage(new int[]{5},1)); // 5.0
    }
}
