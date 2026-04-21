package com.codecafe.dsa_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfSubstringAppearTwice {

    static int lengthOfStringThatAppearTwice_brute_force(String s){
        int n = s.length();
        if(n == 1) return 1;
        int len = 1, maxLen = Integer.MIN_VALUE;
        while(len<=n){
            Map<String,Integer> map = new HashMap<>();
            for(int i = 0; i<=n-len; i++){
                String substring = s.substring(i,i+len);
                if(map.containsKey(substring)){
                    maxLen = Math.max(maxLen,substring.length());
                }
                map.put(substring,map.getOrDefault(substring,0)+1);
            }
            len++;
        }
        return maxLen == Integer.MIN_VALUE ? -1 : maxLen;
    }

    static int lengthOfStringThatAppearTwice_better(String s){
        int n = s.length();

        for (int len = n - 1; len >= 1; len--) {
            Set<String> set = new HashSet<>();

            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i + len);

                if (set.contains(sub)) {
                    return len; // early exit
                }
                set.add(sub);
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfStringThatAppearTwice_better("banana"));

    }
}
