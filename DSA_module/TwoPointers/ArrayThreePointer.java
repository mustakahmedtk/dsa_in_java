package com.collection.DSA_module.TwoPointers;

public class ArrayThreePointer {
    /*
     Problem Description
You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Problem Constraints
1 <= len(A), len(B), len(c) <= 106

0 <= A[i], B[i], C[i] <= 107



Input Format
First argument is an integer array A.

Second argument is an integer array B.

Third argument is an integer array C.



Output Format
Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).



Example Input
Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 With 10 from A, 15 from B and 10 from C.
Explanation 2:

 With 3 from A, 2 from B and 3 from C.
     */
    public static void main(String[] args) {
        int[] A = {1, 4, 10};
        int[] B = {2, 15, 20};
        int[] C = {10, 12};
        System.out.println(solve(A, B, C));
    }

    static int solve(int[] A, int[] B, int[] C) {
        /*
          brute force solution
          simply iterate over the 3 arrays and find out based on the equation

         */
        int l = A.length;
        int m = B.length;
        int n = C.length;
        int minimum = Integer.MAX_VALUE;
        /*
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int absA = Math.abs(A[i] - B[j]);
                    int absB = Math.abs(B[j] - C[k]);
                    int absC = Math.abs(C[k] - A[i]);
                    int max = Math.max(absA, absB);
                    max = Math.max(max, absC);
                    minimum = Math.min(max, minimum);
                }
            }
        }
        return minimum;

         */

        /*
          the overall time complextiy of this approach is O(n^3);
         */
        // better appraoch using three pointers
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while(p1<l && p2<m && p3<n){
            int max = Math.max(A[p1], B[p2]);
                max = Math.max(max, C[p3]);
            int min = Math.min(A[p1], B[p2]);
                min = Math.min(min, C[p3]);
            minimum = Math.min(minimum, max-min);
          if(min == A[p1]){
              p1++;
          }else if(min == B[p2]){
              p2++;
          }else{
              p3++;
          }
        }
        return minimum;

        //  the time complexity of this approach is O(min(l,m,n));
    }

}
