package com.collection.DSA_module;

public class LongestCommonPrefix {
    /*
     Problem Description
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
     */
    public static void main(String[] args){
        String[] input = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(solve(input));

    }


    static String solve(String[] A){

        int n = A.length;
        String prefix = A[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<n; i++){
            prefix = commonPrefix(prefix, A[i], sb);
        }
        return prefix;
        // the time complexity is O(n*n)
        // the space complexity is O(n)

    }

    static String commonPrefix(String s1, String s2, StringBuilder sb){
        int l1 = 0;
        int l2 = 0;
        // clearing out the stringBuilder to have new prefix
        sb.setLength(0);
        while(l1<s1.length() && l2<s2.length()){
            if(s1.charAt(l1)!=s2.charAt(l2)) break;
            sb.append(s1.charAt(l1));
            l1++;
            l2++;
        }
        return sb.toString();
    }
}
