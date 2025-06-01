package DynamicProgramming;

public class PalindromicPartioning {

    /*
       Problem Description

Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.



Problem Constraints

1 <= length(A) <= 501



Input Format

The first and the only argument contains the string A.



Output Format

Return an integer, representing the minimum cuts needed.



Example Input

Input 1:

 A = "aba"
Input 2:

 A = "aab"


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 "aba" is already a palindrome, so no cuts are needed.
Explanation 2:

 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */


    public static void main(String[] args){
        String A = "aab";
        int n = A.length();
        int[][] palindromeDp = new int[n][n];

        int[] partitionDp = new int[n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                palindromeDp[i][j] = -1;
            }
        }

        for(int i = 0; i<n; i++){
            partitionDp[i] = -1;
        }

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                isPalindorme(i, j, A, palindromeDp);
            }
        }

        for(int i = 0; i<n; i++){
            getMinPartition(A, i, partitionDp, palindromeDp);

        }

        System.out.println(partitionDp[n-1]);
    }


    static int isPalindorme(int i, int j, String A, int[][] dp){
        if(i<0 || j>=A.length()) return 0;

        if(i > j) return 1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == j){
            dp[i][j] = 1;
            return 1;
        }

        if(A.charAt(i) != A.charAt(j)){
            dp[i][j] = 0;
            return 0;
        }
        dp[i][j] = isPalindorme(i+1, j-1, A, dp);
        return dp[i][j];
    }

    static int getMinPartition(String A, int i, int[] partitionDp, int[][] palindromeDp){
        if(i<0 || i>=A.length()) return 0;

        if(partitionDp[i]!= -1) return partitionDp[i];

        if(palindromeDp[0][i] == 1){
            partitionDp[i] = 0;
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for(int j = 1; j<=i; j++){
            if(palindromeDp[j][i] == 1){
                mini = Math.min(mini, 1+getMinPartition(A, j-1, partitionDp, palindromeDp));
            }
        }

        partitionDp[i] = mini;

        return mini;

    }



    // overall time complexity is O(n*n)
    // space complexity O(n*n)

}
