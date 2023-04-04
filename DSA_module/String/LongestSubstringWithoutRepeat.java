package com.collection.DSA_module;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    /*
    Problem Description
Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.



Input Format
Single Argument representing string A.



Output Format
Return an integer denoting the maximum possible length of substring without repeating characters.



Example Input
Input 1:

 A = "abcabcbb"
Input 2:

 A = "AaaA"


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 Substring "abc" is the longest substring without repeating characters in string A.
Explanation 2:

 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
     */
    public static void main(String[] args) {
        String input  = "abcabcbb";
        System.out.println(solve(input));

    }

    static int solve(String input){
        // brute force
        int n = input.length();
        int length = 0;
        /*
        String subs;
        for(int i = 0; i<n;i++){
            subs = "";
            for(int j=i; j<n; j++){
                char ch = input.charAt(j);
                if(subs.indexOf(ch)>-1){
                    break;
                }
                subs += ch;
            }
            length = Math.max(length, subs.length());
        }
        return length;

         */

        // since we have two loops (outer and inner ) and indexOf again loops over the characters so the overall
        // time complexity is O(n^3);

        // slightly better approach is to use Hashset to make the lookup of characters in constant time
        /*
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i<n; i++){
            hs.clear();
            for(int j = i; j<n;j++){
                char ch = input.charAt(j);
                if(hs.contains(ch)) break;
                hs.add(ch);
            }
            length = Math.max(length, hs.size());
        }
        return length;

         */
        // this approach takes O(n^2) time complexity and O(n) space complexity

        // optimized approach
        /*
           using hashmap can make character and its position stored and we can detect the previous index of character which
           already occur , by using that we can omit the length that already had and start with the new position

         */
        int maxLength = 0;
        int prevIndex;
        char ch;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i<n; i++){
            ch = input.charAt(i);
            if(hm.containsKey(ch)){
                prevIndex = hm.get(ch);
                length = Math.min(length+1,i-prevIndex);
                hm.put(ch,i);
            }else{
                length++;
                hm.put(ch,i);
            }
            maxLength = Math.max(length, maxLength);

        }
        return maxLength;
        // the overall the time complexity of above approach is O(n)
        // space complexity is O(n)

    }


}
