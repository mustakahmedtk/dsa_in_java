package com.collection.DSA_module;

public class RainWaterTrapped {
    /*

    Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A



Output Format
Return one integer, the answer to the question



Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

1 unit is trapped on top of the 3rd element.
Explanation 2:

No water is trapped.
     */
    public static void main(String[] args){
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("maximum water trapped"+" "+solve(input));


    }

    static int solve(int[] A){
        int minWater = 0;
        int n = A.length;
        // brute force approach to
        /*
        for(int i = 1; i<n-1; i++){
            int leftmax = 0, rightMax = 0;
            // calculate left max
            for(int j = i; j>=0;j--){
                leftmax = Math.max(leftmax,A[j]);
            }
            // calculate right max
            for(int j = i; j<n;j++){
                rightMax = Math.max(rightMax, A[j]);
            }
            // sum the minimum water
            minWater += Math.min(leftmax,rightMax) - A[i];
        }

         */

        // optimized approach
        // we can carry forward the leftMax and rightMax
        // boiled information of leftmax and rightmax will reduce time complexity to O(n) and space complexity O(n)

        int[] leftmax = new int[n];
        int[] rightMax = new int[n];
        leftmax[0] = A[0];
        rightMax[n-1] = A[n-1];
        // boiled information
        for(int i = 1; i<n; i++){
            leftmax[i] = Math.max(leftmax[i-1], A[i]);
        }

        for(int i = n-2; i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], A[i]);
        }

        for(int i = 1; i<n-1;i++){
            minWater +=Math.min(rightMax[i], leftmax[i]) - A[i];
        }

        return minWater;

    }
}
