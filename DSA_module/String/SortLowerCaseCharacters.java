package com.collection.DSA_module;

import java.util.Arrays;

public class SortLowerCaseCharacters {
    /*
       Given a String of lower case characters S = "dabaedb", sort the character in thier alphabetical order
       as ouput  = "aabbdde"
     */

    public static void main(String[] args){
        String input  = "dabaedb";
        System.out.println(solve(input));
    }

    static String solve(String A){
        int n = A.length();
        // bruteforce way
        /*
        char[] sarr = new char[n];
        for(int i = 0; i<n;i++){
            sarr[i] = A.charAt(i);
        }
        Arrays.sort(sarr);
        return Arrays.toString(sarr);

         */



        // time complexity of this approach is O(nlogn) since we are using naive sorting
        // space complexity is O(n);

        // optimized approach using count sort
        // create a count array
        // count all the elements and set the frequncy in count array
        // now we can iterate over the count array and create new string using SB
        // since all the characters are in lower case , we can thing of using ASCII value to represent the countarr index
        // 'a'-97 = 0
        // 'b'-97 = 1
        //   .      .
        //   .      .
        //  'z'-97= 25
        char[] countarr = new char[26];
        for(int i = 0; i<n;i++){
            int index = A.charAt(i)-97;
            countarr[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26;i++){
            int count = countarr[i];
            for(int j = 0; j<count;j++){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
        // the time complexity of this approach is O(n)
        // and space complexity is O(n) since we are using stringBuilder

    }
}
