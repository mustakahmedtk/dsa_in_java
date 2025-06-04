package DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelope {

    /*
       Problem Description

Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.



Problem Constraints

1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109



Input Format

The only argument given is the integer matrix A.



Output Format

Return an integer denoting the maximum number of envelopes you can put one inside other.



Example Input

Input 1:

 A = [
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]
     ]
Input 2:

 A = [     '
         [8, 9]
         [8, 18]
     ]


Example Output

Output 1:

 3
Output 2:

 1


Example Explanation

Explanation 1:

 Step 1: put [2, 3] inside [5, 4]
 Step 2: put [5, 4] inside [6, 7]
 3 envelopes can be put one inside other.
Explanation 2:

 No envelopes can be put inside any other so answer is 1.
     */


    public static void main(String[] args) {

        int[][] A = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        int n = A.length;

        Arrays.sort(A, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] widths = new int[n];
        for (int i = 0; i < n; i++) {
            widths[i] = A[i][1];
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int maxEnvelope = 0;
        for (int i = 0; i < n; i++) {
            maxEnvelope = Math.max(maxEnvelope, LIS(widths, dp, i));
        }

        System.out.println(maxEnvelope);


    }

    static int LIS(int[] input, int[] dp, int i) {
        if (dp[i] != -1) return dp[i];

        int max = 1;

        for (int j = 0; j < i; j++) {
            if (input[i] > input[j]) {
                max = Math.max(max, 1 + LIS(input, dp, j));
            }
        }

        dp[i] = max;
        return dp[i];
    }

}
