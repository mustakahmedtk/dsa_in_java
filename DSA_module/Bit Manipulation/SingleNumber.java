package com.collection.DSA_module;

import java.util.HashMap;

public class SingleNumber {
    /*
    Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



Problem Constraints
1 <= |A| <= 2000000

0 <= A[i] <= INTMAX



Input Format
The first and only argument of input contains an integer array A.



Output Format
Return a single integer denoting the single element.



Example Input
Input 1:

 A = [1, 2, 2, 3, 1]
Input 2:

 A = [1, 2, 2]


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

3 occurs once.
Explanation 2:

1 occurs once.
     */
    public static void main(String[] args){
        int[] input1 = {1, 2, 2, 3, 1};
        int[] input2 = {1, 2, 2};
        System.out.println(solve(input1));

    }

    static int solve(int[] A){
        int n = A.length;
        // btute force approach
        // simply iterate over each element and check their frequency on every hop
        /*
        int count = 0;
        for(int i = 0; i<n; i++){
            count = 0;
            int current = A[i];
            for(int j = 0; j<n; j++){
                if(current == A[j]) count++;
            }
            if(count == 1) return current;
        }
        return -1;

         */
        // the brute force approach takes O(n*n) time complexity  and O(1) space complexity
        // better approach ->  2nd approach
        // since we can find the frequency and if for an element frequency -> 1 , return the element
        // to store the frequency , we can use HashMap
        /*
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // store the frequency of all the elements
        for(int i = 0; i<n; i++){
            if(hm.containsKey(A[i])){
                hm.put(A[i], hm.get(A[i])+1);
            }else{
                hm.put(A[i],1);
            }
        }

        // iterate over the array and check if any elements inside hashMap contains 1 occurrence
        for(int i = 0; i<n; i++){
            if(hm.get(A[i]) == 1) return A[i];
        }
        return -1;

         */

        // the second approach takes O(n) time complexity since we iterating only once
        // space complexity is O(n) since we are using HashMap

        // best optimized approach -> 3rd approach
        // we can think of using bitwise XOR operator as it checks for exclusivity
        // lets see the truth table of XOR
        //  0 ^ 0 => 0
        // 0 ^ 1 => 1
        // 1 * 0 => 1
        // 1 ^ 1 => 0
        // so whenever we XOR two similar elements , it cancel out them and make 0 contribution to ans
        // lets take the input1
        // input1 = 1, 2, 2, 3, 1
        // lets XOR them -> 1^2^2^3^1
        // clearly we can see , if we cancel out the similar elements we will be left out with only 3

        int singleNumber = 0;
        for(int i = 0; i<n; i++){
            singleNumber ^=A[i];
        }
        return singleNumber;

        // the time complexity of this appraoch is O(n) and space complexity is O(1);


    }

}
