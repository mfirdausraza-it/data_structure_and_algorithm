package com.codecafe.aditya_verma.binary_search;

public class PeakElement {

    // arr = {1,3,6,8,9,10,7,5,3,2} -- answer = 10 or index of 10
    static int peakElement(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;
        int start = 0, end = n-1;
        while (start != end){
            int mid = start + (end - start) / 2;
            //check for slop
            if(nums[mid]>nums[mid+1]) end = mid; //decreasing slop
            else start = mid+1; //increasing slop
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,8,9,10,7,5,3,2};
        System.out.println(peakElement(arr));
    }
}
