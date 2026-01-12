package com.codecafe.dsa_pattern.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinct {
	
	
	public static int longestSubstringWithKDistinct(String str, int k) {
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		int windowStart = 0, maxLength = 0;
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			// First, we will insert characters from the beginning of the string until
			// we have K distinct characters in the HashMap.
			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

			// we will try to shrink the window from the beginning if the count of distinct
			// characters in the HashMap is larger than K.
			// We will shrink the window until we have no more than K distinct characters in the HashMap.
			// This is needed as we intend to find the longest window.
			while (charFrequencyMap.size() > k) {
				char leftChar = str.charAt(windowStart);
				// reduce the frequency of the leftmost character
				charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
				// remove the leftmost character from the map if its frequency is 0
				if (charFrequencyMap.get(leftChar) == 0) {
					charFrequencyMap.remove(leftChar);
				}
				// shrink the window
				windowStart++;
			}
			// At the end of each step, well check if the current window length is the
			// longest so far,
			// and if so, remember its length.
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(longestSubstringWithKDistinct("araaci", 2)); // 4
		System.out.println(longestSubstringWithKDistinct("araaci", 1)); // 2
		System.out.println(longestSubstringWithKDistinct("cbbebi", 3)); // 5
	}
	
	
}