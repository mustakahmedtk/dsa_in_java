package com.collection.DSA_module.TwoPointers;

public class CountRectangles {
    /*
    Problem Description

Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.

(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)



Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format

The first argument given is the integer array A.

The second argument given is integer B.



Output Format

Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).



Example Input

Input 1:

 A = [1, 2]
 B = 5
Input 2:

 A = [1, 2]
 B = 1


Example Output

Output 1:

 4
Output 2:

 0


Example Explanation

Explanation 1:

 All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
Explanation 2:

 No Rectangle is valid.

     */
    public static void main(String[] args) {
        int[] A = {1, 2};
        int B = 5;
        System.out.println(solve(A, B));
    }

    static int solve(int[] A, int B){
        /*
           brute force
           simply iterate over the all the sub arrays and also take care of number itself which can create
           a rectangle

           let take the input

           1   2

           1 1 can be a rectangle

           1 2 can be a rectangle

           2 2 can be  rectangle
           2 1 can be a rectangle


         */
        int n = A.length;
        if(n == 1) return 1;
        int count = 0;
        /*
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(A[i]*A[j]<B){
                    count++;
                }
            }
        }
        return count;

         */

        // the overall time complexity of this approach is O(n^2)

        /*
           optimized approach using two pointers
           let take the above input

            1   2

            as the array is sorted , we can take one pointer from right and one from left

            p1  p2
            1   2
            here is an important observation

            p1.....................p2
            if  p1 * p2<B
                 . p2-1<B true
                 . p2-2<B true
                 . p2-3<B true
                 . p1 <B  true
            we can add p2 as count+p2+1 to our ans   //   as array starts from 0
            then anything below p2 will be possible

            p1 can move until n-1 and p2 can move until 0



         */
        int p1 = 0;
        int p2 = n-1;
        while(p1<n && p2>=0){
            if(A[p1]*A[p2]<B){
                count = count+p2+1;
                p1++;
            }else{
                p2--;
            }
        }
        return count;

        // the Time Complexity of this approach is O(N)


    }
}
