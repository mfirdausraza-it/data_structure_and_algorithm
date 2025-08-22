package com.codecafe.aditya_verma.binary_search;

/**
 * sorting order of array is not unknown
 * it could be ascending or descending
 */
public class SearchOnUnknownSortedOrder {

    public static void main(String[] args) {
//        int[] arr = {15,14,13,12,10,9,7,6,4,2,1};
        int[] arr = {1,2};
        System.out.println(searchOnUnknownSortedArray(arr,2));
    }

    static int searchOnUnknownSortedArray(int[] arr, int target){
        int n = arr.length;
        if(n == 1) return arr[0] == target ? 0 : -1;
        int start = 0, end = n-1;
        boolean flag = false;
        //step 1 : check array is descending or not
        if(arr[0] > arr[1]){
            flag = true;
        }
        //step 2 : search for number as usual
        while(start<=end){
            int mid = start + (end - start)/2;
            if (arr[mid] == target) return mid;
            if(flag){
                if(arr[mid]>target) start = mid+1;
                else end = mid-1;
            }else{
                if(arr[mid]<target) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
}
