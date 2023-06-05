package com.collection.DSA_module.HashMap;

import java.util.HashMap;

public class CountRightAngleTriangles {
    /*
       Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).



Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109



Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).



Example Input
Input 1:

 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:

 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]


Example Output
Output 1:

 1
Output 2:

 6


Example Explanation
Explanation 1:

 All three points make a right angled triangle. So return 1.
Explanation 2:

 6 triplets which make a right angled triangle are:    (1, 1), (1, 2), (2, 1)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)
     */

    static class Tuple {
        int x;
        int y;
        Tuple(int xCord, int yCord){
            this.x = xCord;
            this.y = yCord;
        }
    }

    public static void main(String[] args) {
       int[] A1 = {1, 1, 2};
       int[] B1 = {1, 2, 1};
       int[] A2 = {1, 1, 2, 3, 3};
       int[] B2 = {1, 2, 1, 2, 1};
        System.out.println(solve(A2,B2));
    }

    static int solve(int[] A, int[] B){
        /*
          brute force
          for the given inputs
          (1,1), (1,2), (2,1)
            l      m      n

          for 3 points to be a right angle triangle,
           for a point l ->
             if(l.x == m.x && l.y == n.y or l.y == m.y && l.x == n.x)
                 its a right angle triangle

              and same with m and n


         */
        int n = A.length;
        int count = 0;
        /*
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n;j++){
                for(int k = j+1; k<n;k++){
                    Tuple l = new Tuple(A[i], B[i]);
                    Tuple m = new Tuple(A[j], B[j]);
                    Tuple p = new Tuple(A[k],B[k]);
                    if(isRightAngle(l,m,p)){
                        count++;
                    }
                }
            }
        }
        return count;

         */
        /*
          Time complexity of this approach is O(n^3)
          S.C -> O(1)


          Optimized approach
          -> store all the x - cords to hashMap - MapX
          -> store all the y - cords to hashMap - MapY
          -> for a point l, if(MapX(l.x))
             a = MapX(l.x);
             b = MapY(l.y);
             count = count *(a-1)*(b-1)
         */
        HashMap<Integer, Integer> hx = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> hy = new HashMap<Integer, Integer>();
        // store all the x to hx
        for(int i = 0; i<n; i++){
            int key = A[i];
            if(hx.containsKey(key)){
                hx.put(key, hx.get(key)+1);
            }else{
                hx.put(key,1);
            }
        }

        // store all the y to hy
        for(int i = 0; i<n; i++){
            int key = B[i];
            if(hy.containsKey(key)){
                hy.put(key, hy.get(key)+1);
            }else{
                hy.put(key,1);
            }
        }

        for(int i = 0; i<n; i++){
            int a = hx.get(A[i]);
            int b = hy.get(B[i]);
            count = count + (a-1)*(b-1);
        }
        return count;

        /*
           T.C -> O(n)
           S.C -> O(n)
         */

    }

   static boolean isRightAngle(Tuple l, Tuple m, Tuple n){
        // l is pivot
        if((l.x == m.x  && l.y == n.y) || (l.y == m.y && l.x == n.x )){
            return true;
        }
        // m is pivot
        else if((m.x == l.x && m.y == n.y) || (m.y == l.y && m.x == n.x)){
            return true;
        }
        // n is pivot
        else if((n.x == l.x && n.y == m.y) || (n.y == l.y && n.x == m.x)){
            return true;
        }
        return false;

    }
}
