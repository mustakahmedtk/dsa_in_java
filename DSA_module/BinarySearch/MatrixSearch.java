package com.collection.DSA_module.BinarySearch;

public class MatrixSearch {
    /*
       Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format
Return 1 if B is present in A else, return 0.



Example Input
Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.
     */

    public static void main(String[] args) {
        int[][] input = {
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
                };
        int target = 30;
        System.out.println(solve(input, target));
    }


    static int solve(int[][] input, int target){
        /*
           the brute force approach is simply iterating over every row and find out if the target exist or not
           since the the matrix is  n*m , the time complexity is O(n*m)

           lets think about better approach

           since every row is sorted and
           The first integer of each row is greater than or equal to the last integer of the previous row.
           we can start our search from top right corner i = 0, and j = m-1
           we will be keep moving until we can target
           if input[i][j]>target we will move to left element by reducing j--
           if  input [i][j]<target we will move to downward element by  increasing i++;

         */
        int n = input.length;
        int m = input[0].length;
        int i = 0, j = m-1; // top right corner
        while(i<n && j>=0){
            if(input[i][j] == target){
                return 1;
            }
            else if(input[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return 0;
        // the overall time complexity of this approach is O(n+m);
    }



}
