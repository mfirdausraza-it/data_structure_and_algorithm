package com.codecafe.dsa_pattern.two_pointer;

public class CompareStringAfterBackspace {

    public boolean backspaceCompare(String s, String t) {
        String changeValueOfS = removeCharAfterBackspace(s);
        String changeValueOfT = removeCharAfterBackspace(t);
        return changeValueOfS.equals(changeValueOfT);
    }

    // create a new string by removing the character after backspace
    static String removeCharAfterBackspace(String str){
        int len = str.length(), count = 0;
        StringBuffer sb = new StringBuffer();
        // Iterate through the string character by character
        for(int i = 0; i<len; i++){
            // If the current character is not a backspace,
            // append it to the StringBuffer
            char c = str.charAt(i);
            if( c != '#'){
                sb.append(c);
            }else{
                // If the current character is a backspace,
                // remove the last character from the StringBuffer
                if(!sb.isEmpty())
                    sb.delete(sb.length()-1,sb.length());
            }
        }
        return sb.toString();
    }
}
