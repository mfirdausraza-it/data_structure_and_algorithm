package com.codecafe.aditya_verma.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Stock Span Problem
 * 
 * Problem Statement:
 * The span S[i] of a stock's price on a given day i is defined as the maximum number of 
 * consecutive days just before the given day, where the stock's price was less than or 
 * equal to its price on the given day (including the day itself).
 * 
 * In other words: How many consecutive days before (and including) today have stock price <= today's price?
 * 
 * Example: prices = [100, 80, 60, 70, 60, 75, 85]
 * Spans:     S    = [1,   1,  1,  2,  1,  4,  6]
 * 
 * Explanation:
 * - Day 0: price=100, span=1 (only itself)
 * - Day 1: price=80, span=1 (80 < 100, can't include day 0)
 * - Day 2: price=60, span=1 (60 < 80, can't include day 1)
 * - Day 3: price=70, span=2 (70 >= 60 on day 2, but 70 < 80 on day 1, so includes days 2,3)
 * - Day 4: price=60, span=1 (60 <= 70 but we need consecutive, 60 < 70 breaks the chain)
 * - Day 5: price=75, span=4 (75 >= 60,70,60, includes days 2,3,4,5, but 75 < 100)
 * - Day 6: price=85, span=6 (85 >= 75,60,70,60,80, includes days 1,2,3,4,5,6)
 * 
 * Algorithm: Uses monotonic decreasing stack with indices
 * For each day i:
 * 1. Find the nearest previous day where price > current day's price (using stack)
 * 2. If no such day exists, span = i + 1 (all days up to current)
 * 3. If such a day exists at index j, span = i - j
 */
public class Stack05_StockSpan {

    /**
     * Calculates the stock span for each day using a monotonic stack approach.
     * 
     * Key Insight:
     * - We need to find, for each day, the index of the nearest previous day with a price > current price
     * - Use a decreasing monotonic stack that stores indices
     * - For each day i:
     *   1. Pop all indices where arr[index] <= arr[i] (these break the span chain)
     *   2. If stack is empty, all days up to i have price <= arr[i], so span = i + 1
     *   3. If stack not empty, top index j means arr[j] > arr[i], so span = i - j
     *   4. Push current index to stack
     * 
     * @param arr - array of stock prices
     * @return ArrayList containing the span for each day
     * 
     * Time Complexity: O(n) - each element is pushed and popped at most once
     * Space Complexity: O(n) - for stack and result array
     */
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;
        
        // Stack stores indices of prices in decreasing order
        // Maintains candidates for nearest previous day with higher price
        Stack<Integer> stack = new Stack<>();
        
        // Result array to store span for each day
        int[] result = new int[n];
        
        // Process each day
        for(int i = 0; i<n; i++){
            // Pop all indices from stack where the price <= current price
            // These days break the consecutive chain where all prices <= current
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            
            // Calculate span for current day
            // If stack is empty: no previous day has higher price, span includes all days 0 to i
            //   So span = i - (-1) = i + 1
            // If stack not empty: top index has higher price, span = distance from top to current
            //   So span = i - stack.peek() (which gives count of consecutive days including current)
            result[i] = stack.isEmpty() ? i+1 : i-stack.peek();
            
            // Push current day's index to stack for processing future days
            stack.push(i);
        }
        
        // Print result for verification
        System.out.println(Arrays.toString(result));
        
        // Convert array to ArrayList for return
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : result) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        // Test case 1: [100, 80, 60, 70, 60, 75, 85]
        // Expected spans: [1, 1, 1, 2, 1, 4, 6]
        int[] nums = {100,80,60,70,60,75,85};
        System.out.println(calculateSpan(nums));
        
        // Test case 2 (commented out): [100, 80, 90, 120]
        // Expected spans: [1, 1, 2, 4]
//        int[] nums = {100,80,90,120};
    }
}


