package com.codecafe.aditya_verma.binary_search;

public class FindNumberOfTimeASortedArrayIsRotated {

    //find the number of times an array is rotated
    // Approach 1 : if we are able to find the lowest number in
    // sorted array then we can calculate that how many time an
    // array is rotated
    // [1,2,3,4,5,6,7]  --> [3,4,5,6,7,1,2] -- array is rotated 2 time from left
    // [1,2,3,4,5,6,7] --> [5,6,7,1,2,3,4]  -- array is rotated 3 time from right

    static int getNumberOfTimesAnSortedArrayIsRotated(int[] nums){
        return FindLowestElementInRotatedArray.findLowestElementInRotatedSortedArray(nums);
    }

    public static void main(String[] args) {
        int[] arr = {11,13,16,19,2,3,6,8,9,10};
        System.out.println(getNumberOfTimesAnSortedArrayIsRotated(arr));
    }
}
