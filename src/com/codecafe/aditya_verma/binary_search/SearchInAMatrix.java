package com.codecafe.aditya_verma.binary_search;

public class SearchInAMatrix {
    //Approach 1
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while(i<m && j>=0){
            int mid = matrix[i][j];
            if(mid == target) return true;
            else if(mid > target) j--;
            else i++;
        }
        return false;
    }
    // Approach 2
    public static boolean searchMatrix_II(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m*n-1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            int i = mid / n;
            int j = mid % n;
            int curr = matrix[i][j];
            if(curr == target) return true;
            else if(curr > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20}};
        System.out.println(searchMatrix(arr,3));
    }
}
