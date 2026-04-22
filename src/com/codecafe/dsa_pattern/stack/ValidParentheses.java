package com.codecafe.dsa_pattern.stack;


import java.util.Stack;

public class ValidParentheses {

    //https://leetcode.com/problems/valid-parentheses/

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']'
     * determine if the input string is valid.
     */
    public static boolean isValid_Optimal(String s) {

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            // If it's an opening bracket, push it onto the stack
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                // If it's a closing bracket, check if the stack is empty or if the top doesn't match
                if(stack.isEmpty()) return false;
                // Pop the top element from the stack
                char top = stack.pop();
                // If the closing bracket doesn't match the corresponding opening bracket, return false
                if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                    return false;
                }
            }
        }
        // If the stack is empty at the end, all brackets are matched; otherwise, return false
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid_Optimal(s));
    }
}
