package Backtracking;

public class UniquePaths {
    /*
       Problem Description
Given a matrix of integers A of size N x M . There are 4 types of squares in it:

1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



Example Input
Input 1:

A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:

A = [   [0, 1]
        [2, 0]    ]


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:

There are no such paths.
     */

    static int[][] input;
    static int ways = 0;
    static int noOfUnblockCells = 0;
    static int startX = -1, startY = -1;

    public static void main(String[] args) {
        input = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        // Find start and count walkable cells
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (input[i][j] != -1) {
                    noOfUnblockCells++;
                }
            }
        }

        findWays(startX, startY);

        System.out.println(ways);
    }

    public static void findWays(int x, int y) {
        // sanity check
        if (x < 0 || y < 0 || x >= input.length || y >= input[0].length || input[x][y] == -1) {
            return;
        }

        // base case
        if (input[x][y] == 2) {
            if (noOfUnblockCells == 1) {
                ways++;
            }
            return;
        }

        // do
        int temp = input[x][y];
        input[x][y] = -1; // Mark as visited
        noOfUnblockCells--;

        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {

            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            // recur
            findWays(nextX, nextY);
        }

        // undo
        input[x][y] = temp;
        noOfUnblockCells++;
    }
}
