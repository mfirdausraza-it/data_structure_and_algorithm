package com.codecafe.aditya_verma.binary_search;

public class FloorAndCeilOfAnElement {

    // if number is 5.8 -- Floor = 5 and ceil = 6
    //find floor of element -- greatest element less that given element
    static int findFloorOfAnElement(int[] nums, int target){
        int n = nums.length;
        if(n == 1) return nums[0] == target ? 0 : -1;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return nums[high];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,7,9,11,15,17};
        System.out.println(findFloorOfAnElement(nums,6));
    }
}
