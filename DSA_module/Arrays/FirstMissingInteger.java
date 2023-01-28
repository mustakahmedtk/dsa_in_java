package com.collection.DSA_module;

import java.util.*;
import java.util.Arrays;

public class FirstMissingInteger {
    /*
    Problem Description
Given an unsorted integer array, A of size N. Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the first missing positive integer.



Example Input
Input 1:

[1, 2, 0]
Input 2:

[3, 4, -1, 1]
Input 3:

[-8, -7, -6]

input 4:
[2, 3, 1, 2]


Example Output
Output 1:

3
Output 2:

2
Output 3:

1

Output 4:
4


Example Explanation
Explanation 1:

A = [1, 2, 0]
First positive integer missing from the array is 3.
     */

    public static void main(String[] args){
        int[] input1 = {2, 3, 1, 2};
        int[] input2 = {3, 4, -1, 1};
        int[] input3 = {-8, -7, -6};
        System.out.println(solve(input3)+"first missing positive integer");
        //


    }


    static int solve(int[] A){
        int n = A.length;
        // brute force approach
        // sort the array
        // traverse the array
        /*
        Arrays.sort(A);
        int ans = 1;
        for(int i = 0; i<n; i++){
            if(A[i] == ans){
                ans++;
            }
        }
        return ans;

         */
        // time complexity of above approach is O(nlogn) and space complexity is O(1);

        // better approach
        // store all the elements in hashset
        // traverse from 1 to N and check if any element is present in hashset
        /*
          HashSet<Integer> hs = new HashSet<Integer>();
          for(int i=0; i<n; i++){
              hs.add(A[i]);
          }

          for(int i = 1; i<=n;i++){
              if(!hs.contains(i)){
                  return i;
              }
          }
          return n+1;

         */

          // time complexity of this approach is O(n);
          // space complexity is O(n) as we used HashSet;

        // optimized approach
        // rearranging the input space and traverse over the array
        for(int i = 0; i<n; i++){
            if(A[i]>0 && A[i]<=n){
                int newPosition = A[i]-1;
                if(A[newPosition]!=A[i]){
                    swap(A, newPosition, i);
                    i--;
                }
            }
        }

        for(int i = 0; i<n; i++){
            if(A[i] != (i+1)){
                return (i+1);
            }
        }
        return n+1;


    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
