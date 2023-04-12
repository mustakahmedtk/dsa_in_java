package com.collection.DSA_module;

import java.util.Arrays;

public class BubbleSort {
    /*
       Given an input array
       A = [6,4,7,9,2,1]
       sort it using BubbleSort
     */
    public static void main(String[] args) {
        int[] input = {6,4,7,9,2,1};
        sort(input);
        System.out.println(Arrays.toString(input));

    }

    static void sort(int[] input){
        /*
          bubble sort swap adjacent elements and shift to last element
          lets take the given example
          at first iteration
          0   1   2   3   4   5
          6   4   7   9   2   1
          -----
          i>i+1
          swap
          4   6   7   9   2   1
             -------
              i<i+1
              no swap

          4   6   7   9   2   1
                 --------
                  i<i+1
                  no swap
          4   6    7   9   2  1
                      -------
                       i>i+1
                        swap
          4    6   7   2  9  1
                         ------
                          i>i+1
                           swap

          after first iteration
            4  6  7  2  1  | 9


          at second iteration
          0   1   2   3   4
          4   6   7   2   1  | 9
          -----
          i<i+1
          no swap
          4   6   7  2  1  |9
              -----
              i<i+1
              no swap

          4   6   7   2  1 |9
                 -------
                  i>i+1
                   swap
          4   6   2   7  1 | 9
                     ------
                      i >i+1
                      swap
       after second iteration
          4  6   2  1  | 7  9

       at third iteration
        0   1   2   3
        4   6   2   1 | 7 9
        ------
        i<i+1
        no swap

        4   6   2   1 | 7 9
           --------
            i > i+1
             swap

        4   2   6   1 | 7 9
               -------
                i >i+1
                swap
    after third iteration
        4   2   1  | 6 7 9


     at fourth iteration
      0   1   2
      4   2   1  | 6 7 9
      -----
       i>i+1
       swap

      2   4   1  | 6 7 9
         -------
          i>i+1
          swap
     after fourth iteration

      2   1  | 4  6 7 9

      at fifth iteration
      0   1
      2   1  | 4  6 7 9
      -----
      i>i+1
       swap
     after fifth iteration
        1 2 4 6 7 9
       hence all the numbers are sorted

         */
        int n = input.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n-i-1;j++){
                if(input[j]>input[j+1]){
                    swap(input, j , j+1);
                }
            }
        }
    }

    static void swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
