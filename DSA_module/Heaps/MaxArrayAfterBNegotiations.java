package com.collection.DSA_module.Heap;

import java.util.PriorityQueue;

public class MaxArrayAfterBNegotiations {
    /*
       Problem Description
Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format
The first argument given is an integer array A.
The second argument given is an integer B.



Output Format
Return an integer denoting the maximum array sum after B modifications.



Example Input
Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output
Output 1:

 196
Output 2:

 362


Example Explanation
Explanation 1:

 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
     */
    public static void main(String[] args) {
        int[] A = {24, -68, -29, -9, 84};
        int B = 4;
        System.out.println(solve(A,B));
    }

    static int solve(int[] A, int B){
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i<n; i++){
            pq.add(A[i]);
        }
        while(B>0){
            int val = pq.poll();
            val *= -1;
            pq.add(val);
            B--;
        }
        int ans = 0;
        while(pq.size()>0){
            ans += pq.poll();
        }
        return ans;
    }

    /*
      T.C --> O(nlogn)
      S.C --> O(n)
     */
}
