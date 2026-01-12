package com.codecafe.dsa_pattern.sliding_window;

import java.util.Arrays;

public class FindPermutationInString {

	public static boolean checkInclusion(String s1, String s2) {
		// Edge case: if s1 is longer than s2, no permutation can exist
		if (s1.length() > s2.length()) {
			return false;
		}
		// Frequency array for characters in s1 (target frequencies)
		int[] targetFreq = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			targetFreq[c - 'a']++;
		}
		// Frequency array for the current window in s2
		int[] windowFreq = new int[26];
		int left = 0; // left pointer of the sliding window
		// Expand the window using right pointer
		for (int right = 0; right < s2.length(); right++) {
			// Add the current character to the window
			char rightChar = s2.charAt(right);
			windowFreq[rightChar - 'a']++;
			// If window size exceeds s1.length(), shrink from the left
			// This ensures we only maintain windows of size exactly s1.length()
			while (right - left + 1 > s1.length()) {
				char leftChar = s2.charAt(left);
				// remove character going out of window
				windowFreq[leftChar - 'a']--;
				left++; // move left pointer right
			}
			// Now the window size is exactly s1.length()
			// Only check for match when sizes are equal
			if (right - left + 1 == s1.length()) {
				if (Arrays.equals(windowFreq, targetFreq)) {
					return true; // found a permutation
				}
			}
		}
		// No matching window found after checking all possible positions
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo")); // true
		System.out.println(checkInclusion("ab", "eidboaoo")); // false
		System.out.println(checkInclusion("adc", "dcda")); // true
	}
	
}