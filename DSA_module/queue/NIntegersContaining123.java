package com.collection.DSA_module.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContaining123 {
    /*
       Q2. N integers containing only 1, 2 & 3
Solved
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.



Problem Constraints
1 <= A <= 29500



Input Format
The only argument given is integer A.



Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.



Example Input
Input 1:

 A = 3
Input 2:

 A = 7


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation
Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
     */

    public static void main(String[] args) {
        int input  = 7;
        System.out.println(solve(input));
    }

    static ArrayList<Integer> solve(int A){
        /*
           Solution approach
           -> create a queue and insert 1, 2 3 into it
           -> start a loop until ans size<A
           -> on every loop deque an element and enque (deque*10+1), (deque*10+2),(deque*10+3)
           -> also take care if your count reaches to A before you enque
           -> increment your count to count+3
         */
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        int n = 3;
        while(ans.size()<A){
            int temp = q.remove();
            ans.add(temp);
            if(n>=A) continue;
            q.add((temp*10+1));
            q.add((temp*10+2));
            q.add((temp*10+3));
            n = n+3;

        }
        return ans;
        /*
           T.C --> O(N)
           S.C --> O(N)
         */
    }
}
