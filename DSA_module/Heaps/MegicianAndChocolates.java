package com.collection.DSA_module.Heap;

import com.collection.DSA_module.Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MegicianAndChocolates {
    /*
      Problem Description
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that the kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7


Problem Constraints
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105



Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.



Output Format
Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.



Example Input
Input 1:

 A = 3
 B = [6, 5]
Input 2:

 A = 5
 b = [2, 4, 6, 8, 10]


Example Output
Output 1:

 14
Output 2:

 33


Example Explanation
Explanation 1:

 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
 so, total number of chocolates eaten are 6 + 5 + 3 = 14
Explanation 2:

 Maximum number of chocolates that can be eaten is 33.

     */
    public static void main(String[] args) {
        int A = 5;
        int[] B = {2, 4, 6, 8, 10};
        System.out.println(solve(A,B));
    }

    static int solve(int A, int[] B){
        /*
          Brute force approach
          ----------------------

         */
        int n = B.length;
        int ans = 0;
        /*
        while(A>0){
            int max = Integer.MIN_VALUE;
            int maxIndex = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                if(B[i]>max){
                    max = B[i];
                    maxIndex = i;
                }
            }
            ans = ans + max;
            B[maxIndex] = max/2;
            A--;
        }
        return ans;

         */
        /*
           Time Complexity of this approach is O(n^2)
           S.C --> O(1)
           Optimized approach
           ------------------
         */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.<Integer>reverseOrder());

        for(int i = 0;i<n; i++){
            pq.add(B[i]);
        }
        while(A>0){
            int choc = pq.poll();
            ans = ans+choc;
            pq.add(choc/2);
            A--;
        }
        return ans;

        /*
           T.C --> O(nlogn)
           S.C -->O(n)
         */



    }
}
