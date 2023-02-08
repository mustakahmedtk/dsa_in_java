package com.collection.DSA_module;

public class FindingGoodDays {
    /*
      Problem Description
Alex has a cat named Boomer. He decides to put his cat to the test for eternity.

He starts on day 1 with one stash of food unit, every next day, the stash doubles.

If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.

Boomer receives a net worth of A units of food. What is the number of days she received the stash?



Problem Constraints
1 <= A <= 231-1



Input Format
First and only argument is an integer A.



Output Format
Return an integer denoting the number of days Boomer was well behaved.



Example Input
Input 1:

A = 5
Input 2:

A = 8


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.
Explanation 2:

 To eat a total of 8 units of food, Boomer behaved normally only on day 4.

     */

    public static void main(String[] args){
        int input  = 5;
        System.out.println(solve(input));

    }

    static int solve(int A){
        // for input 5
        // 1,2,3,4,5
        // 1-> 3 -> 5
        // 1 and 3
        int count  = 0;
        while(A>0){
            count +=A%2;
            A = A/2;
        }
        return count;
        // time complexity is O(n)
        // space complexity is O(1)
    }
}
