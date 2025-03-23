package DynamicProgramming;

public class EditDistance {
    /*
       Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
     */

    public static void main(String[] args){

        String s = "horse";
        String t = "ros";
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        int result  = bottomUpMinDistance(s,t); //MinDistance(n-1, m-1, dp, s,t);
        System.out.println(result);



    }

    static int MinDistance(int i, int j, int[][] dp, String s, String t){

        /*
           top down approach
            Element of choice ->

             if both character matches -> no operations

             if both character does not matches -> we can apply all the operations
             replace , add , delete

             dp[i][j] =
               if(s == t) =>  dp[i-1][j-1]
               else

                relace  = dp[i-1][j-1]
                add = dp[i][j-1]
                delete = dp[i-1][j]
                min(replace, add, delete)

                then

                final answer will be

                dp[n][m]

         */
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // base case
        if(i == 0 && j==0){
            if(s.charAt(i) == t.charAt(j)){
                dp[i][j] = 0;
                return 0;
            }else{
                dp[i][j] = 1;
                return 1;
            }
        }
        // rec rel
        if(s.charAt(i) == t.charAt(j)){
            return MinDistance(i-1, j-1, dp, s, t);
        }else{
            int min = Integer.MAX_VALUE;
            min = Math.min(min, 1+MinDistance(i-1, j-1, dp, s, t));
            min = Math.min(min, 1+MinDistance(i, j-1, dp, s, t));
            min = Math.min(min, 1+MinDistance(i-1, j, dp, s, t));
            dp[i][j] = min;
            return min;
        }

    }

    static int bottomUpMinDistance(String s, String t){
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];

        dp[0][0] = s.charAt(0) == t.charAt(0) ? 0: 1;

        // fill the column

        for(int i = 1; i<n; i++){
            dp[i][0] =dp[i-1][0] +1;
        }


        for(int j = 1; j<m; j++){
            dp[0][j] =dp[0][j-1] +1;
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, (1+dp[i-1][j-1]));
                    min = Math.min(min, (1+dp[i][j-1]));
                    min = Math.min(min, (1+dp[i-1][j]));
                    dp[i][j] = min;
                }
            }
        }

      return dp[s.length()-1][t.length()-1];


    }

    /*
      overall T.C of both the approach is
      O(nm)
      S.C -> O(nm)
     */
}
