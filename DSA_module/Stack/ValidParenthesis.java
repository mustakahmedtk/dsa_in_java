package com.collection.DSA_module;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String args[]){
        /*
 Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.
Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[]


Example Output
Output 1:

 1
Output 2:

 0
Output 3:

 1
*/

        String ch = "{()}}";
        System.out.println(isValidParenthesis(ch));

    }
    public static Boolean isValidParenthesis(String parenthesis){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Stack<Character> st = new Stack<Character>();
        char[] arr = parenthesis.toCharArray();
        map.put(')', '(');
        map.put('}','{');
        map.put(']', '[');
             for(int i = 0; i<arr.length; i++){
                 if(!st.isEmpty() && (map.get(arr[i]) == st.peek())){
                     st.pop();
                 }else{
                     st.push(arr[i]);
                 }
             }
        System.out.println(st);
             if(st.size() == 0){
                 return true;
             }
             return false;
    }
}
