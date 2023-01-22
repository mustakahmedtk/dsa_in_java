package com.collection.DSA_module;

import java.util.HashSet;

public class RowToColumnZero {
    /*
    Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.



Problem Constraints
1 <= A.size() <= 103

1 <= A[i].size() <= 103

0 <= A[i][j] <= 103



Input Format
First argument is a vector of vector of integers.(2D matrix).



Output Format
Return a vector of vector after doing required operations.



Example Input
Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]


Example Output
Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]
     */
    public static void main(String[] args){
        int[][] input = {
                {1,2,3,4},
                {5,6,7,0},
                {9,2,0,4}

                        };
        solve(input);
        for(int i = 0; i<input.length; i++){
            for(int j = 0; j<input[0].length;j++){
                System.out.print(input[i][j]);
            }
            System.out.println("");

        }

    }

    static void solve(int[][] A){
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();
        int n = A.length;
        int m = A[0].length;
        // momoizing the row and column with 0 value
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(A[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }

            }
        }
        // setting value 0 to rows and column if found
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(A[i][j] !=0 && (rows.contains(i) || cols.contains(j))){
                    A[i][j] = 0;
                }
            }
        }

        // overall time complexity is O(nm);
        // space complexity is O(n+m);

    }

}
