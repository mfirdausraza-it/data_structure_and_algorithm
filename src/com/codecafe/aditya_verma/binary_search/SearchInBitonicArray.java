package com.codecafe.aditya_verma.binary_search;

public class SearchInBitonicArray {

    //Bitonic Array -- strickly increase + 1 peak element + strickly decrease
    // also arr[i] != arr[i+1]

    // question find an element in bitonic array
    // arr = {1,3,5,6,8,12,4,3,2,1} , target = 4

    // Approach 1 : first we will find peak element and will divide array into two part
    static int peakElement(int[] arr){
        int n = arr.length;
        int start = 0, end = n-1;
        while(start != end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid+1]) end = mid;
            else start = mid+1;
        }
        return end;
    }

    static int searchInABitonicArray(int[] arr, int target){
        int n = arr.length;
        if(n == 1) return arr[0] == target ? 0 : -1;
        int peak = peakElement(arr);
        int firstHalf = binarySearch(arr,target,false,0,peak);
        if(firstHalf != -1) return firstHalf;
        return binarySearch(arr,target,true,peak+1,n-1);
    }

    static int binarySearch(int[] arr, int target, boolean isReverse, int start , int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) return mid;
            //check for descending part
            if(isReverse){
                if(arr[mid] > target) start = mid+1;
                else end = mid-1;
            }else{
                if(arr[mid] > target) end = mid-1;
                else start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 9, 15, 20, 14, 10, 5, 1};
        int target = 10;
        System.out.println(searchInABitonicArray(arr,1));
    }
}
