package com.collection.DSA_module;

import java.util.Scanner;

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

1 <= A[i] <= 10^9

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

A = [1]
B = 1


Example Output
Output 1:

 0
Output 2:

 0
     */

  public static void main(String[] args){
      int[] A = {4,5,6,7,0,1,2};
      int minIndex = findMinUsingBinarySearch(A);
      Scanner s = new Scanner(System.in);
      System.out.println("please enter a target");
      int target = s.nextInt();
      int searchIndex =BinarySearchInRoatedArray(A, 0, minIndex-1, target);
      if(searchIndex == -1){
          searchIndex = BinarySearchInRoatedArray(A, minIndex,A.length-1, target);
      }
      System.out.println(searchIndex);
  }

  static int  BinarySearchInRoatedArray(int[] A, int l, int r, int target){
      while(l<=r) {
          int mid = (l + r) / 2;
          if (A[mid] == target) {
              return mid;
          } else if (A[mid] > target) {
              r = mid - 1;
          } else {
              l = mid + 1;
          }
      }
      return -1;
  }

  static int findMinUsingBinarySearch(int[] A){
      int l = 0;
      int r = A.length-1;
      while(l<r){
          int mid = (l+r)/2;
          if(A[mid]>A[r]){
             l = mid+1;
          }else{
              r = mid;
          }
      }
      return l;
  }

}
