package com.collection.DSA_module;

public class SubmatrixSumQueries {
    /*
    Problem Description
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
Sum may be large, so return the answer mod 109 + 7.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer array B.
The third argument given is the integer array C.
The fourth argument given is the integer array D.
The fifth argument given is the integer array E.
(B[i], C[i]) represents the top left corner of the i'th query.
(D[i], E[i]) represents the bottom right corner of the i'th query.



Output Format
Return an integer array containing the submatrix sum for each query.



Example Input
Input 1:

 A = [   [1, 2, 3]
         [4, 5, 6]
         [7, 8, 9]   ]
 B = [1, 2]
 C = [1, 2]
 D = [2, 3]
 E = [2, 3]
Input 2:

 A = [   [5, 17, 100, 11]
         [0, 0,  2,   8]    ]
 B = [1, 1]
 C = [1, 4]
 D = [2, 2]
 E = [2, 4]


Example Output
Output 1:

 [12, 28]
Output 2:

 [22, 19]

     */

    public static void main(String[] args){
        int[][] input1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
               };
        // queries
         int[] B = {1,2};
         int[] C = {1,2};
         int[] D = {2,3};
         int[] E = {2,3};
         int[] result = solve(input1, B,C,D,E);
         for(int i = 0; i<result.length; i++){
             System.out.println(result[i]);
         }



    }


    static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E){
        int n = A.length;
        int m = A[0].length;
        int queryLength = B.length;
        int[] result  = new int[queryLength];
        // brute force solution
        // simply iterate over the query from top left i.e (b,c) and bottom right i.e (d,e)
        // on every query we will find the sum
        /*
        int index = 0;
        while(index<queryLength){
            int sum = 0;
            int i = B[index]-1, j= C[index]-1, k = D[index]-1, l = E[index]-1;
            for(int a = i; a<=k;a++){
                for(int b = j; b<=l;b++){
                    sum += A[a][b];

                }
            }
            result[index] = sum;
            index++;
        }
        // brute force solution takes time complexity as O(qnm) , where q is the no of query
         */
        // optimized approach
        // we can reduce the time if we can keep the boiled information of sum
        // to  keep boiled information , we can use prefix sum technique
        // which will reduce the querying time
        int[][] prefixSum = findPrefixSumOfMatrix(A, n, m);
        int index = 0;
        while(index<queryLength){
            int sum = 0;
            int i = B[index]-1, j= C[index]-1, k = D[index]-1, l = E[index]-1;
            if(i>0 && j>0){
                sum = (prefixSum[k][l] - prefixSum[k][j-1]-prefixSum[i-1][l]) + prefixSum[i-1][j-1];
            }
            else if(i>0 && j == 0){
                sum = prefixSum[k][l]-prefixSum[i-1][l];
            }else if(j>0 && i == 0){
                sum = prefixSum[k][l] - prefixSum[k][j-1];
            }else{
                sum = prefixSum[k][l];
            }
            result[index] = sum;
            index++;
        }
        // overall time complexity of this approach is O(q+nm);
        // and space complexity is O(nm); -> for storing prefix sum
        return result;


    }

    static int[][] findPrefixSumOfMatrix(int[][] A, int n, int m){
        int[][] prefixSum = new int[n][m];
        prefixSum[0][0] = A[0][0];
        // first row sum
        for(int j = 1; j<m; j++){
            prefixSum[0][j] = A[0][j] + prefixSum[0][j-1];
        }
        // first col sum
        for(int i = 1;i<n; i++){
            prefixSum[i][0] = A[i][0] + prefixSum[i-1][0];
        }

        // now we can do aggregrate sum
        for(int i = 1; i<n; i++){
            for(int j = 1 ; j<m; j++){
                prefixSum[i][j] = (A[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1])-prefixSum[i-1][j-1];
            }
        }

        return prefixSum;

    }


}
