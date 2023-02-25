package com.collection.DSA_module;

public class changeCharacter {
    /*
    Problem Description
You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
The first argument is a string A.

The second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
     */
    public static void main(String[] args){
        String input = "abcabbccd";
        int B = 3;
        System.out.println(solve(input, B));

    }

    static int solve(String A, int B){
        // create a character count frequency array
        int n = A.length();
        int[] charCount = new int[26];
        // the add the frequency
        for(int i = 0; i<n;i++){
            int index = A.charAt(i)-97;
            charCount[index]++;
        }
        // iterate until B == 0 and remove less non repeating characters

        while(B>0){
            int min = Integer.MAX_VALUE;
            int minIndex = Integer.MAX_VALUE;
            for(int i = 0; i<26;i++){
                if(charCount[i]>0){
                    if(charCount[i]<min){
                        min = charCount[i];
                        minIndex = i;
                    }
                }
            }
            charCount[minIndex]--;
            B--;
        }

        // iterate over the charCount array to find the remaining characters
        int count = 0;
        for(int i= 0; i<26; i++){
            if(charCount[i]>0) count++;
        }
        return count;

        // time overall time complexity is O(n)
        // space complexity is O(26)-> which is indeed O(1)





    }
}
