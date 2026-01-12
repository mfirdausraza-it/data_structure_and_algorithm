package com.codecafe.dsa_pattern.sliding_window;

public class LongestSubstringAfterReplacement {
	/**
	 * You are given a string s and an integer k. You can choose any character of
	 * the string and change it to any other uppercase English character. You can
	 * perform this operation at most k times. Return the length of the longest
	 * substring containing the same letter you can get after performing the above
	 * operations.
	 */

	public int characterReplacement(String s, int k) {
		int windowStart = 0;
		int maxLength = 0;
		int maxRepeatLetterCount = 0;
		int[] charFrequency = new int[26];
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			charFrequency[rightChar - 'A']++;
			// update the count of the most frequently occurring letter in the current
			// window
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charFrequency[rightChar - 'A']);
			/**
			 * Current window size is from windowStart to windowEnd, overall we have a
			 * letter which is repeating 'maxRepeatLetterCount' times, this means we can
			 * have a window which has one letter repeating 'maxRepeatLetterCount' times and
			 * the remaining letters we should replace. if the remaining letters are more
			 * than 'k', it is the time to shrink the window as we are not allowed to
			 * replace more than 'k' letters
			 * 
			 */
			int windowSize = windowEnd - windowStart + 1;
			if (windowSize - maxRepeatLetterCount > k) {
				char leftChar = s.charAt(windowStart);
				charFrequency[leftChar - 'A']--;
				windowStart++;
				/**
				 * Every time we update maxLen, it’s based on a valid window under the current
				 * maxFreq. After that, if we shrink (because the window became invalid), the
				 * current maxLen is already the best we could achieve with that maxFreq. To
				 * beat that maxLen later, we need a new window where maxFreq is higher
				 * (allowing us to cover more characters with ≤ k changes). Keeping the old
				 * (higher) maxFreq during shrinking is safe (it might overestimate, but never
				 * underestimates the potential). Decreasing maxFreq would be wrong — it would
				 * make us think we need more changes than we actually do, causing us to shrink
				 * unnecessarily and miss larger valid windows.
				 */
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}

		return maxLength;
	}
	
}