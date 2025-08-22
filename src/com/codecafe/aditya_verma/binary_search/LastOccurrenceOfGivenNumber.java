package com.codecafe.aditya_verma.binary_search;

public class LastOccurrenceOfGivenNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,5,5,5,5,7,10,11,11,11,11,12};
        System.out.println(lastOccurrenceOfGivenNumber(arr,11));
    }

    static int lastOccurrenceOfGivenNumber(int[] arr, int target){
        int n = arr.length;
        if(n == 1){
            return arr[0] == target ? 0 : -1;
        }
        int low = 0, high = n-1, ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                ans = mid;
                low = mid+1;
            }else if(arr[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return ans;
    }
}
