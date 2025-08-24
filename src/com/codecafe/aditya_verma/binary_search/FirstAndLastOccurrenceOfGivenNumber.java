package com.codecafe.aditya_verma.binary_search;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FirstAndLastOccurrenceOfGivenNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,5,5,5,5,7,10,11,12};
        System.out.println(Arrays.toString(firstAndLastOccurrenceOf_OPTIMISE(arr,5)));
    }
    //BRUTE_FORCE_SOLUTION
    static int[] firstAndLastOccurrenceOf(int[] arr, int target){
        int n = arr.length;
        if(n == 1){
            return n == target ? new int[]{0,0} : new int[]{-1,-1};
        }
        int start = 0, end = n-1, ans = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                ans = mid;
                break;
            }else if(arr[mid] < target) start = mid+1;
            else end = mid-1;
        }
        if(ans == -1) return new int[]{-1,-1};
        int left = ans, right = ans;
        while(left>0 && arr[left] == arr[left-1]) left--;
        while(right<n-1 && arr[right] == arr[right+1]) right++;
        return new int[]{left, right};
    }

    //OPTIMISE_SOLUTION
    static int[] firstAndLastOccurrenceOf_OPTIMISE(int[] arr, int target) {
        int first = occurrence(arr,target,true);
        if(first == -1) return new int[]{-1,-1};
        int second = occurrence(arr,target,false);
        return new int[]{first,second};
    }

    static int occurrence(int[] arr, int target, boolean isFirst){
        int n = arr.length;
        if(n == 1){
            return arr[0] == target ? 0 : -1;
        }
         int start = 0, end = n-1, ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target) {
                //even if we found the target will not stop the searching,
                ans = mid;
                // we are searching for first and last occurrence,
                // based on that we will shift the start and end accordingly
                if (isFirst) end = mid - 1;
                else start = mid + 1;
            }else if(arr[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return ans;
    }
}
