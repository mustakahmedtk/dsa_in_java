package DynamicProgramming;

public class FibonacciNumber {

    /*
    Problem Description

Given a positive integer A, write a program to find the Ath Fibonacci number.

In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.

NOTE: 0th term is 0. 1th term is 1 and so on.



Problem Constraints

0 <= A <= 44



Input Format

First and only argument is an integer A.



Output Format

Return an integer denoting the Ath Fibonacci number.



Example Input

Input 1:

 A = 4
Input 2:

 A = 6


Example Output

Output 1:

 3
Output 2:

 8


Example Explanation

Explanation 1:

 Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 0th term is 0 So, 4th term of Fibonacci series is 3.
Explanation 2:

 6th term of Fibonacci series is 8.
     */

    public static void main(String[] args){
        int input  = 8;
        int[] ma = new int[input+1];
        int result = findFib(input, ma);
        System.out.println(result);


    }

    static int findFib(int input, int[] ma){

        /*
           to find a FibonacciNumber number using recursion creates
           -> optimal substructure
           -> overlapping sub problem
           we can avoid calculating overlapping sub problems by memoizing them

           ex ->                 fib(3) can be acheive by
                                   / \
                              fib(2)  fib(1)
                                /  \
                            fib(1)  fib(0)

           when recursion traverse through left tree , it memoized fib(1) which then will be usefull  for the right tree and we don't have to recurse through right tree

         */
        if(input == 0 || input == 1) {
            ma[input] = input;
            return input;
        }

        int result = findFib(input-1, ma) + findFib(input-2, ma);
        ma[input] = result;
        return result;
    }
}
