package com.collection.DSA_module;

import java.util.ArrayList;

public class SingleNumberIII {
    /*
    Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.


Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
The first argument is an array of integers of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:
[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:
3 and 4 appear only once.
Explanation 2:

1 and 2 appear only once.
     */

    public static void main(String[] args){
        int[] input = {1, 2, 3, 1, 2, 4};
        int[] result = solve(input,input.length);
        System.out.println("unique two elements are "+result[0]+" and "+result[1]);

    }


    static int[] solve(int[] A, int n){
        // since we discuss about the brute force in singleNumber2, we will discuss the best approach here
        /*
          step1 -> simple XOR all the element

           cleary see all the elements repeat twice except two unique element
           for the input -> {1, 2, 3, 1, 2, 4}
           the xor will be -> 3^4 which is nothing but 7
          step2 ->
                lets see the binary way ->      3 2 1 0
                                          ----------------
                                              3 -  0 0 1 1
                                              4 -  0 1 0 0
                                         -------------------
                                                   0 1 1 1 -> 7

          step3 ->
            based on the step2 observation we will create two groups (set and unset)
            1->(0001), 2->(0010), 3->(0011), 1->(0001), 2->(0010), 4->(0100)
            if in 3^4 -> if any bit is set then we can use it for segregating set and unset elements
          step4 -> use checkbit to find the if any bit set in 3^4 and store the bit position

          step5 -> iterate over the array elements to and check if the position is set or not
                  set will go to set group and unset will go to unset group
          step6 -> we can simply XOR all the set and unset groups separately and hence we have two unique elements

         */
        int[] result = new int[2];
        int val = 0;
        for(int i = 0; i<n; i++){
            val^=A[i];
        }
        int pos = 0;
        for(int i = 0; i<32;i++){
            if(checkBit(val,i)){
                pos = i;
                break;
            }
        }
        int set = 0, unset = 0;
        for(int i = 0;  i<n; i++){
            if(checkBit(A[i],pos)){
                set ^=A[i];

            }else{
                unset ^=A[i];
            }
        }
        if(set>unset){
            result[1] = set;
            result[0] = unset;
        }else{
            result[0] = set;
            result[1] = unset;
        }

        return result;

        // the overall time complexity of above approach is O(n) and space complexity is O(1);


    }

    static boolean checkBit(int n, int i){
        if(((n>>i)&1) == 1){
            return true;
        }
        return false;
    }

}
