package com.collection.DSA_module;

import java.util.Arrays;

public class InsertionSort {
    /*
      Given an  array A = [12, 11, 13 , 5 , 6],
      sort it using insertion sort technique

     */
    public static void main(String[] args) {
        int[] input  = {12, 11, 13 , 5 , 6};
        sort(input);
        System.out.println(Arrays.toString(input));
    }

    static void sort(int[] arr){
        /*
           insertion sort works on the principle of fixing the impurity at its desired position
           lets take the input
           0   1   2   3  4
           12  11  13  5  6
           single number is always sorted so
           lets start the impurity index from 1

   step1    12                         11        13        5        6
           --------------------------------
           impurityIndex-1 > impurityIndex
                        swap

                                                 i
   step2       11                  12               13               5             6
                               --------------------------------
                               impurityIndex-1 <  impurityIndex
                                           no swap
                                                                      i
   step3        11                  12               13               5             6
                                              --------------------------------
                                               impurityIndex-1    impurityIndex
                                                           swap

                11                  12               5               13            6
                                   -----------------------------------
                                            12>5 still impure so swap
                 11                  5               12               13            6
            ------------------------------------
                      11>5 still impure so swap


                                                                                      i
   step4        5                  11               12                 13             6
                                                                  -----------------------------------
                                                                     impurityIndex-1    impurityIndex
                                                                                    swap

                5                  11               12                 6             13
                                                ---------------------------
                                                    12 > 6 still impure so swap


                5                  11               6                 12             13
                               ------------------------------
                                  11 > 6 still impure so swap

                5                  6               11                 12             13


            hence the array is sorted


            insertion sort is beautiful sorting technique when majority of elements in an array are sorted

         */

        int n = arr.length;
        for(int i = 1; i<n; i++){
             int impurityIndex = i;
             while( impurityIndex>=1 && (arr[impurityIndex]<arr[impurityIndex-1])){
                 swap(arr, impurityIndex, impurityIndex-1);
                 impurityIndex = impurityIndex-1;
             }
        }
        
        // Time Complexity is O(n^2)


    }

    static void swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
