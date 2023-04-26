package com.collection.DSA_module.BinarySearch;

public class BitonicArray {
    /*
    Problem Description
Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.



Input Format
First argument is an integer array A denoting the bitonic sequence.

Second argument is an integer B.



Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



Example Input
Input 1:

 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:

 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30


Example Output
Output 1:

 3
Output 2:

 -1


Example Explanation
Explanation 1:

 B = 20 present in A at index 3
Explanation 2:

 B = 30 is not present in A
     */
    public static void main(String[] args) {
        int[] input = {3, 9, 10, 20, 17, 5, 1};
        int target = 5;
        int[] input2 = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        int target2 = 30;
        System.out.println(solve(input, target));


    }




    static int solve(int[] input , int target){
        /*
           lets check the input array
           0   1    2   3    4    5   6
           3   9   10   20   17   5   1

           we need to find out the highest element which will be our
           pivot element
           the moment we see an element is greater than its adjacent we can
           then say we found out our pivot element
           once we know the pivot element
           we can conclude that from pivot+1 all the elements are strictly decreasing
           and from 0 to pivot-1 all the elements are strictly increasing
           we can apply binary search to find our target on both sides .




         */
        int n = input.length;
        // find the pivot index
        int pivotIndex = findpivotIndex(input);
        int searchIndex = BinarySearch(input, 0, pivotIndex, target);
        if(searchIndex == -1){
            return BinarySearchR(input, pivotIndex+1,n-1,target);
        }
        return searchIndex;
      // the overall time complexity of this approach is O(logn)

    }


    static int findpivotIndex(int[] input){
        int n = input.length;
        int start = 0;
        int end = n-1;

        while(start<end){
            int mid = (start+end)/2;
            if(input[mid]>input[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    static int BinarySearch(int[]input, int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(input[mid] == target){
                return mid;
            }
            else if(input[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    static int BinarySearchR(int[] input , int start, int end, int target){
        while(start<=end){
            int mid = (start+end)/2;
            if(input[mid] ==target) return mid;
            else if(input[mid]>target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return  -1;
    }
}
