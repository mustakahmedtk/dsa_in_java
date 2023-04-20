package com.collection.DSA_module.BinarySearch;

public class PeakElement {
    /*
    Problem Description
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
     */

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int[] input2 = {5, 17, 100, 11};
        System.out.println(solve(input1));


    }

    static int solve(int[] input){
        /*
          brute force approach

         */
        int n = input.length;
        if(n == 1) return input[0];
        if(input[0]>input[1]) return input[0];
        if(input[n-1]>input[n-2]) return input[n-1];
        /*
        for(int i = 1; i<n-1; i++){
            if(input[i]>input[i+1]  && input[i]>input[i-1]){
                return input[i];
            }
        }
        return input[n-1];

         */
        /*
            the brute force approach takes O(n) time complexity

            optimized approach using binary seach algorithm

            since it is sure  that we will have the peakElement as unique , we can decide our landscape

            lets take input
            0    1     2    3
            5    17   100   11

            lets find out the mid point

            mid = (0+3)/2 ~~ 1
            mid is -> 17 and mid+1 -> is 100
            the moment we see the right side element is greater than mid ,we can reject left half of our landscape
            so now we can only focus on mid+1 to end which is
              2     3
              100   11

              mid = (2+3)/2 ~~ 2

              mid > mid+1
              reject right half
              and we are left with single element 100 which is indeed the answer
         */
        int start = 1;
        int end = n-2;
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(input[mid]>input[mid-1] && input[mid]> input[mid+1]){
                return input[mid];
            }else if(input[mid]<input[mid+1]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return input[n-1];

        // the time complexity of this approach is O(logn)

    }

}
