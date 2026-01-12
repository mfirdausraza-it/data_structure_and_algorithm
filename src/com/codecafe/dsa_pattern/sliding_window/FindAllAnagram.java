package com.codecafe.dsa_pattern.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagram {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int[] targetFreq = new int[26];
        //calculate freq of target string
        for(int i = 0; i<p.length(); i++){
            targetFreq[p.charAt(i)-'a']++;
        }
        int left = 0;
        int[] windowFreq = new int[26];
        for(int right = 0; right<s.length(); right++){
            char rightChar = s.charAt(right);
            windowFreq[rightChar-'a']++;
            //check for invalid window
            while(right-left+1 > p.length()){
                char charLeft = s.charAt(left);
                windowFreq[charLeft-'a']--;
                left++;
            }
            //check if freq is same
            if(right-left+1 == p.length()){
                if(Arrays.equals(windowFreq,targetFreq)){
                    answer.add(left);
                }
            }
        }
        return answer;
    }

}
