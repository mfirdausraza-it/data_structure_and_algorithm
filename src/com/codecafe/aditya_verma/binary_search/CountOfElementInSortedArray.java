package com.codecafe.aditya_verma.binary_search;


public class CountOfElementInSortedArray {

    //Problems : Find the count of given Number in a Sorted Array

    //approach 1 : first I will find the first occurrence of target
    // and will use a while loop from there

    //approach 2 : I will the write same code for first occurrence, and suppose I get index as first
    // same way i write it for the last occurrence, and will get index as second
    // final count will be second - first +1;

    // https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
    static int countOfElementInSortedArray(int[] arr, int target){
        int n = arr.length;
        if(n == 1){
            return arr[0] == target ? 1 : 0;
        }
        int first = countOfOccurrence(arr,target,true);
        if(first == 0) return 0;
        int second = countOfOccurrence(arr,target,false);
        return second - first+1;
    }

    static int countOfOccurrence(int[] arr, int target, boolean isFirst){
        int n = arr.length;
        int low = 0, high = n-1, count = 0;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(arr[mid] == target){
                count = mid;
                if(isFirst) high = mid-1;
                else low = mid+1;
            }else if(arr[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,5,5,5,5,7,10,11,11,11,11,12};
        System.out.println(countOfElementInSortedArray(arr,10));
    }
}
