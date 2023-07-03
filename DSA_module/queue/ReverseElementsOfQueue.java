package com.collection.DSA_module.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseElementsOfQueue {
    /*
       Problem Description
Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
leaving the other elements in the same relative order.

NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.


Problem Constraints
1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000


Input Format
The argument given is the integer array A and an integer B.


Output Format
Return an array of integer after reversing the first B elements of A using queue.


Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 3
Input 2:

 A = [5, 17, 100, 11]
 B = 2


Example Output
Output 1:

 [3, 2, 1, 4, 5]
Output 2:

 [17, 5, 100, 11]


Example Explanation
Explanation 1:

 Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
Explanation 2:

 Reverse first 2 elements so the array becomes [17, 5, 100, 11]
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(solve(A,B));
    }

    static ArrayList<Integer> solve(int[] A, int B){
        /*
            solution approach
            -> insert all the elements in a queue
            -> create a stack
            -> now deque B elements from queue and push to stack
            -> pop out all the elements from stack and enque in queue
            -> at last , keep dequing and enqueing from queue upto (size-B) times
            -> hence we reversed B elements in queue
         */
        int n = A.length;
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        // add all elements in queue
        for(int i = 0; i<n; i++){
            q.add(A[i]);
        }
        // deque B elements from queue and push to stack
        for(int i = 0; i<B; i++){
            st.push(q.remove());
        }
        //pop out all the elements from stack and enque in queue
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        // keep dequing and enqueing from queue upto (size-B) times
        for(int i = 0; i<n-B; i++){
            int temp = q.remove();
            q.add(temp);
        }
        while(!q.isEmpty()){
            result.add(q.remove());
        }
        return result;

        /*
            T.C --> O(N)
            S.C --> O(N)
         */



    }
}
