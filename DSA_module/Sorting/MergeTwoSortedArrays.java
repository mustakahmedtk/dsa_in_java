package com.collection.DSA_module;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArrays {
    /*
    Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.



Problem Constraints
-1010 <= A[i], B[i] <= 1010



Input Format
First Argument is a 1-D array representing A.

Second Argument is also a 1-D array representing B.



Output Format
Return a 1-D vector which you got after merging A and B.



Example Input
Input 1:

A = [4, 7, 9 ]
B = [2, 11, 19 ]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.
     */

    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        System.out.println(solve(A,B));
    }


    static ArrayList<Integer> solve(int[] A, int[] B){
        int n = A.length;
        int m = B.length;
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> mergedArray = new ArrayList<Integer>();
        while((p1<n) && (p2<m)){
            if(A[p1]<B[p2]){
                mergedArray.add(A[p1]);
                p1++;
            }
            else{
                mergedArray.add(B[p2]);
                p2++;
            }
        }

        while(p1<n){
            mergedArray.add(A[p1]);
            p1++;
        }

        while(p2<m){
            mergedArray.add(B[p2]);
            p2++;
        }

        return mergedArray;
    }
    //  the overall time complexity is O(m+n);
}
