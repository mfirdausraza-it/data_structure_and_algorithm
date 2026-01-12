package com.codecafe.dsa_pattern.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
	
	
	//Approach 1: Sliding Window with HashSet
	public static int lengthOfLongestSubstring(String s) {
		int windowStart = 0, maxLength = 0;
		// A set to store the unique characters in the current window
		Set<Character> charSet = new HashSet<>();
		// Expand the window by moving windowEnd to the right
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			// If the character is already in the set, we need to shrink the window
			// from the start until we remove the duplicate character.
			while (charSet.contains(rightChar)) {
				// Remove the leftmost character from the set
				char leftChar = s.charAt(windowStart);
				charSet.remove(leftChar);
				// Move the window start to the right
				windowStart++;
			}
			// Add the current character to the set
			charSet.add(rightChar);
			// Update the maximum length of the substring found so far
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
	
	// Approach 2: Sliding Window with HashMap
	public int lengthOfLongestSubstring_V2(String s) {
		int n = s.length();

		// Left pointer of the sliding window
		int left = 0;
		// Tracks the maximum length found so far
		int maxLen = 0;
		// Map to store the most recent index of each character
		Map<Character, Integer> charIndex = new HashMap<>();
		// Expand the window by moving the right pointer
		for (int right = 0; right < n; right++) {
			char rightMostChar = s.charAt(right);
			// If character already exists in the current window,
			// move left pointer to right after the last occurrence
			if (charIndex.containsKey(rightMostChar)) {
				// Update left pointer only if it's behind the last occurrence
				left = Math.max(left, charIndex.get(rightMostChar) + 1);
			}
			// Update the last seen index of the current character
			charIndex.put(rightMostChar, right);
			// Update max length if current window is longer
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}
    
    public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcdefghijklaaa"));
	}
}