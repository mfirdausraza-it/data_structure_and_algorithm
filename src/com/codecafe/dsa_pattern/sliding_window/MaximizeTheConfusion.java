package com.codecafe.dsa_pattern.sliding_window;

public class MaximizeTheConfusion {

    public static int maxConsecutiveAnswers(String answerKey, int k) {

        int left = 0, n = answerKey.length();
        int maxLen = 0, maxFreqOfT = 0, maxFreqOfF = 0;
        for (int right = 0; right < n; right++) {
            char rightChar = answerKey.charAt(right);
            // expand the window by including answerKey[right]
            if (rightChar == 'T')
                maxFreqOfT++;
            else
                maxFreqOfF++;
            // if window break, then shrink
            if (Math.min(maxFreqOfT, maxFreqOfF) > k) {
                // shrink the window from left
                char leftChar = answerKey.charAt(left);
                if (leftChar == 'T')
                    maxFreqOfT--;
                else
                    maxFreqOfF--;
                left++;
            }
            // update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
