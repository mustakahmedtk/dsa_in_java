package com.collection.DSA_module;

import java.util.Arrays;

public class QuickSort {
    /*
      Given an array of numbers
      A = [10,3,8,15,6,12,2,18,7,15,14]
      sort it using quick sort algorithm
     */

    public static void main(String[] args) {
         int[] input = {10,3,8,15,6,12,2,18,7,15,14};
         int start = 0;
         int end = input.length-1;
         sort(input, start, end);
        System.out.println(Arrays.toString(input));
    }

    static void sort(int[] A, int start, int end){
        /*
          quick sort works on the principle of rearrangement and pivoting
          lets take the above input
          0    1   2   3    4   5    6   7    8   9    10
          10   3   8   15   6   12   2   18   7   15   14

          let think of just rearranging the 0th index to its right position
           A[0]~10 -> if we see 3 8 6 2 7 are the numbers less than 10 so clearly 10 occupies
           the 5th index .

           but still numbers are not rearranged
                   |end ->                              <- end|
           0       1   2   3    4   5    6   7    8   9    10

           10      3   8   15   6   12   2   18   7   15   14
        -------    i                                        j
          pivot


                   |end ->                              <- end|
           0        1       2        3    4   5    6   7    8   9    10

           10       3       8       15   6   12   2   18    7    15    14
        -------     i ->    i                               j  <-   j<-  j
          pivot  -----    -------  -----                   -----          -------
               A[i]<pivot  i<pivot  i>pivot                j<pivot         j>pivot

                  move i   move i    waiting                waiting
                                       -------------------------
                                                 swap


                   |end ->                              <- end|
           0        1       2        3        4         5     6   7    8   9    10

           10       3       8        7        6        12        2   18    15    15    14
        -------     i ->    i   ->   i    ->  i   ->    i        j  <- j<-  j  <-   j<-  j
          pivot  -----    -------  -----     ----    ------     ----  -----          -------
               A[i]<pivot  i<pivot  i<pivot   i<pivot i>pivot  pivot>j        j>pivot         j>pivot
                                                       waiting waiting
                                                              swap


                   |end ->                              <- end|
           0        1       2        3        4         5     6   7    8   9    10

           10       3       8        7        6        2        12   18    15    15    14
        -------     i ->    i   ->   i    ->  i   ->    j        i  <- j<-  j  <-   j<-  j

        now we can simply swap the pivot element to i-1

         2       3       8        7        6        10        12   18    15    15    14
        this is the point where i crossed j
        now if we see all the i are less than pivot element and all the j are greater pivot element

        now if we apply the same arrangement recursively to to all the elements from 0 pivot-1

        and pivot+1 to 10 , we will rearrange all the elements at thier current position

        this above technique is named as quick sort


         */
        if(start>end){
            return;
        }
        if(start == end){
            return;
        }
        int pivotIndex = rearrange(A, start, end);
        sort(A, 0, pivotIndex-1);
        sort(A, pivotIndex+1, end);
        return;

        // the time worst case time complexity of quick sort is O(n^2);
    }


    static int rearrange(int[] A, int start, int end){
         int pivot = A[start];
         int left = start+1;
         int right = end;
         while(left<=right){
             if(A[left]<=pivot){
                 left++;
             }else if(A[right]>pivot){
                 right--;
             }else{
                 swap(A, left, right);
             }
         }
         swap(A, start, left-1);
         return left-1;
    }

    static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
