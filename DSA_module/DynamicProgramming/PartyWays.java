package DynamicProgramming;

public class PartyWays {
    /*
       Problem Description

In Danceland, one person can party either alone or can pair up with another person.

Can you find in how many ways they can party if there are A people in Danceland?

Note: Return your answer modulo 10003, as the answer can be large.



Problem Constraints

1 <= A <= 105



Input Format

Given only argument A of type Integer, number of people in Danceland.



Output Format

Return an integer denoting the number of ways people of Danceland can party.



Example Input

Input 1:

 A = 3
Input 2:

 A = 5


Example Output

Output 1:

 4
Output 2:

 26


Example Explanation

Explanation 1:

 Let suppose three people are A, B, and C. There are only 4 ways to party
 (A, B, C) All party alone
 (AB, C) A and B party together and C party alone
 (AC, B) A and C party together and B party alone
 (BC, A) B and C party together and A
 here 4 % 10003 = 4, so answer is 4.

Explanation 2:

 Number of ways they can party are: 26.
     */

    public static void main(String[] args){
        int n = 5;
        int[] dp = new int[n+1];
        for(int i = 0; i<=n; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int result = partyWays(n, dp);
        System.out.println(result);
    }


    static int partyWays(int n, int[] dp){

        /*
           one can party either alone or together

           so , we have a choice to make on every trace

           to party ways(i) = alone ->  i.e ways(i-1) * 1
                                     +
                              double -> ways(i-2)*i-1

         */
        if(n == 0 || n == 1 || n == 2 || dp[n]!= -1){
            return dp[n];
        }

        int result = partyWays(n-1, dp) + (partyWays(n-2, dp)*(n-1));
        dp[n] = result;

        return result;

    }


}
