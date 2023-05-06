package com.collection.DSA_module.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSumZero {
    /*
Problem Description

Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0

Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.



Problem Constraints

0 <= N <= 7000

-108 <= A[i] <= 108



Input Format

Single argument representing a 1-D array A.



Output Format

Output a 2-D vector where each row represent a unique triplet.



Example Input

A = [-1,0,1,2,-1,4]


Example Output

[ [-1,0,1],
  [-1,-1,2] ]


Example Explanation

Out of all the possible triplets having total sum zero,only the above two triplets are unique.
     */

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,4};
        System.out.println(solve(input));
    }

    static ArrayList<ArrayList<Integer>> solve(int[] input){
        /*
           brute force -> simply iterate with three loops and find out the zero sum , also keep tracking of duplicate
           using hashset
         */
        int n = input.length;
        Arrays.sort(input);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<String> set = new HashSet<String>();
        /*
        for(int i = 0; i<n; i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1; k<n; k++){
                    String triplet =input[i]+""+input[j]+""+input[k];
                    ArrayList<Integer> inner = new ArrayList<Integer>();
                    if((input[i]+input[j]+input[k]) == 0){
                        if(!set.contains(triplet)){
                            set.add(triplet);
                            inner.add(input[i]);
                            inner.add(input[j]);
                            inner.add(input[k]);
                            result.add(inner);
                        }
                    }
                }
            }
        }
        return result;

         */


        /*
          the brute force approach takes O(n^3) time complexity
          and O(n^2) space complexity
          better approach using three pointers
          lets take the input

          -1   0   1   2   -1   4
          sort the input
          -1   -1   0   1   2   4

          we can have three pointers p1 which will run linearly and p1 and p2 will run tactically
          p1 = 0
          p2 = p1+1
          p3 = n-1
          p1    p2             p3
          -1   -1   0   1   2   4

          -1-1+4 = 2>0  ----  decrement p3


           p1   p2         p3
          -1   -1   0   1   2   4

          -1-1+2 = 0   ----  both p2 and p3 moves;

          and so on .....

         */
        for(int i = 0; i<n-1; i++){
            int p1 = i+1;
            int p2 = n-1;
            while(p1<p2){
                String triplet =input[i]+""+input[p1]+""+input[p2];
                int sum = input[i]+input[p1]+input[p2];
                if(sum == 0 && !set.contains(triplet)){
                    ArrayList<Integer> inner = new ArrayList<Integer>();
                    set.add(triplet);
                    inner.add(input[i]);
                    inner.add(input[p1]);
                    inner.add(input[p2]);
                    result.add(inner);
                    p1++;
                    p2--;
                }
                else if(sum>0){
                    p2--;
                }else{
                    p1++;
                }

            }
        }
        return result;

        /*
          this approach takes O(n^2) time complexity
          and O(n^2) time space complexity
         */


    }
}
