package com.collection.DSA_module.Stacks;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParantheses2 {
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


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
     */

    public static void main(String[] args) {
        String input1 = "{([])}";
        String input2 = "(){";
        System.out.println(solve(input2));
    }

    static int solve(String A){
        int n = A.length();
        HashMap<Character,Character> hm = new HashMap<Character, Character>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i<n; i++){
            char ch = A.charAt(i);
            if(st.size()>0 && hm.get(ch) == st.peek()){
                st.pop();
            }else{
                st.push(ch);
            }

        }

        return st.size() == 0 ? 1: 0;

        /*
          T.C --> O(n)
          S.C --> O(n)
         */


    }
}
