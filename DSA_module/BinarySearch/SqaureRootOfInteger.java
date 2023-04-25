package com.collection.DSA_module.BinarySearch;

public class SqaureRootOfInteger {
    /*
      Problem Description
Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.

NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.



Problem Constraints
0 <= A <= 1010



Input Format
The first and only argument given is the integer A.



Output Format
Return floor(sqrt(A))



Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation:

 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.
     */

    public static void main(String[] args) {
        int input1 = 11;
        int input2 = 9;
        System.out.println(solve(input2));


    }

    static int solve(int input){
                /*
          lets take the input as

           11 ->
               |
               left                                     right
               1    2   3   4   5   6   7   8   9   10   11
                                   -------------------------
                                          rejected
               mid = 1+11/2 ~ 6 and 6*6 = 36> 11

               left            right
               1    2   3   4   5
           ---------------
                rejected
               mid = 1+5/2 ~ 3 and 3*3  = 9 <11 we can consider 3 as the ans and proceed further

                left  right
                 4    5

                 mid  = 4 + 5/2 ~ 4 and 4 * 4  = 16 > 11  === 3 still remains the ans

         */
        int start = 1;
        int end = input;
        int ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if((mid*mid) == input){
                return mid;
            }
            else if(mid*mid>input){
                end = mid-1;
            }else{
                start = mid+1;
                ans = mid; // since we can consider the ans as lesser number incase of non perfect square no
            }
        }
        return ans;
    }

    // the overall time complexity of this approach is O(logn);

}
