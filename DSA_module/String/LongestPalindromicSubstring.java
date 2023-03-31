package com.collection.DSA_module;

public class LongestPalindromicSubstring {
    /*
     Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the longest palindromic substring of string A.



Example Input
Input 1:
A = "aaaabaaa"
Input 2:
A = "abba


Example Output
Output 1:
"aaabaaa"
Output 2:
"abba"


Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
     */

    public static void main(String[] args){
        String input1 = "aaaabaaa";
        String input2 = "abba";
        System.out.println(solve(input2));


    }

    static String solve(String A){
        // brute force solution
        int length = Integer.MIN_VALUE;
        String lp = "";

        int n = A.length();
        /*
        for(int i = 0; i<n; i++){
            String aux = "";
            for(int j = i; j<n;j++){
                aux +=A.charAt(j);
                if(aux.length()>length && aux.equals(reverse(aux))){
                    length = aux.length();
                    lp = aux;
                }

            }

        }
        return lp;

         */


        // brute force solution takes O(n^3) time complexity which is quite huge
        // optimized approach
        /*
          lets see the input
          input= "aaaabaaa";
          looking at the input , we can say , every single character of a string is itself a Palindrome.
          So  if a character k is palindrome and k-1 and k+1 are also equal then we can 100% surely say
          the characters from k-1 to k+1 are palindrome

          So the Idea is if we can take a character as mid point and try to expand its range around the corner
          and every iteration if we check there neighbours are equal or not
          hence we can find longest palindromic substring.


         */

        // lets take start and end point
        int start = 0;
        int end  = 0;
        for(int mid = 0; mid<n;mid++){
                start = mid;
                end = mid;
            // case 1 when mid is on character
            String p1 = expandAround(A, start, end);
            if(p1.length()>lp.length()){
                lp = p1;
            }
            // case 2 when mid is in between character
            String p2 = expandAround(A, start, end+1);
            if(p2.length()>lp.length()){
                lp = p2;
            }

        }
        return lp;

        // overall time complexity of this approach is O(n^2)
        // space complexity is O(n);

    }

    static String expandAround(String A, int start, int end){
        while(start>=0 && end<A.length() && (A.charAt(start) == A.charAt(end))){
            start--;
            end++;
        }
        return A.substring(start+1, end);

    }
    /*static String reverse(String s){
        if(s.length() == 1) return s;
        String reversed = "";
        for(int i = s.length()-1; i>=0;i--){
            reversed += s.charAt(i);
        }
        return reversed;
    }

     */
}
