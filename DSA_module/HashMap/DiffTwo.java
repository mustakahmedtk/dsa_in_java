package com.collection.DSA_module.HashMap;

import java.util.HashMap;

public class DiffTwo {
    /*
     Problem Description
Given an array A of integers and another non negative integer B .

Find if there exists 2 indices i and j such that A[i] - A[j] = B and i != j.



Problem Constraints
1 <= |A| <= 106

0 <= A[i] <= 109

0 <= B <= 109



Input Format
First argument A is an array of integer

Second argument B is an integer



Output Format
Return 1 if two such indexes are found and 0 otherwise


Example Input
Input 1:
A = [1, 5, 3]
B = 2
Input 2:
A = [2, 4, 3]
B = 3


Example Output
Output 1:
1
Output 2:
0


Example Explanation
For Input 1:
The given value of A[1] = 1 and A[3] = 3.
The value of A[3] - A[1] = 2.
For Input 2:
There are no pairs such that difference is B.
     */
    public static void main(String[] args) {
        int[] input = {1, 5, 3};
        int target = 2;
        System.out.println(solve(input, target));
    }

    static int solve(int[] A, int B){
        /*
          brute force
          simply iterate over the the array with i and j  =  i+1 and check if we have diff(i-j) is equal to B
          and then simply return 1;

         */
        int n = A.length;
        /*


        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(A[i]-A[j] == B){
                    return 1;
                }
            }
        }
        return 0;

         */

        // the brute force approach takes O(n^2) time complexity
        /*
           better approach using HashMap
           since x-y = B
           x = B+y
           simply store all the elements in hashMap
           then iterate over the array and check if we have B+A[i] in the array
           if true then we found the diff .
         */
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
            hm.put(A[i],i); // we need to track i so that it does not colide with other element
        }

        for(int i = 0; i<n; i++){
            int key = A[i];
            if(hm.containsKey(B+key) && hm.get(B+key) !=i){
                return 1;
            }
        }
        return 0;

        // the overall time complexity of this approach is O(n)
        // and space complexity is O(n) since we used hashMap

    }
}
