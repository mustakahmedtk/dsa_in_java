package com.collection.DSA_module;

public class PrefixSumAndSuffixSum {
    public static void main(String[] args){
        int[] arr = {2,3,5,6,7,8};
        int[] result = prefixSum(arr);
        // for prefixSum
        System.out.println("for prefix sum");
        for(int i = 0; i<result.length;i++){
            System.out.println(result[i]);
        }
        int[] sResult = suffixSum(arr);
        // for suffixSum
        System.out.println("for suffix sum");
        for(int i = 0; i<sResult.length;i++){
            System.out.println(sResult[i]);
        }

    }
//  prefix sum is the running sum of an array from left to right
    static int[] prefixSum(int[] A){
        int[] PS = new int[A.length];
        PS[0] = A[0];
        for(int i = 1; i<A.length;i++){
            PS[i] = PS[i-1] + A[i];
        }
        return PS;

    }
// suffix sum is the running sum of an array from right to left
    static int[] suffixSum(int[] A){
        int n = A.length;
        int[] SS = new int[n];
        SS[n-1] = A[n-1];
        for(int i = n-2;i>=0;i--){
            SS[i] = SS[i+1] + A[i];
        }
        return SS;
    }
}
