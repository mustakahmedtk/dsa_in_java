package DynamicProgramming;

public class LongestCommonSubsequence {
    /*
       Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
     */

    public static void main(String[] args){

        String s1 = "abcde";
        String s2 = "ace";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        int result = lcs(n-1, m-1, dp, s1, s2);

        System.out.println(result);


    }

    static int lcs(int i, int j, int[][] dp, String s1, String s2){


        /*
           element of choice

              dp[i][j] = between s1(0 -> i) and s2(0-> j)

              if  both the ith and jth element matches then we can add
              1+LCS(i-1, j-1) , piggy back on prev problem
              else
              we have explore all the states where

              LCS(i-1, j-1)
              LCS(i, j-1)
              LCS(i-1, j)

              then maximum of(LCS(i-1, j-1), LCS(i, j-1),LCS(i-1, j))

              final result will be DP[n-1][m-1]



         */

        if(i<0 || j<0 || i>=s1.length() || j>=s2.length()){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // base case
        if(i == 0 && j == 0){
            if(s1.charAt(i) == s2.charAt(j)){
                dp[i][j] = 1;
                return 1;
            }else{
                dp[i][j] = 0;
                return 0;
            }

        }

        // rec rel

        if(s1.charAt(i) == s2.charAt(j)){
            return (1+lcs(i-1, j-1, dp, s1, s2));
        }else{
            int max = -1;
            max = Math.max(max, lcs(i-1, j-1, dp, s1, s2));
            max = Math.max(max, lcs(i, j-1, dp, s1, s2));
            max = Math.max(max, lcs(i-1, j, dp, s1, s2));
            dp[i][j] = max;
            return max;
        }
    }

    /*
       T.C = O(nm)
       S.C = O(nm)
     */
}
