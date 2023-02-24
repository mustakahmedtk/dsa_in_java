package com.collection.DSA_module;

public class ReverseString {
    /*
    Problem Description
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105



Input Format
The only argument given is string A.



Output Format
Return the string A after reversing the string word by word.



Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"


Example Explanation
Explanation 1:
    We reverse the string word by word so the string becomes "blue is sky the".
Explanation 2:
    We reverse the string word by word so the string becomes "ib is this".
     */
    public static void main(String[] args){
        String input  = "the sky is blue";
        System.out.println(solve(input));

    }

    static String solve(String A){
        StringBuilder sb = new StringBuilder(A);
        int n = A.length();
        int left = 0;
        int right = n-1;
        reverse(sb, left, right);
        int start = 0;
        int endPoint = n-1;

        for(int i = 0; i<n; i++){
            if(sb.charAt(i) == ' '){
                endPoint = i-1;
                reverse(sb, start,endPoint);
                start = i+1;
                endPoint = n-1;
            }

        }
        reverse(sb,start,endPoint);

        return sb.toString().trim();
        // time complexity of this approach is O(n)
        // space complexity of this approach is O(n)



    }

    static void reverse(StringBuilder A, int l, int r){
        while(l<r){
            char temp = A.charAt(l);
            A.setCharAt(l,A.charAt(r));
            A.setCharAt(r,temp);
            l++;
            r--;
        }

    }
}
