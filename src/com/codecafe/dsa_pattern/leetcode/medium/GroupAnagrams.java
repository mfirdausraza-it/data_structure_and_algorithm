package com.codecafe.dsa_pattern.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        if(n == 1){
            result.add(List.of(strs[0]));
            return result;
        }

        //iterator over the array
        Map<String, List<String>> freq = new HashMap<>();
        for(String s : strs){
            int[] freqOfChar = charFreq(s);
            String key = buildStringFromFreq(freqOfChar);
            if(freq.containsKey(key)){
                List<String> list = freq.get(key);
                list.add(s);
                freq.put(key,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                freq.put(key,list);
            }
        }
        result.addAll(freq.values());
        return result;
    }

    static int[] charFreq(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }

    static String buildStringFromFreq(int[] freq){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26; i++){
            if(freq[i] > 0){
                sb.append((char)(i+'a')).append(freq[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

    }
}
