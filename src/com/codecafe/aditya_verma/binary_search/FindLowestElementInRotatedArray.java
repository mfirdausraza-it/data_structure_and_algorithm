package com.codecafe.aditya_verma.binary_search;

public class FindLowestElementInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {7,1,2,3,4,5,6};
        System.out.println(findLowestElementInRotatedSortedArray(arr));
    }

    static int findLowestElementInRotatedSortedArray(int[] arr){
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        int left = 0, right = n-1;
        while(left!=right){
            int mid = left + (right - left)/2;
            // Lowest element always lie in unsorted array
            //if arr[right] is less than arr[mid], it means lowest value is in right side
            // [3,4,5,6,7,1,2]
            if(arr[mid]>arr[right]) left = mid+1;
            //if arr[right], is equal to or greater than arr[mid] then lowest value is left side
            // here i am not writing right = mid-1, because mid is not yet check
            else right = mid;
        }
        // loop is breaking at left == right you can return either of them
        return left;
    }
}
