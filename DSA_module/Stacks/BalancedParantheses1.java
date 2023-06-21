package com.collection.DSA_module.Stacks;

import java.util.Stack;

public class BalancedParantheses1 {
    /*
       Problem Description
Given a string A consisting only of '(' and ')'.

You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
First argument is an string A.



Output Format
Return 1 if parantheses in string are balanced else return 0.



Example Input
Input 1:

 A = "(()())"
Input 2:

 A = "(()"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Given string is balanced so we return 1.
Explanation 2:

 Given string is not balanced so we return 0.
     */

    public static void main(String[] args) {
        String input1 = "(()())";
        String input2 = "(()";
        System.out.println(solve(input2));
    }

    static int solve(String input){
        /*
          we can use stack to solve this problem ,
          -> keep pushing ( into stack
          -> pop out if you find ) in stack
          -> at last if the stack size is 0 then string is balanced
         */
        int n = input.length();
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i<n;i++){
            char ch = input.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else if(ch == ')' && st.size()>0){
                st.pop();
            }else{
                return 0;
            }
        }
        return st.size() == 0 ? 1: 0;

        /*
           T.C --> O(n)
           S.C ---> O(n)
         */

    }

}
