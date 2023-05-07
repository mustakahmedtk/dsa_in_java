package com.collection.DSA_module.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
       Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.



Problem Constraints
-108 <= B <= 108
1 <= N <= 104
-108 <= A[i] <= 108


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.



Output Format
Return a single integer denoting the sum of three integers which is closest to B.



Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:


A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6.
     */

    public static void main(String[] args) {
        int[] input = {-1, 2, 1, -4};
        int B = 1;
        System.out.println(solve(input, B));
    }

    static int solve(int[] input, int B){
        /*
           brute force approach
            -> sort the array
            -> simply iterate over the array using three loops and find out the closest sum
         */
        int n = input.length;
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(input);
        /*
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    int sum = input[i]+input[j]+input[k];
                    if(Math.abs(sum-B)<Math.abs(closestSum-B)){
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;

         */
        /*
           Time complexity of this approach is O(n^3);

           better approach using two pointers

         */
        for(int i = 0; i<n-1; i++){
            int p1 = i+1;
            int p2 = n-1;
            while(p1<p2){
                int sum = input[i]+input[p1]+input[p2];
                if(Math.abs(sum-B)<Math.abs(closestSum-B)){
                    closestSum = sum;
                }
                if(sum<B){
                    p1++;
                }else{
                    p2--;
                }
            }
        }
        return closestSum;

        // time complexity of this approach is O(n^2);

    }
}
