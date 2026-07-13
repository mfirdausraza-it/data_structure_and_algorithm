package com.codecafe.aditya_verma.recursion;

public class SortAnArray {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, arr.length);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int n){
        if(n == 1) return;

        int last = arr[n-1];
        sort(arr, n-1);
        insert(arr, n-1, last);
    }

    private static void insert(int[] arr, int i, int last) {
        if(i == 0 || arr[i-1] < last) {
            arr[i] = last;
            return;
        }
        arr[i] = arr[i-1];
        insert(arr, i-1, last);
    }

}
