package com.codecafe.dsa_pattern.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class CheckForAllCode {
    public static boolean hasAllCodes_I(String s, int k) {
        Set<String> set = uniqueSubString(s,k);
        return set.size() == 1<<k;
    }

    static Set<String> uniqueSubString(String s, int k){
        Set<String> set = new HashSet<>();
        for(int i = 0; i<s.length()-k+1; i++){
            String s1 = s.substring(i, i + k);
            System.out.println(s1);
            set.add(s1);
        }
        System.out.println(set);
        return set;
    }

    public static boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int req = 1 << k;
        int mask = req - 1;
        int hash = 0;
        boolean[] seen = new boolean[req];
        for(int i = 0; i<n; i++){
            System.out.println("hash << 1 :: " + (hash << 1));
            System.out.println("((hash << 1) & mask) :: " + ((hash << 1) & mask));
            System.out.println("((hash << 1) & mask) | (s.charAt(i) - '0') :: " + (((hash << 1) & mask) | (s.charAt(i) - '0')));
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');
            if(i >= k-1 && !seen[hash]){
                seen[hash] = true;
                req--;
                if(req == 0) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "00110110";
        System.out.println(hasAllCodes(s,2));
    }
}
