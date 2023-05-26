package com.collection.DSA_module.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarrayWithGivenSum {
    /*
       Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 [-1]
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(solve(A,B));
    }

    static ArrayList<Integer> solve(int[] A, int B){
        int n = A.length;
        /*
         brute force is simply run three loops to get the sub array and check if sum matches and then add the
         elements of sub array
         */

        ArrayList<Integer> result = new ArrayList<Integer>();
        /*
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                int sum = 0;
                for(int k = i; k<=j;k++){
                    sum +=A[k];
                    result.add(A[k]);
                }
                if(sum == B){
                    return result;
                }
                result.clear();
            }
        }
        result.add(-1);
        return result;

         */
        /*
          the brute force approach takes O(n^3) time complexity
          the optimized approach using HashMap and prefixSum

          lets take the input
           1  2  3  4  5
           -> find the prefix sum array

           1  3  6  10 15

           -> iterate over the prefix sum and check if there is any key matches with inside HashMap
           which has A[i]-B , if yes make startpoint = hm.get(A[i]-B)
           and  endPoint = i
           0  1  2  3  4
           1  3  6  10 15

           HasMap
           ========

            -4->i+1                 1-5 = -4 doesnot exist in HashMap

            Math
            =====
            p1, p2, p3 ......pn
            in a prefix sum , if we found in p3 as ps[p3-B] = p1 , that mean our sub array lies between
            p2 .... p3

             HasMap
           ========

            1->1               1-5 = -4 doesnot exist in HashMap
            3 ->2              3-5 = -2 doesnot exist in hashMap so stored
                               6-5 -> 1 deos exist at index 1 which is out startIndex and current index is 2

           so subarray is [1,2]






         */
        // create prefix sum of input array
        int[] PS = new int[n];
        PS[0] = A[0];
        for(int i = 1; i<n;i++){
            PS[i] = PS[i-1]+A[i];
        }
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        int startIndex = 0;
        int endIndex = n;
        for(int i = 0; i<n; i++){
            int key = PS[i];
            if(hm.containsKey(key-B)){
                startIndex = hm.get(key-B);
                endIndex = i;
                break;
            }else{
                hm.put(key,i+1);
            }
        }

        if(endIndex == n){
            result.add(-1);
            return result;
        }else{
            for(int i = startIndex; i<=endIndex;i++){
                result.add(A[i]);
            }
        }

        return result;

        /*
          T.C ---> O(n)
          S.C ----> O(n)
         */


    }


}
