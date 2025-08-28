package com.codecafe.aditya_verma.binary_search;

public class MinDifferenceElementInSortedArray {

    /**
     * arr  [1,  4, 6, 10, 14, 18] -- key = 11,
     * diff [10, 7, 5, 1,  3,  7]
     *
     * min different with is 1 and index of 1 is 2, we will return arr[2] = 10;
     */

    //Approach 1 = we find floor and ceil and compare if whose difference is minimum with key
    // Approach 2 = we can only find floor(just less than key) and will compare the difference of
    //              floor and floor + 1;
    //Approach 3 = just apply normal binary search and if key present will return key
    //              else when loop break start and end near to each other close to the key
    //              just normally compare whose absolute difference is less with key, either start or end
    static int minDifferenceElementWithGivenKey(int[] arr, int key){
        // ******************* Approach 1  *********************//
//        int floor = findFloorAndCeil(arr,key,true);
//        int ceil = findFloorAndCeil(arr,key,false);
//        int floorDiff = Math.abs(arr[floor] - key);
//        int ceilDiff = Math.abs(arr[ceil] - key);
//        return floorDiff <= ceilDiff ? arr[floor] : arr[ceil];
        if(key > arr[arr.length-1]) return arr[arr.length-1];
        int floor = findFloorAndCeil(arr,key,true);
        return (Math.abs(arr[floor] - key)) < (Math.abs(arr[floor+1] - key)) ? arr[floor] : arr[floor+1];
    }

    static int findFloorAndCeil(int[] arr, int key, boolean isFloor){
        int start = 0, end = arr.length-1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) end = mid - 1;
            else start = mid + 1;
        }
        start = start > arr.length ? arr.length -1 : start;
        return isFloor ? end : start;
    }

    public static void main(String[] args) {
//        int[] arr = {1,4,6,10,11,11,11,14,14,14,14,18};
        int[] arr = {1,2,3,4,5,5,5,5,8};
        System.out.println(minDifferenceElementWithGivenKey(arr,7));
    }

}
