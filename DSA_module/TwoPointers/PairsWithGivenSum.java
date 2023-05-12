package com.collection.DSA_module.TwoPointers;

public class PairsWithGivenSum {
    /*
      Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:


A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.
     */
    public static void main(String[] args) {
        int[] input1 = {1,1,1};
        int sum1 = 2;
        int[] input2 = {2,2,3,4,4,5,6,7,10};
        int sum2 = 8;
        System.out.println(solve(input2, sum2));
    }

    static int solve(int[] input, int sum){
        int n = input.length;
        int pairs = 0;
        /*
           brute force
             simply run two loops , check sum and count paris
         */
       /*
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(input[i]+input[j] == sum){
                    pairs++;
                }
            }
        }
        return pairs;

        */
        /*
          time complexity of this approach is O(n^2);
          S.C is O(1)

          Optimized approach
          Observation
          =============
          as the array is sorted , we can use two pointers to solve this problem

          lets take the above input
          p1                                       p2
          2     2    3    4    4    5    6    7    10

          p1+p2 = 12>sum;
          decrement p2


          p1                                  p2
          2     2    3    4    4    5    6    7    10

         p1+p2 = 9>sum;
          decrement p2


          p1                            p2
          2     2    3    4    4    5    6    7    10

         p1+p2 = 8 == sum;
          counts = 2
          counte = 1
          current pairs = pairs +(counts*counte) = 2;
          we can move both p1 two moves until same value found and p2


                    p1              p2
          2     2    3    4    4    5    6    7    10

          p1+p2 = 8 == sum;
          counts = 1
          counte = 1
          current pairs = pairs +(counts*counte) = 3;
          we can move both p1 and p2 one step ahead;



                         p1    p2
          2     2    3    4    4    5    6    7    10

          here is an observation , when both p1 and p2 are same in sorted array


          p1..........................p2  in sorted array

           if  input[p1] == input[p2]

           it is 100% sure that from p1+1 to p2-1 are also same

           lets find the length -> len = p2-p1+1;
           we can choose pair of two from len i.e

            len
               (   =   (len*(len-1))/2
                2
            and simply we can return pais

            len = 4-3+1 = 2
            pairs = pairs+(2*(2-1))/2
                  =   3 +1
                  =  4

           hence there are 4 pairs

         */
        int p1 = 0;
        int p2 = n-1;
        while(p1<p2){
            int currSum = input[p1]+input[p2];
            if(sum == currSum){
                if(input[p1] == input[p2]){
                    int len = p2-p1+1;
                    pairs +=(len*(len-1))/2;
                    return pairs;
                }
                int counts = 0;
                int counte = 0;
                int x = input[p1];
                int y = input[p2];
                while(p1<n && (x == input[p1])){
                    counts++;
                    p1++;
                }
                while(p2>=0 && (y == input[p2])){
                    counte++;
                    p2--;
                }
                pairs +=(counts*counte);
            }
            else if(sum>currSum){
                p1++;
            }else{
                p2--;
            }

        }
        return pairs;

        /*
           Time complexity of this approach is O(n)
           Space complexity is O(1);
         */

    }
}
