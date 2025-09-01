package com.codecafe.aditya_verma.binary_search;

public class SearchInAMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while(i<m && j>=0){
            int mid = matrix[i][j];
            System.out.println("Mid : " + mid + " : i : "+ i +" : j : " + j);
            if(mid == target) return true;
            else if(mid > target) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1}};
        System.out.println(searchMatrix(arr,2));
    }
}
