package DynamicProgramming;

public class Stairs {
    /*
     Stairs
You are climbing a staircase and it takes A steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007



Problem Constraints

1 <= A <= 105



Input Format

The first and the only argument contains an integer A, the number of steps.



Output Format

Return an integer, representing the number of ways to reach the top.



Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

 Distinct ways to reach top: [1, 1], [2].
Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1].



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

     */

    public static void main(String[] args){

        /*
            example ->

                basically if there are 2 stairs then either we can take
                1 step each or double step at one time

                2 = [1,1] , [2]
                for 3,
                3 = [1,1,1] , [1,2],[2,1]

         */
        int input  = 8;
        int[] ma = new int[input+1];
        int result = findWays(input, ma);
        System.out.println(result);

    }

    static int findWays(int n, int[] ma){
        if(n == 0 || n == 1){
            ma[n] = 1;
            return 1;
        }
        int result = findWays(n-1, ma) + findWays(n-2, ma);
        ma[n] = result;
        return result;
    }



}
