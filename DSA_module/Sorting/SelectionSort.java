package com.collection.DSA_module;

import java.util.Arrays;

public class SelectionSort {
    /*
       Given an input
       array A = [7,5,4,10,1,20]

       sort the above array using selection sort
       algorithm

     */
    public static void main(String[] args) {
        int[] input  = {7,5,4,10,1,20};
        sort(input);
        System.out.println(Arrays.toString(input));


    }

    static void sort(int[] input){
        /*
          lets take the input array
            0  1  2 3   4   5
            7  5  4 10  1   20
            selection sort set the minimum element towards left on every loop untill it reaches to N

            at i = 0
                we found out the minimum at index = 4
                we will swap index 0 with 4
                     1 2 3  4 5
                1 |  5 4 10 7 20
            at i  = 1
               we found out the minimum element at index  = 2
               we will swap index 2 with 1
                     2  3 4  5
               1 4 | 5 10 7 20
            at i = 2
                  we found out the minimum element at index 2
                  since it is same as start index we need not to swap
                      3  4  5
              1 4 5 | 10 7 20
            at i = 3
                 we found out  the minimum element at index  = 4;
                 we will swap index 3 with 4
                           4  5
                 1 4 5 7 | 10 20

            at i = 4
                we found out the minimum element at index = 4
                since start index and minimum index is same , we need not to swap
                1 4 5 7 10 | 20

            the last step is overwhelming since we have already placed and sorted all the numbers , we are 100% sure we last
            number will be places last

            1 4 5 7 10 20


         */

        int n = input.length;
        int start = 0;
        int min;
        int minIndex;
        for(int i = 0; i<n-1;i++){
            min = input[start];
            minIndex = start;
            for(int j  = start; j<n; j++) {
                if (input[j] < min) {
                    min = input[j];
                    minIndex = j;
                }
            }
            // swap
            int temp = input[start];
            input[start] = input[minIndex];
            input[minIndex] = temp;
            start++;
        }

    }


}

