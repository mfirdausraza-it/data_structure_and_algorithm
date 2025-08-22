package com.codecafe.aditya_verma.binary_search;

public class SearchOnReverseSortedArray {

    public static void main(String[] args) {
        int[] arr = {15,14,13,12,10,9,7,6,4,2,1};
        System.out.println(searchOnReverseSortedArray(arr,1));
    }

    /**
     * order of array is descending
     */
    static int searchOnReverseSortedArray(int[] arr, int target){
        int n = arr.length;
        if(n == 1) return arr[0] == target ? 0 : -1;
        int start = 0, end = n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
