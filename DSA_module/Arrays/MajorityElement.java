package com.collection.DSA_module;

public class MajorityElement {
    /*
    Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.



Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109


Input Format
Only argument is an integer array.


Output Format
Return an integer.


Example Input
[2, 1, 2]


Example Output
2
     */
    public static void main(String[] args){
        int[] input = {3,3,1,2,3};
        int result = solve(input);
        System.out.println(result+"majority element");

    }

    static int solve(int[] A){
        // brute force approach
      /*  int candidate;
        int n = A.length;
        for(int i = 0; i<n;i++) {
            int freq = 1;
            candidate = A[i];
            for (int j = i + 1; j < n; j++) {
                if (candidate == A[j]) {
                    freq++;
                }
            }
            if (freq > n / 2) {
                return candidate;
            }
        }
        return -1;

       */
     // time complexity of brute force approach is O(n*n) space complexity is O(1);

        // optimized approach using Moore's algorithm
        // observation of this algorithm is we can only have one mejority element which will occur more than n/2 times
        // initialize two variables candidate(with first element of the array) and freq(with 1)
        // iterate over array from first index and check we have same candidate then increase frequency else decrease frequency
        // if frequency become zero then update the candidate with new element and update frequency to 1
        // at last there will be one candidate and count the candidate and check if it is more n/2
        // hence we found majority element

        int candidate = A[0];
        int n = A.length;
        int freq = 1;
        for(int i = 1; i<n; i++){
            if(candidate == A[i]){
                freq++;
            }else{
                freq--;
            }
            if(freq == 0){
                candidate = A[i];
                freq = 1;
            }
        }

        int count = 0;
        for(int i = 0; i<n;i++){
            if(candidate == A[i]){
                count++;
            }
        }
        if(count>n/2) return candidate;
        return -1;

        // time complexity of this approach is O(n)  and space complexity is O(1);
    }
}
