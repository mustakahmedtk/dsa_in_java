package com.collection.DSA_module;

public class RotateArray {
    public static void main(String[] args){
        /*
Problem Description
Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.


Problem Constraints
1 <= N <= 106
1 <= A[i] <=108
1 <= B <= 109


Input Format
There are 2 lines in the input

Line 1: The first number is the size N of the array A. Then N numbers follow which indicate the elements in the array A.

Line 2: A single integer B.


Output Format
Print array A after rotating it B times towards the right.


Example Input
Input 1 :
4 1 2 3 4
2


Example Output
Output 1 :
3 4 1 2
         */
        int[] arr = {1,2,3,4,5};
        int B = 3;
        rotateArray(arr, B);

    }

    static void rotateArray(int[] A, int B){
        // bruteforce approach
        int n = A.length;
        /*
        for(int i = 1; i<=B;i++){
            int firstNumber = A[n-1];
            for(int j = n-1; j>0; j--){
                A[j] = A[j-1];
            }
            A[0] = firstNumber;
        } */
        // brute force approch takes time complexity = O(Bn) and space complexity = O(1);

        // optimized solution using reversal algorithm
        // first step reverse array from 0 to n-1
        reverseArray(A, 0, n-1);
        // 2nd reverseArray from 0 to B-1
        reverseArray(A, 0, B-1);
        // 3rd step reversearray from B to n-1;
        reverseArray(A, B, n-1);
        // reversal algorightm will take time complexity  = O(3n) = O(n) and space complexity = O(1)
        for(int i = 0; i<A.length;i++){
            System.out.println(A[i]);
        }
    }
    static void reverseArray(int[] A, int start, int end){
        while(start<end){
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
