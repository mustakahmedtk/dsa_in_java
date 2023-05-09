package com.collection.DSA_module.TwoPointers;

import java.util.Arrays;

public class SortTheColor {
    /*
       Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2


Input Format
First and only argument of input contains an integer array A.


Output Format
Return an integer array in asked order


Example Input
Input 1 :
    A = [0 1 2 0 1 2]
Input 2:

    A = [0]


Example Output
Output 1:
    [0 0 1 1 2 2]
Output 2:

    [0]


Example Explanation
Explanation 1:
    [0 0 1 1 2 2] is the required order.
     */
    public static void main(String[] args) {
        int[] colors = {0,1,2,0,1,2};
        System.out.println(Arrays.toString(solve(colors)));
    }

    static int[] solve(int[] colors){
        /*
          brute force
          simply sort the array and all the colors are arranged adjacent
          time complexity of this approach is O(nlogn)
          better approach
          using two pointers
          lets take the input

          idea --->  if  we arrange 0's and 2's from both sides then  1's will be automatically arranged


          zero
          i                        two

          0     1    2    0    1    2

          i == 0 ------
           swap(zero,i)
           zero++
           i++

          i == 2 ------
          swap(i,two)
          two--
         */
        int n = colors.length;
        int i = 0;
        int zero = 0;
        int two = n-1;
        while(i<=two){
            if(colors[i] == 0){
                swap(colors, i, zero);
                i++;
                zero++;
            }
            else if(colors[i] == 2){
                swap(colors, i, two);
                two--;
            }
            else{
                i++;
            }
        }
        return colors;
    }

    // the overall time complexity of this appoach is O(n);

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
