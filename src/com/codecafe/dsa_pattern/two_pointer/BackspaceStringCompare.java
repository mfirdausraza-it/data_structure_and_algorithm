package com.codecafe.dsa_pattern.two_pointer;

public class BackspaceStringCompare {
	
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            // Find next valid character in s
            int skipS = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            // Find next valid character in t
            int skipT = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            // Compare characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                // One string ended before the other
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c")); // true
		System.out.println(backspaceCompare("ab##", "c#d#")); // true
		System.out.println(backspaceCompare("a#c", "b"));     // false
		System.out.println(backspaceCompare("a##c", "#a#c")); // true
		System.out.println(backspaceCompare("bxj##tw", "bxo#j##tw")); // true
	}

}
