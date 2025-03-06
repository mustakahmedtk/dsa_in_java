package DynamicProgramming;

public class MinimumNumberOfSquares {

    /*
       Problem Description

Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.



Problem Constraints

1 <= A <= 105



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the minimum count.



Example Input

Input 1:

 A = 6
Input 2:

 A = 5


Example Output

Output 1:

 3
Output 2:

 2


Example Explanation

Explanation 1:

 Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
 Minimum count of numbers, sum of whose squares is 6 is 3.
Explanation 2:

 We can represent 5 using only 2 numbers i.e. 1^2 + 2^2 = 5



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
Arg 1: A single Integer, For e.g 9
Enter Input Here

     */

    public static void main(String[] args){
        int n = 6;
        int[] mA = new int[n+1];
        for (int i = 0; i <= n; i++) {
            mA[i] = Integer.MAX_VALUE;
        }
        mA[0]=0;
        int result = findMinSquares(n, mA);
        System.out.println(result);

    }


    static int findMinSquares(int n, int[] mA){

        /*
            if we see the problem constrains , we can find out
            for a number N , the biggest square root will be

            = floor value(squareRoot(N))
            so for 20 , it will be 4
            minSquare(20)
                 |
                 minSquare(20-(4)^2)
                 minSquare(20-(3)^2)
                 .
                 .
                 .
                 minSquare(20-(1)^2)

            Top Down Approach

            -> element of choice
            minSquareSum(N) is our element of choice here


         */
        // Top Down Approach
        /*
       if(n == 0) return 0;

        if(mA[n] != -1){
            return mA[n];
        }

        int x = (int) Math.floor(Math.sqrt(n));

        int minimum = Integer.MAX_VALUE;
        for(int k = x; k>=1; k--){
            int newInput = k*k;
            minimum = Math.min(
                    minimum, (1+findMinSquares((n-newInput), mA))
            );

        }
        mA[n]=minimum;
        return mA[n];

         */



        // Bottom up approach

        for(int i = 1; i<=n; i++){
            for(int j = 1; j*j <=i ; j++){
                mA[i] = Math.min(mA[i], 1+mA[i-(j*j)]);
            }
        }
        return mA[n];



        // overall time complexity of this approach is O(n*root(n))

    }

}
