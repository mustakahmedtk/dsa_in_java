package Backtracking;

import java.util.*;

public class NQueen {
    /*
       Problem Description

The N-queens puzzle is the problem of placing N queens on an N×N chessboard such that no two queens attack each other.



Given an integer A denoting the value of N, return all distinct solutions to the N-queens puzzle.

Each solution contains a distinct board configuration of the N-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints

1 <= A <= 10



Input Format

First argument is an integer A denoting the size of chessboard



Output Format

Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.



Example Input

Input 1:

A = 4
Input 2:

A = 1


Example Output

Output 1:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Output 1:

[
 [Q]
]


Example Explanation

Explanation 1:

There exist only two distinct solutions to the 4-queens puzzle:
Explanation 1:

There exist only one distinct solutions to the 1-queens puzzle:
     */
    char[][] presentState = {
            {'.','.','.','.'},
            {'.','.','.','.'},
            {'.','.','.','.'},
            {'.','.','.','.'}
    }; // 4x4 matrix
    ArrayList<char[][]> result = new ArrayList<char[][]>();
    int qAlreadyPlaced = 0;
    HashMap<Integer, Boolean> hrow = new HashMap<>();
    HashMap<Integer, Boolean> hcol = new HashMap<>();
    HashMap<Integer, Boolean> hfd = new HashMap<>();
    HashMap<Integer, Boolean> hrd = new HashMap<>();
    int N = presentState.length;



    public static void main(String args[]){
        NQueen nqueen = new NQueen();

        nqueen.findQConfig(0,0);
        System.out.println("output");
        nqueen.printResult();


    }

    public void findQConfig(int x, int y){
        if(x<0 || y<0){
            return;
        }
        if(this.N == this.qAlreadyPlaced){
            // Store deep copy
            char[][] validBoard = new char[N][N];
            for (int i = 0; i < N; i++) {
                validBoard[i] = this.presentState[i].clone();
            }
            this.result.add(validBoard);
            return;
        }
        if(x>= this.N || y>=this.N){
            return;
        }

        // recursion
        // there is a two choice here to make which are
        // either place a queen
        // or not to place a queen

        // - I -  not placing a queen
        if(y<this.N-1){
            this.findQConfig(x,y+1);
        }else{
            this.findQConfig(x+1, 0);
        }


        // - II -  placing a queen
        if((!this.hrow.getOrDefault(x, false) &
                !this.hcol.getOrDefault(y, false) &&
                !this.hfd.getOrDefault(x - y, false) &&
                !this.hrd.getOrDefault(x + y, false))
        ){
            // do
            this.presentState[x][y] = 'Q';
            this.hrow.put(x, true);
            this.hcol.put(y, true);
            this.hfd.put((x-y),true);
            this.hrd.put(x+y,true);
            this.qAlreadyPlaced++;

            // recursive
            this.findQConfig(x+1, 0);

            // undo
            this.presentState[x][y] = '.';
            this.hrow.put(x, false);
            this.hcol.put(y, false);
            this.hfd.put((x-y),false);
            this.hrd.put(x+y,false);
            this.qAlreadyPlaced--;
        }


    }

    public void printResult() {
        for (char[][] board : this.result) {
            for (char[] row : board) {
                System.out.println(new String(row));
            }
            System.out.println();
        }
    }


}
