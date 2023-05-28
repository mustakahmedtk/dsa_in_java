package com.collection.DSA_module.HashMap;

import java.util.HashMap;

public class IsDictionary {
    /*
      Problem Description
Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.



Problem Constraints
1 <= N, length of each word <= 105

Sum of the length of all words <= 2 * 106



Input Format
The first argument is a string array A of size N.

The second argument is a string B of size 26, denoting the order.



Output Format
Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.



Example Input
Input 1:

 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:

 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The order shown in string B is: h < s < i for the given words. So return 1.
Explanation 2:

 "none" should be present after "no". Return 0.
     */
    public static void main(String[] args) {
        String[] A1 = {"hello", "scaler", "interviewbit"};
        String B1 = "adhbcfegskjlponmirqtxwuvzy";
        String[] A2 = {"fine", "none", "no"};
        String B2 = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(solve(A1, B1));
    }

    static int solve(String[] A, String B){
        /*
           brute force solution is
          ->  keep the fist index of A1
          -> now itearte over array from 1
          -> on every i , run another loop to check prevString in the order with currentString or not
          -> in brute force , use indexOf method to check in B if the strings are in order or not

         */
        /*
        int n = A.length;
        if(n == 1) return 1;
        int isDictionary = 0;
        String prevS = A[0];
        for(int i = 1; i<n; i++){
            String currentS = A[i];
            int l = prevS.length();
            int m = currentS.length();
            int k = Math.min(l,m);
            int j = 0;
            while(j<k){
                int index1 = B.indexOf(prevS.charAt(j));
                int index2 = B.indexOf(currentS.charAt(j));
                if(index1>index2){
                    return 0;
                }
                else if(index1<index2){
                    isDictionary = 1;
                    break;
                }
                else if((j<k) && (index1 == index2)){
                    j++;
                }

            }
            if(isDictionary == 1){
                if(l>m){
                    return 0;
                }
            }
            prevS = currentS;

        }
        return isDictionary;

         */
        /*
           brute force solution takes O(n^3) time complexity
           and O(1) time complexity

           Optimized approach using  HashMap
           since indexOf takes O(n) time complexity to search a character in String,
           if we store all the characters and their  locations in hashMap, we can fetch the index of the
           character in O(1) time complexity
         */

        int n = A.length;
        if(n == 1) return 1;
        int isDictionary = 0;
        String prevS = A[0];
        // store the B string into hashMap
        HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i<B.length(); i++){
            hm.put(B.charAt(i),i);
        }
        for(int i = 1; i<n; i++){
            String currentS = A[i];
            int l = prevS.length();
            int m = currentS.length();
            int k = Math.min(l,m);
            int j = 0;
            while(j<k){
                int index1 = hm.get(prevS.charAt(j)); // fetch in O(1) time
                int index2 = hm.get(currentS.charAt(j));
                if(index1>index2){
                    return 0;
                }
                else if(index1<index2){
                    isDictionary = 1;
                    break;
                }
                else if((j<k) && (index1 == index2)){
                    j++;
                }

            }
            if(isDictionary == 1){
                if(l>m){
                    return 0;
                }
            }
            prevS = currentS;

        }
        return isDictionary;

        // T.C -> O(n^2)
        // S.C -> O(n)




    }
}
