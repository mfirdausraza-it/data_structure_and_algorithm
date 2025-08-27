package com.codecafe.aditya_verma.binary_search;

public class FindAnElementInNearlySortedArray {

    // NEARLY SORTED ARRAY : an element suppose to be @ ith position,
    // could be at ith as well as i-1th or i+1th position

    // [5,10,30,20,40]
    // -- 20 should be @ 2 but it is @ 3(2+1)
    // same way 30 should be @ 3 but it is @ 2(3-1)

    static int findElementInNearlySortedArray(int[] nums, int target){
        int n = nums.length;
        if(n == 1) {
            return  nums[0] == target ? 0 : -1;
        }
        int start = 0, end = n-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            if(mid-1>start && nums[mid-1] == target) return mid-1;
            if(mid+1< end && nums[mid+1] == target) return mid+1;
            else if (nums[mid] > target) end = mid - 2;
            else start = mid+2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,10,30,20,40};
        System.out.println(findElementInNearlySortedArray(nums,20));
    }
}
