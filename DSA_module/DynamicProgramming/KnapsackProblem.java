package DynamicProgramming;

public class KnapsackProblem {

    /*
      Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints

1 <= N <= 500

1 <= C, B[i] <= 106

1 <= A[i] <= 50



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.



Example Input

Input 1:

 A = [6, 10, 12]
 B = [10, 20, 30]
 C = 50
Input 2:

 A = [1, 3, 2, 4]
 B = [12, 13, 15, 19]
 C = 10


Example Output

Output 1:

 22
Output 2:

 0


Example Explanation

Explanation 1:

 Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
Explanation 2:

 Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
     */

    public static void main(String[] args){

       int[] A = {6, 10, 12};
       int[] B = {10, 20, 30};
       int C = 50;

       int n = A.length;

       int[][] dp = new int[n][C+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                dp[i][j] = -1;
            }
        }

       int result   = bottomUp(A,B,C); //maxKnapSack(A, B, C, dp, n-1);
       System.out.println(result);


    }


    static int maxKnapSack(int[] val, int[] wg, int c, int[][] dp, int i){
        if (i < 0 || c <= 0) {
            return 0;
        }

        if(dp[i][c] != -1) return dp[i][c];

        if(i == 0){
            if(c == wg[i]){
                dp[i][c] = val[i];
                return val[i];
            }else{
                dp[i][c] = 0;
                return 0;
            }
        }


        int include = Integer.MIN_VALUE;
        if(wg[i]<= c){
            include = val[i] + maxKnapSack(val, wg, c-wg[i], dp, i-1);
        }
        int exclude = maxKnapSack(val, wg, c, dp, i-1);

        dp[i][c] = Math.max(include, exclude);

        return dp[i][c];

    }

    /*
        T.C = O(n*c) = psuodo polinomial

        S.C = O(n*c)
     */


    static int bottomUp(int[] A, int[] B, int C){
        int n = A.length;
        int[] dp = new int[C + 1];

        for (int i = 0; i < n; i++) {
            for (int j = C; j >= B[i]; j--) {
                dp[j] = Math.max(dp[j], A[i] + dp[j - B[i]]);
            }
        }

        return dp[C];
    }


    /*
       in bottom up the space complexity reduced drastically from O(n*c) to

       O(c)

       T.C remains same

       O(n*c)


     */





}
