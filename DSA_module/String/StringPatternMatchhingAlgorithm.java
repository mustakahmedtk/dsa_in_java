package com.collection.DSA_module;

import java.util.Arrays;

public class StringPatternMatchhingAlgorithm {
    /*
       Given a String
           S = "abab"
           find and count the number of different rotations that gives the original string


           input  = "abab"
           1 -> baba
           2 -> abab
           3 -> baba
           4 -> abab
           clearly see after length time rotations two times the original string string occurs

           output = 2;


     */

    public static void main(String[] args){
        String input  = "abab";
        System.out.println(solve(input));





    }


    static int solve(String s){
        // brute force
        // simply rotate on and compare with original string , if same increase the count
        /*
        for(int i = 1; i<=n;i++){
           char lastval = charArray[charArray.length-1];
           for(int j=charArray.length-1; j>0;j--){
               charArray[j] = charArray[j-1];
           }
           charArray[0] = lastval;
           if(String.valueOf(charArray).equals(s)){
               count++;
            }

        }





     return count;

         */



        // brute force algorithm takes O(N*N) time complexity

        // we can do it better using KMP algorithm

        // we need to find LPS array -> length of longest prefix that is also a suffix


        /*
           // prefix -> substring which is start at index = 0
            // suffix ->  substring which ends at index = n-1;

            prefect prefix -> starts at 0 and  end at index< n-1
            perfect suffix -> end at index n-1 and start at index > 0

            for the given string
            for thumb rule ->
              we need to use delimeter to find out the count of LPS array
              lets suppose
              T  = "abab"
              P = "abab"
              delimeter = "$"
              to find the count of same string after roation
              we need to
              have LPS array of  P + delimeter + (T+T)
              i.e
               abab$abababab


             s:   a b a b $ a b a b a b a b
             LPS: 0 0 1 2 0 1 2 3 4 3 4 3 4

             freq(4 in LPS array) = 3
             we added the input string 1 more time

             x-1
             3-1 = 2





         */

        int count = 0;
        int n = s.length();
        String inputWithDelimeter = s+'$'+s+s;
        char[] charArray = inputWithDelimeter.toCharArray();

        int[] lpsArray = KMPAlgo(charArray);
        System.out.println(Arrays.toString(lpsArray));
        for(int i = 0; i<lpsArray.length; i++){
            if(s.length() == lpsArray[i]) count++;
        }

        return count-1;

        // time complexity of this using KMP algo is O(N)


    }


    static int[] KMPAlgo(char[] charArray){
        int n = charArray.length;
        int[] LPS = new int[n];
        LPS[0] = 0;
        for(int i = 1; i<n; i++){
            int x = LPS[i-1];
            while(charArray[i] != charArray[x]){
                if(x == 0){
                    x = -1;
                    break;
                }
                x = LPS[x-1];
            }
            LPS[i] = x+1;
        }

        return LPS;


    }


}
