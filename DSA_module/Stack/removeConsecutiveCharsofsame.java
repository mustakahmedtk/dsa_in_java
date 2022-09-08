package com.collection.DSA_module;

import java.util.Stack;

public class removeConsecutiveCharsofsame {
    public static void main(String args[]){
        /*
        * Problem Description
You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is string A.



Output Format
Return the final string.



Example Input
Input 1:

 A = abccbc
Input 2:

 A = ab


Example Output
Output 1:

 "ac"
Output 2:

 "ab"
        *
        * */

        String ch = "abccbc";
        System.out.println(removeSameoccuranceofConsecutiveChars(ch));
    }

    public static String removeSameoccuranceofConsecutiveChars(String A){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<A.length();i++){
            if(!stack.isEmpty() && stack.peek() == A.charAt(i)){
                stack.pop();
            }else{
                stack.push(A.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            if(sb.length() == 0){
                sb.append(stack.pop());
            }else{
                sb.insert(0,stack.pop());
            }
        }
        return sb.toString();
    }
}
