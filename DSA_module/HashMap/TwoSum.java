package com.collection.DSA_module.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    /*
      Problem Description

    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

    If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

    Input: [2, 7, 11, 15], target=9
    Output: index1 = 1, index2 = 2

     */
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solve(input,target)));
    }

    static int[] solve(int[] A, int B){
        /*
          brute force solution
          ------------------------

          using simply two loops i and another j = i+1 can solve the problem
         */
        int n = A.length;
        int[] result = new int[2];
        /*
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(A[i]+A[j] == B){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;

         */
        /*
           the brute force solution takes O(n^2) time complexity

           we can use hashmap to bring to better time complexity

           lets take a+b = k(sum of two numbers)

           for  a if k-b is available then we found out the two numbers

           so we will simply store k-b to hashmap and iterate over the array
         */
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
            int key = A[i];
            if(hm.containsKey(key)){
                result[0] = hm.get(key);
                result[1] = i;
                return result;
            }
            else if(!hm.containsKey(B-key)){
                hm.put(B-key,i);
            }
        }
        return result;

        // the overall time complexity of this approach is O(n)
        // the space complexity is O(n) since we used hashMap

    }
}
