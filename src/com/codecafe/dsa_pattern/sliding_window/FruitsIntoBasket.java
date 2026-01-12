package com.codecafe.dsa_pattern.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
	
	/**
	 * You are visiting a farm that has a single row of fruit trees arranged from
	 * left to right. The trees are represented by an integer array fruits where
	 * fruits[i] is the type of fruit the ith tree produces.
	 * 
	 * You want to collect as much fruit as possible. However, the owner has some
	 * strict rules that you must follow:
	 * 
	 * You only have two baskets, and each basket can only hold a single type of
	 * fruit. There is no limit on the amount of fruit each basket can hold.
	 * 
	 * Starting from any tree of your choice, you must pick exactly one fruit from
	 * every tree (including the start tree) while moving to the right. The picked
	 * fruits must fit in one of your baskets. 
	 * 
	 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
	 * 
	 * Given the integer array fruits, return the maximum number of fruits you can
	 * pick.
	 */
	
	public int totalFruit(int[] fruits) {
		
		// Sliding Window with HashMap
		Map<Integer, Integer> fruitCountMap = new HashMap<>();
		int windowStart = 0, maxFruits = 0;
		
		// Expand the window by moving windowEnd to the right
		for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
			// Add the fruit at windowEnd to the map
			int rightFruit = fruits[windowEnd];
			fruitCountMap.put(rightFruit, fruitCountMap.getOrDefault(rightFruit, 0) + 1);

			// Shrink the window from the left if we have more than 2 types of fruits
			while (fruitCountMap.size() > 2) {
				int leftFruit = fruits[windowStart];
				// Remove one occurrence of the fruit at windowStart
				fruitCountMap.put(leftFruit, fruitCountMap.get(leftFruit) - 1);
				if (fruitCountMap.get(leftFruit) == 0) {
					fruitCountMap.remove(leftFruit);
				}
				// Move the window start to the right
				windowStart++;
			}
			// Update the maximum number of fruits collected
			maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
		}

		return maxFruits;
	}
	
	public static void main(String[] args) {
		FruitsIntoBasket fruitsIntoBasket = new FruitsIntoBasket();
		System.out.println(fruitsIntoBasket.totalFruit(new int[] {1,2,1})); // 3
		System.out.println(fruitsIntoBasket.totalFruit(new int[] {0,1,2,2})); // 3
		System.out.println(fruitsIntoBasket.totalFruit(new int[] {1,2,3,2,2})); // 4
		System.out.println(fruitsIntoBasket.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4})); // 5
	}

}