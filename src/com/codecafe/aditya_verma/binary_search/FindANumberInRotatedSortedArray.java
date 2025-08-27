package com.codecafe.aditya_verma.binary_search;

public class FindANumberInRotatedSortedArray {

    // Approach 1 : first we will find the lowest value so that I can
    // split the array into two part and can apply Binary search on both part;
    static int findANumberInRotatedSortedArray(int[] arr,int target){
        int n = arr.length;
        int indexLowestValue = FindLowestElementInRotatedArray.findLowestElementInRotatedSortedArray(arr);
        // array 1 = 0-> indexLowestValue-1, array 2 -> indexLowestValue -> n-1
        int first = binarySearch(arr,target,0,indexLowestValue-1);
        if(first!=-1) return first;
        return binarySearch(arr,target,indexLowestValue,n-1);
    }

    static int binarySearch(int[] nums, int target,int start, int end){
        while (start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]>target) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {11,13,16,19,2,3,6,8,9,10};
        System.out.println(findANumberInRotatedSortedArray(arr,2));
    }
}
