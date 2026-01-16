package com.codecafe.dsa_pattern.two_pointer;

public class SquaresOfASortedArray {
	
	
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        
        // Find the index of the last negative number
        // This will help us to divide the array into negative and non-negative parts
        int negIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                negIndex = i;
        }
        
        int[] sortedSqreArr = new int[n];
        // Two pointers to traverse the negative and non-negative parts
        int posIndex = negIndex + 1, runningIndex = 0;
        while ((negIndex > -1 || posIndex < n) && runningIndex < n) {
        	// Compare the squares of the negative and non-negative numbers
            int negSquare = Integer.MAX_VALUE, posSquare = Integer.MAX_VALUE;
            if (negIndex > -1)
            	// Square of the negative number
                negSquare = (int) Math.pow(nums[negIndex], 2);
            if (posIndex < n)
            	// Square of the non-negative number
                posSquare = (int) Math.pow(nums[posIndex], 2);
            if (negSquare < posSquare) {
            	// If the square of the negative number is smaller,
                sortedSqreArr[runningIndex] = negSquare;
                negIndex--;
            } else {
            	// If the square of the non-negative number is smaller or equal,
                sortedSqreArr[runningIndex] = posSquare;
                posIndex++;
            }
            // Move to the next position in the result array
            runningIndex++;
        }
        return sortedSqreArr;
    }

}
