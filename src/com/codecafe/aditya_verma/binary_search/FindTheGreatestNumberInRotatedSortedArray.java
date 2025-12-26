package com.codecafe.aditya_verma.binary_search;

public class FindTheGreatestNumberInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7,8,9,10,1,2,3,4,5,6};
        System.out.println(findGreatestElementInRotatedSortedArray(arr));
    }

    static int findGreatestElementInRotatedSortedArray(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element > right, max lies in [mid+1..right]
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Else, max lies in [left..mid]
                right = mid;
            }
        }
        // After loop, left points to minimum element
        // So the greatest element is at (left - 1 + n) % n
        return (left - 1 + n) % n;
    }

}
