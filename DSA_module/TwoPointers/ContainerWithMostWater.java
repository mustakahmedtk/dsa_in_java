package com.collection.DSA_module.TwoPointers;

public class ContainerWithMostWater {
    /*
      Problem Description
Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.



Problem Constraints
0 <= N <= 105

1 <= A[i] <= 105



Input Format
Single Argument representing a 1-D array A.



Output Format
Return single Integer denoting the maximum area you can obtain.



Example Input
Input 1:

A = [1, 5, 4, 3]
Input 2:

A = [1]


Example Output
Output 1:

 6
Output 2:

 0


Example Explanation
Explanation 1:


5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
So total area = 3 * 2 = 6
Explanation 2:


No container is formed.
     */
    public static void main(String[] args) {
        int[] input = {1, 5, 4, 3};
        System.out.println(solve(input));
    }

    static int solve(int[] A){
        /*
           brute force approach

           simply iterate over the array with two loops one is starting from i and another i+1
           and calculate max water container
         */
        int n = A.length;
        int maxWater = Integer.MIN_VALUE;
        /*
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int height = Math.min(A[i],A[j]);
                int width = j-i;
                int area = height*width;
                maxWater = Math.max(area, maxWater);
            }
        }
        return maxWater;

         */


        // the time complexity of this approach is O(n^2) and space complexity is O(1)
        /*
          better approach using two pointers
          using two pointers p1 and p2 from two ends of array
          the width of the container will be calculated as p2-p1
          and height will the min(input(p1),input(p2))
          lets take the input
          p1         p2
          0   1   2  3
          1   5   4  3

          width = 3-0
          height = min(1,3) = 1
          area = height*width
               = 1*3
               = 3 (current maximum area)
          as min is p1 so we increment p1
             p1      p2
          0   1   2  3
          1   5   4  3


          width = 3-1 = 2
          height = min(5,3) = 3
          area = height*width
               = 3*2
               = 6 (current maximum area)

        as min is p2 so we will decrement p2
              p1  p2
          0   1   2  3
          1   5   4  3
        width = 2-1 = 1
          height = min(4,5) = 4
          area = height*width
               = 4*1
               = as 4 < 6 so it remains (current maximum area)

         hence we got the maximum area;


         */
        int p1 = 0;
        int p2 = n-1;
        int width = p2-p1;
        while(p1<p2){
            int height = Math.min(A[p1],A[p2]);
            int area = width*height;
            maxWater = Math.max(area, maxWater);
            if(A[p1] == height){
                p1++;
            }
            else{
                p2--;
            }
            width--;
        }
        return maxWater;

        // the overall time complexity of this approach is O(n) and S.C is O(1)
    }
}
