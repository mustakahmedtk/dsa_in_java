package com.collection.DSA_module.BinarySearch;

public class SortedRotatedArray {
    /*
     Problem Description
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index otherwise, return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 109

all elements in A are distinct.



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A : [ 9, 10, 3, 5, 6, 8 ]
B : 5


Example Output
Output 1:

 0
Output 2:

 3


Example Explanation
Explanation 1:

Target 4 is found at index 0 in A.
Explanation 2:

Target 5 is found at index 3 in A.
     */

    public static void main(String[] args) {
          int[] input1 = {4, 5, 6, 7, 0, 1, 2, 3};
          int target1 = 4;
          int[] input2 = {9, 10, 3, 5, 6, 8};
          int target2 = 5;
          System.out.println(solve(input1, target1));
    }


    static int solve(int[] input, int target){

        /*
           lets take the input
           0   1   2   3   4   5   6   7
           4   5   6   7   0   1   2   3

           we need to somehow find the pivot element from array by which we create two halves of our input

           by looking at the input element , we can say 0 can be the pivot element as whatever elements before and after
           0 are sorted , if we can find out that , we can narrow down the problem into two halves

           lets find the mid

           mid  = 0+7/2 ~ 3
            if(mid > end) we are 100% sure minElement will be from mid+1 to end
            we can reject the 0 to mid
            4   5   6   7
            0   1   2   3

            lets find mid again

            mid = 4+7/2~ 5
            mid < end
            we can now reject mid+1 to end

            4   5

            0   1

            mid  = 4+5/2 ~ 4

            mid<end
            we can now reject mid+1

            now we are left with with 1 element
            which 0
            i.e index = 4


           -> now we can simply apply binarySearch from 0 to mid-1
           and mid to end
         */

        int n = input.length;
        int start = 0;
        int end = n-1;
        int minIndex = findMinIndex(input, start, end);
        if(input[minIndex] == target){
            return minIndex;
        }else{
            int searchIndex = BS(input, 0 , minIndex-1, target);
            if(searchIndex == -1){
                return BS(input, minIndex+1, n-1, target);
            }
            return searchIndex;
        }

        // time complexity of this approach is O(logn)+O(logn)+O(logn) ===>  O(logn)

    }


    static int findMinIndex(int[] input, int st, int end){
        int left = st;
        int right = end;
        while(left<right){
            int mid = (left+right)/2;
            if(input[mid]>input[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }


    static int BS(int[] arr, int left, int right, int target){
        int start = left;
        int end = right;
        while(start<=end){
            int mid = (start + end) / 2;
            if(target>arr[mid]){
                start = mid+1;
            }
            if(target<arr[mid]){
                end = mid-1;
            }
            if(target == arr[mid]){
                return mid;
            }
        }
        return -1;
    }

}
