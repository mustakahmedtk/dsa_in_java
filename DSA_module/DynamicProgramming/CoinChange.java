package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    /*
       Problem Description

You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).


Problem Constraints

1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format

First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format

Return an integer denoting the number of ways.



Example Input

Input 1:

 A = [1, 2, 3]
 B = 4
Input 2:

 A = [10]
 B = 10


Example Output

Output 1:

 4
Output 2:

 1


Example Explanation

Explanation 1:

 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}
Explanation 2:

 There is only 1 way to make sum 10.

     */

    public static void main(String[] args){
        int[] coins = {1, 2, 3};
        int sum = 4;
        int n = coins.length;

        int[][] dp = new int[sum+1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ways = bootomUp(sum, coins);//topDown(sum, n - 1, coins, dp);
        System.out.println(ways);

    }



    static int topDown(int sum, int coinIndex, int[] coins, int[][] dp){
        if(coinIndex<0) return 0;
        if(sum == 0){
            return 1;
        }
        if(dp[sum][coinIndex]!= -1){
            return dp[sum][coinIndex];
        }

        dp[sum][coinIndex] = (sum-coins[coinIndex] >=0 ? topDown(sum-coins[coinIndex], coinIndex, coins, dp) : 0)+
                (topDown(sum, coinIndex-1, coins, dp));

        return dp[sum][coinIndex];
    }


    static int bootomUp(int sum, int[] coins){
        int n = coins.length;
        if(sum == 0) return 1;
        int[][] dp = new int[sum+1][n];

        for(int j = 0; j<n; j++){
            dp[0][j] = 1;
        }

        for(int i = 0; i<=sum; i++){
            if(i%coins[0] == 0){
                dp[i][0] = 1;
            }else{
                dp[i][0] = 0;
            }
        }

        for(int i = 1; i<=sum; i++){
            for(int j = 1; j<n; j++){
                dp[i][j] = ((i-coins[j]>=0 ? dp[i-coins[j]][j]: 0)+dp[i][j-1]);
            }
        }

        return (dp[sum][n-1]);

    }



    /*
       overall T.C is

       T.C = O(sum * coins)
     */





}
