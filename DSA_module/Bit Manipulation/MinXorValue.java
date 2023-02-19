package com.collection.DSA_module;

import java.util.ArrayList;
import java.util.Arrays;

public class MinXorValue {
    /*
     Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer denoting minimum xor value.



Example Input
Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output
Output 1:

 2
Output 2:

 3

     */
    public static void main(String[] args){
        int[] input = {0, 2, 5, 7};
        System.out.println(solve(input));

    }

    static int solve(int[] A){
        int n = A.length;
        int minXOR = Integer.MAX_VALUE;
        // brute force approach
        // simply iterate over the array and find minXOR
        /*
        for(int i = 0; i<n;i++){
            for(int j = i+1; j<n;j++){
                minXOR = Math.min(minXOR, (A[i]^A[j]));
            }
        }
        return minXOR;

         */
        // the Time complexity of this approach is O(N*N) and space complexity is O(1);

        // omtimized approach
        // sort the array
        // iterate once and check the adjacent element ^ and keep upadting minimum
        Arrays.sort(A); // which will take nlogn time complexity
        for(int i = 0; i<n-1;i++){
            minXOR = Math.min(minXOR, (A[i]^A[i+1]));
        }
        return minXOR;
        // the overall time complexity of this approach is O(nlogn) and space complexity is O(1);


    }
}
