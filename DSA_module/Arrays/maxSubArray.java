package com.collection.DSA_module;

public class maxSubArray {

    public static void main(String[] args){
        /*
        Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10]
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]


Example Output
Output 1:

 10
Output 2:

 6
         */

        int[] input1 = {1, 2, 3, 4, -10};
        int[] input2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxContigeousSubArraySum(input2)+"maxSubArray sum");
        

    }

    static int findMaxContigeousSubArraySum(int[] A){
        // brute force approach
        int bigSum = 0;
       /* for(int i = 0; i<A.length; i++){
            int sum = 0;
            for(int j = i; j<A.length;j++){
                sum += A[j];
                if(sum>bigSum){
                    bigSum = sum;
                }
            }
        }

        */
        // brute force approach takes O(n*n) time complexity and O(1) space complexity .

        // optimized approach using  kadane's algorithm
        //  with general sum , we need to set sum as 0 if we get negative;
        int sum = 0;
        for(int i = 0; i<A.length; i++){
            sum +=A[i];
            if(sum>bigSum){
                bigSum = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return bigSum;
    }

    // with optimized kadane's algo , now the time complexity is O(n);


}
