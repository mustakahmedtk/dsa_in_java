package com.collection.DSA_module.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AthLargestElement {
    /*
       Problem Description
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.



Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX



Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.



Output Format
Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].



Example Input
Input 1:

 A = 4
 B = [1 2 3 4 5 6]
Input 2:

 A = 2
 B = [15, 20, 99, 1]


Example Output
Output 1:

 [-1, -1, -1, 1, 2, 3]
Output 2:

 [-1, 15, 20, 20]


Example Explanation
Explanation 1:

 for i <= 3 output should be -1.
 for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
 for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
 for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
 So, output array is [-1, -1, -1, 1, 2, 3].

Explanation 2:

 for i <= 1 output should be -1.
 for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
 for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
 for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
 So, output array is [-1, 15, 20, 20].
     */

    public static void main(String[] args) {
        int A = 4;
        int[] B = {1,2,3,4,5,6};
        int A1 = 2;
        int[] B1 = {15, 20, 99, 1};
        System.out.println(solve(A1,B1));
    }

    static ArrayList<Integer> solve(int A, int[] B){
        int n = B.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i<A-1; i++){
            pq.add(B[i]);
            ans.add(-1);
        }
        for(int i = A-1; i<n; i++){
            pq.add(B[i]);
            if(pq.size()>A) pq.poll();
            ans.add(pq.peek());
        }
        return ans;
    }
    /*
       T.C --> O(nlogn)
       S.C --> O(n)
     */

}
