package DynamicProgramming;

public class LongestIncresingSubsequence {

    /*
       Given an integer array nums, return the length of the longest strictly increasing subsequence.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

     */
    public static void main(String[] args){
        /*
           for given input
                          10  ,9  ,2  ,5  ,3  ,7  ,101  ,18

                    lets form DP array

                    by looking at the input , we can not choose LIS greedly , we have to explore all the options
                    -> there are overlapping sub problems and optimal substructure

                    -> element of choice is either we can take a number or not take a number


                  DP[i] = will be best answer till ith element

                  at i = 0 => 10

                  as this is first number , we can choose it


                    10  9  2  5  3  7  101  18

                    1

                  at i = 1 -> 9

                   as input[i]<input[i-1] so LIS is 1

                   10  9  2  5  3  7  101  18

                   1   1

                   at i = 2 -> 2

                   as input[i]<input[i-1] so LIS is 1

                   10  9  2  5  3  7  101  18

                   1   1  1

                   at i = 3 => 5

                   as input[i] > input[i-1] so we add 1+LIS(input-1) = > 2

                   10  9  2  5  3  7  101  18

                   1   1  1  2
                  and

                  so

                  on

                  at the DP array will be

                  10  9  2  5  3  7  101  18

                  1   1  1  2  2  3   4    1

                  maximum is 4



         */

        int[] input = {10,9,2,5,3,7,101,18};
        int n = input.length;
        int[] dp = new int[n];

        for(int i = 0; i<n; i++){
            dp[i] = -1;
        }

        int max = 1;
        for(int i = 0; i<n; i++){
            max = Math.max(max, LIS(input, n, dp, i));
        }
        System.out.println(max);

    }


    static int LIS(int[] input, int n, int[] dp, int i){
          if(i>=n || i<0){
              return -1;
          }

          if(dp[i] != -1){
              return dp[i];
          }

          if(i == 0){
              dp[i] = 1;
              return 1;
          }
          int max = 1;
          for(int j = i-1; j>=0; j--){
              if(input[i]> input[j]){
                  max = Math.max(max, (1+LIS(input, n, dp, j)));
              }
          }

          dp[i] = max;
          return dp[i];
    }
}
