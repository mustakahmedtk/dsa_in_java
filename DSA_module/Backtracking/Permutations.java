package Backtracking;

import java.util.ArrayList;

public class Permutations {
    static ArrayList<String> output = new ArrayList<>();
    static String inp = "abc";
    /*
       Problem Description
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.




Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible permutation of the array.



Example Input
A = 'abc'


Example Output
[ abc
  acb
  bac
  bca
  cab
  cba
]

     */

    public static void main(String args[]){
        //String input  = "abc";
        //ArrayList<String> result = permute(input);
        //System.out.println(result);
        permuteUsingBackTracking(0, inp.length());
        System.out.println(output);


    }



    // brute force solution using recursion
    /*
      below is the recursion tree that forms
                                           perm(abc)
                                               |
                                               |
            ..........................................................................
            |                                  |                                    |
          a+perm(be)                       b+perm(ac)                          c+perm(ab)
            |                                 |                                   |
            |                                 |                                   |
    .....................              .....................              ....................
    |                   |              |                   |              |                  |
  b+perm(c)            c+perm(b)       a+perm(c)          c+perm(a)       a+perm(b)         b+perm(a)
     |                    |             |                   |               |                 |
  .........            .........      .........           .........       ..........        ..........
  /////////             ////////      /////////           /////////        //////////        /////////

     */
    public static ArrayList<String> permute(String input){

        // sanity check
        if(input.length() == 0){
            return null;
        }
        // base case
        if(input.length() == 1){
            ArrayList<String> result = new ArrayList<>();
            result.add(input);
            return result;
        }
        // recursive calls
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i<input.length(); i++){
            char first = input.charAt(i);
            for(int st = 0; st<input.length(); st++){

                if(input.charAt(st) != first){
                    sb.append(input.charAt(st));
                }
            }

            String subProblemInput = sb.toString();
            sb.setLength(0);
            ArrayList<String> subProblemOutput = permute(subProblemInput);

            for(int j = 0; j<subProblemOutput.size();j++){
                result.add(first+subProblemOutput.get(j));
            }

        }
        return result;
    }

    /*
    the problem of the above approach is everytime we need to recreate the input for next tree which leads
    to more time complexity ,
    even though we improve , mathematically it is not possible to improve overall time complexity
    there for to for printing all the permutations , it will always take O(n!) Time complexity
    By using back tracking , we can reduce few steps and stack traces which we will use here
     */

    public static void permuteUsingBackTracking(int pos, int n){
        if(pos <0 || pos >= n) {
            return;
        }
        if(pos == n-1){
            output.add(inp);
           return;
        }
        for(int i = pos; i<inp.length(); i++){
            // do 
            swap(inp, i, pos);
            //recur
            permuteUsingBackTracking(pos+1, n);
            // undo
            swap(inp, i, pos);
        }

    }

    static void swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        inp = sb.toString();
    }

}
