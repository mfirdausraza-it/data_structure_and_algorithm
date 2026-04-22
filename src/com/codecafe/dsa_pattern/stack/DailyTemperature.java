package com.codecafe.dsa_pattern.stack;

public class DailyTemperature {

    //https://leetcode.com/problems/daily-temperatures/
    // Given an array of integers temperatures represents the daily temperatures,
    // return an array answer such that answer[i] is the number of days you have to
    // wait after the ith day to get a warmer temperature. If there is no future day
    // for which this is possible, keep answer[i] == 0 instead.
    //Example 1:
    //Input: temperatures = [73,74,75,71,69,72,76,73]
    //Output: [1,1,4,2,1,1,0,0]
    // Brute Force Approach
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(temperatures[i] < temperatures[j]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

     public static void main(String[] args) {
         int[] temperatures = {73,74,75,71,69,72,76,73};
         int[] ans = dailyTemperatures(temperatures);
         for(int a : ans){
             System.out.print(a + " ");
         }
     }
}
