package com.collection.DSA_module;

import java.util.HashMap;

public class singleNumber2 {
    /*
    Problem Description
Given an array of integers, every element appears thrice except for one, which occurs once.

Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?




Problem Constraints
2 <= A <= 5*106

0 <= A <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer.



Example Input
Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.

     */

    public static void main(String[] args){
        int[] input1 = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(solve(input1));

    }

    static int solve(int[] A){
        int result = 0;
        int n = A.length;
        // brute force approach-> simply iterate over all the elements and find the frequency and check if any element have
        // frequency one , return it
        /*
        for(int i = 0; i<A.length; i++){
            int count = 0;
            for(int j = 0; j<A.length;j++){
                if(A[i] == A[j]){
                    count++;
                }
            }
            if(count == 1){
                result = A[i];
            }
        }
        return result;

         */

        // time complexity of the brute force approach takes O(n*n) and space complexity is O(1)

        // better approach is to use HashMap and keep the frequency information
        // iterate over the hashMap and check if any element occurs only once
        // hence we found out the element
        //HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // store the frequency of every element
        /*
        for(int i = 0; i<n; i++){
            if(hm.containsKey(A[i])){
                hm.put(A[i], hm.get(A[i])+1);
            }else{
                hm.put(A[i],1);
            }
        }

        // iterate and find if any element from hashMap has frequency one

        for(int i = 0; i<n; i++){
            if(hm.get(A[i]) == 1){
                result = A[i];
            }
        }

        return result;

         */

        // time complexity of this approach is O(n)
        // space complexity is O(n)

        // optimized approach using bitwise operator
        /*
         -> count number of set bits of all elements
         lets take an input
         input =[0,0,0,1]
         -> lets see visuals of binary numbers of above elements
                     3 2 1 0
                     =======
                 0-> 0 0 0 0
                 0-> 0 0 0 0
                 0-> 0 0 0 0
                 1-> 0 0 0 1
       ------------------------------
                     0%3 0%3 0%3 1%3
                     0   0    0   1 -> 1
                     hence we have found out the unique element -> 1

         */
        for(int i = 0; i<32;i++){
            int count = 0;
            for(int j = 0; j<n;j++){
                if(checkBit(A[j],i)){
                    count++;
                }
            }
            if(count%3 == 1){
                result +=(1<<i); // equivalent to  2^i
            }
        }
        return result;
        
        // time complexity of this approach is O(32*n) which is O(n) and space complexity is O(1)

    }

    static boolean checkBit(int n, int i){
        if(((n>>i)&1) == 1){
            return true;
        }
        return false;
    }
}
