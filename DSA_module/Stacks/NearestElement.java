package com.collection.DSA_module.Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NearestElement {
    /*
      Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.



Problem Constraints
1 <= |A| <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is integer array A.



Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.



Example Input
Input 1:

 A = [4, 5, 2, 10, 8]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [-1, 4, -1, 2, 2]
Output 2:

 [-1, -1, -1]


Example Explanation
Explanation 1:

index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
Explanation 2:

index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1
     */

    public static void main(String[] args) {
        int[] input1 = {4, 5, 2, 10, 8};
        System.out.println(solve(input1));
    }

    static ArrayList<Integer> solve(int[] A){
        /*
          brute force approach
          -> add first element as -1;
          -> start from index 1
          -> start an inner loop from i-1 to 0 and check if any element is smaller than current element
          -> once we find the smallest element , break the inner loop
          -> add the smallest element in result array
          -> keep doing above steps until you reach to i -> n

          Time complexity of this approach is O(n^2)
         */
        int n = A.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        /*
        result.add(-1);
        for(int i = 1; i<n; i++){
            int current = A[i];
            int smallest = -1;
            for(int j = i-1; j>=0;j--){
                if(A[j]<current){
                    smallest = A[j];
                    break;
                }
            }
            result.add(smallest);
        }
        return result;

         */

        /*
           Optimized approach using Stack


         */
        // insert -1 to result array
        for(int i = 0; i<n; i++){
            result.add(-1);
        }
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && st.peek()>=A[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                result.set(i,st.peek());
            }
            st.push(A[i]);
        }
        return result;

        /*
           T.C --> O(n)
           S.C -->O(n)
         */

    }
}
