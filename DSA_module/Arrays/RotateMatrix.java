package com.collection.DSA_module;

public class RotateMatrix {
    public static void main(String[] args){
        /*
        Problem Description
You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints
1 <= n <= 1000



Input Format
First argument is a 2D matrix A of integers



Output Format
Return the 2D rotated matrix.



Example Input
Input 1:

 [
    [1, 2, 3],
    [3, 4, 5],
    [6, 7, 8]
 ]
Input 2:

 [
    [1]
 ]




Example Output
Output 1:

 [
    [6, 3 ,1],
    [7, 4, 2],
    [8, 5, 3]
 ]
Output 2:

 [
    [1]
 ]
         */
        int[][] input1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrixBy90Degree(input1);
        for(int i = 0; i<input1.length; i++){
            for(int j = 0; j<input1[0].length; j++){
                System.out.print(input1[i][j]);
            }
            System.out.println("");
        }
    }

    static void rotateMatrixBy90Degree(int[][] A){
        // approach to rotate a matrix by 90 degree
        //  find transpose of a matrix
        transposeOfMatrix(A);
        // swap cols from 0 to n-1
        int left = 0, right = A[0].length-1;
        while(left<right){
            for(int i = 0; i<A.length; i++){
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
            }
            left++;
            right--;
        }
        // overall time complexity is O(n*m) and space complexity is O(1) since its done in place
    }
    static void transposeOfMatrix(int[][] A){
        for(int i = 0; i<A.length;i++){
            for(int j = i+1;j<A[0].length;j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }

}
