package com.codecafe.aditya_verma.stack;

public class Stack08_TrappingRainWater {

    /**
     * This method calculates the total amount of rainwater that can be trapped between bars of given heights.
     * The problem assumes that the bars are arranged in a line, and water can be trapped in the valleys formed by the bars.
     * <p>
     * Approach: We use a precomputation method to find the maximum height to the left and right of each bar.
     * For each bar, the amount of water trapped above it is determined by the minimum of the left and right max heights minus the bar's own height.
     * This ensures that water doesn't spill over the shorter boundary.
     * <p>
     * Time Complexity: O(n) where n is the number of bars, as we perform three linear passes.
     * Space Complexity: O(n) for the left and right arrays.
     *
     * @param height An array of integers representing the heights of the bars.
     * @return The total units of rainwater that can be trapped.
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0; // Edge case: no bars, no water trapped

        int maxValue = 0;
        int[] left = new int[n]; // Array to store the maximum height to the left of each index (including itself)

        // First pass: Compute the maximum height from the left for each position
        // This helps determine the left boundary for water trapping at each index
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, height[i]); // Update the running max from the left
            left[i] = maxValue; // Store the max height seen so far from the left
        }

        maxValue = 0; // Reset maxValue for the right pass
        int[] right = new int[n]; // Array to store the maximum height to the right of each index (including itself)

        // Second pass: Compute the maximum height from the right for each position
        // This helps determine the right boundary for water trapping at each index
        for (int i = n - 1; i >= 0; i--) {
            maxValue = Math.max(maxValue, height[i]); // Update the running max from the right
            right[i] = maxValue; // Store the max height seen so far from the right
        }

        int maxWater = 0; // Variable to accumulate the total trapped water

        // Third pass: Calculate the trapped water for each bar
        // For each bar, the water level is limited by the shorter of the two max heights (left and right)
        // Subtract the bar's height to get the trapped water above it
        for (int i = 0; i < n; i++) {
            maxWater += Math.min(left[i], right[i]) - height[i]; // Add the trapped water at this position
        }

        return maxWater; // Return the total trapped water
    }

}

