package com.collection.DSA_module.GreedyAlgorithm;

public class DistributeCandies {
    /*
Problem Description
N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109



Input Format
The first and only argument is an integer array A representing the rating of children.



Output Format
Return an integer representing the minimum candies to be given.



Example Input
Input 1:

 A = [1, 2]
Input 2:

 A = [1, 5, 2, 1]


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:

 Candies given = [1, 3, 2, 1]
     */

    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1};
        System.out.println(solve(A));

    }

    static int solve(int[] A){
        int n = A.length;
        int[] leftCandies = new int[n];
        int[] rightCandies = new int[n];
        int maxCandies = 0;
        leftCandies[0] = 1;
        rightCandies[n-1] = 1;
        // min left candies
        for(int i = 1; i<n;i++){
            if(A[i]>A[i-1]){
                leftCandies[i] = leftCandies[i-1]+1;
            }else{
                leftCandies[i] = 1;
            }

        }
        // min right candies
        for(int i = n-2; i>=0;i--){
            if(A[i]>A[i+1]){
                rightCandies[i] = rightCandies[i+1]+1;
            }else{
                rightCandies[i] = 1;
            }
        }
        // find max of two caindies and store the sum

        for(int i = 0; i<n; i++){
            maxCandies += (Math.max(leftCandies[i],rightCandies[i]));
        }
        return maxCandies;


        /*
          T.C --> O(N)
          S.C --> O(N)
         */

    }
}
