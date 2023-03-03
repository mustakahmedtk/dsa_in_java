package com.collection.DSA_module;

public class PatternMatching {
    /*
       Given a text as S = "abcdabca" and a pattern p = "abc"
       count the number of times the pattern is repeating in given string;
       where size of s is >> size of p
     */

    public static void main(String[] args){

        String s = "abcdabca";
        String pattern = "abc";
        System.out.println(solve(s,pattern));

    }

    static int  solve(String s, String p){
        // we can use sliding window technique to solve this problem
        int n = s.length();
        int k = p.length();
        int count = 0;
        for(int i = 0; i<n-k+1; i++){
            int localCount = 0;
            for(int j = 0; j<k; j++){
                if(s.charAt(i+j) != p.charAt(j)) break;
                localCount++;

            }
            if(localCount == k) count++;
        }
        return count;

        // The time complexity of this approach is O(n*k) and
        // space complexity is  O(1);




    }
}
