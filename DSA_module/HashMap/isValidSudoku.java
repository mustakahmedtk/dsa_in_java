package com.collection.DSA_module.HashMap;

import java.util.HashSet;

public class isValidSudoku {
    /*
      Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
     */

    public static void main(String[] args) {
        String[] input = {
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        };
        System.out.println(solve(input));
    }

    static int solve(String[] input) {
        int n = input.length;
        int m = input[0].length();
        /*
          to check if a suduko board is valid or not , we need to simply check if below 3 condition satisfies or not

          -> Each row must have the numbers 1-9 occuring just once.
          -> Each column must have the numbers 1-9 occuring just once.
          -> And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.

          algorithm using HashSet
          ->iterate over each row wise to check if any character is repeating,
            if not then store in hashset and return true
          ->iterate column wise to check if a character is repeating,
            if not then store in hashset and return true
          -> iterate over 3*3 matrix(BOX) and check if any character is repeating,
          if not then store in hashset and return true

          for BOX iterating ->

           we can bound each row and column using mod by 3

            i.e startRow  =  row - row%3
                startCol = col - col%3
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isValid(input, i, j, n, m)) {
                    return 1;
                }
            }


        }
        return 0;
    }

    static boolean isValid(String[] A, int row, int col,int n, int m){
        if(notInRow(A,row,m) && notInCol(A,col,n) && notInBox(A,row-row%3,col-col%3)){
            return true;
        }
        return false;
    }

    static boolean notInRow(String[] A, int row, int m){
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i<m; i++){
            char ch = A[row].charAt(i);
            if(hs.contains(ch)){
                return false;
            }
            if(ch != '.'){
                hs.add(ch);
            }
        }
        return true;

    }

    static boolean notInCol(String[] A, int col, int n){
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i<n; i++){
            char ch = A[i].charAt(col);
            if(hs.contains(ch)){
                return false;
            }
            if(ch != '.'){
                hs.add(ch);
            }
        }
        return true;
    }

    static boolean notInBox(String[] A, int startRow, int startCol){
        HashSet<Character> hs = new HashSet<Character>();
        for(int row = 0; row<3;row++){
            for(int col = 0; col<3; col++){
                char ch = A[row+startRow].charAt(col+startCol);
                if(hs.contains(ch)){
                    return false;
                }
                if(ch != '.'){
                    hs.add(ch);
                }
            }
        }
        return true;
    }
}
