package com.collection.DSA_module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSort {
    /*
      Given an array A = [10,8,6,5,1,2]
      sort the array using merge sort
     */

    public static void main(String[] args) {
        int[] arr = {10,8,6,5,1,2};
        int n = arr.length;
        int start = 0;
        int end = n-1;
        sort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

     static void sort(int[] arr, int start, int end) {
        /*
         merge sort works on the principle of devide and conquer
         let take the input

         0   1  2  3  4  5

         10  8  6  5  1  2

         half the above array into two part

         midpoint = (0+5/2) ~ 2

         left array 0 to 2                        right array 3 to 5
         0      1     2                            3   4   5

         10     8     6                            5   1    2

         find the mid point                       find the midpoint
          midpoint = 0+2/2 ~ 1                    midpoint  = 3+5/2 ~ 4

        left(left)array        left(right)array           right(left)array    right(right)array
         0    1                     2                         3   4                  5

         10   8                     6                         5   1                  2

         left(left(left))array  left(left(right))array    right(left(left))   right(right(right))
          0                        1                           3                   4
          10                       8                           5                   1
       we divided all the element into single element array;


       now lets merge

      left(left)array = compare(left(left(left))array with left(left(right))array)  right(left)array = compare(right(left(left)) with right(right(right)))
                                8 10                                                                                                    1 5


      left = compare(left(left)array with left(right)array)      right = compare(right(left)array with right(right)array)
                  6 8 10                                                     1  2 5

     mergedarray = compare(left with right)
                  ==   1  2   5   6  8 10

         */
        /* sanity check */
        if(start>end){
            System.out.println("invalid start and end");
        }
        // base case
        if(start == end){
            return;
        }

        // recursive relation
        int mid = (start +end)/2;
        sort(arr,start,mid);
        sort(arr, mid+1,end);
        merge(arr, start, mid, end);
        return;
    }


     static void merge(int[] arr, int s, int mid, int e){
          int n1 = mid-s+1;
          int n2 = e-mid;
          // create two temp arrays
          int[] L = new int[n1];
          int[] R = new int[n2];
          // copy to temp arrays
           for(int i = 0; i<n1;i++){
               L[i] = arr[s+i];
           }
           for(int j = 0; j<n2; j++){
               R[j] = arr[mid+1+j];
           }
           int p1 = 0,p2 = 0;
           int k = s;
           while(p1<n1 && p2<n2){
               if(L[p1]<R[p2]){
                   arr[k] = L[p1];
                   p1++;
               }else{
                   arr[k] = R[p2];
                   p2++;
               }
               k++;
           }
           while(p1<n1){
               arr[k] = L[p1];
               p1++;
               k++;
           }
           while(p2<n2){
               arr[k] = R[p2];
               p2++;
               k++;
           }
    }

}
