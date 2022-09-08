package com.collection.DSA_module;

import java.util.LinkedList;
import java.util.Queue;

public class TaskScheduling {
    public static void main(String args[]){
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        queueTask(A,B);
    }


    public static int queueTask(int[] A, int[] B){
        /*
        * Problem Description
A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in array A and the required order of the tasks in array B.

Determine the minimum number of clock cycles to complete all the tasks.


Problem Constraints
1 <= N <= 1000
1 <= A[i], B[i] <= N


Input Format
First argument consist of integer array A.
Second argument consist of integer array B.


Output Format
Return an integer denoting the minimum number of clock cycles required to complete all the tasks.



Example Input
Input 1:

A = [2, 3, 1, 5, 4]
B = [1, 3, 5, 4, 2]
Input 2:

A = [1]
B = [1]


Example Output
Output 1:

 10
Output 2:

 1

        *
        *
        * */
        Queue<Integer> taskQ = new LinkedList<Integer>();
        Queue<Integer> priorityQ = new LinkedList<Integer>();
        for (int i = 0; i < A.length; i++) {
            taskQ.add(A[i]);
        }
        for (int j = 0; j < B.length; j++) {
            priorityQ.add(B[j]);
        }
        int count = 0;
        while (!taskQ.isEmpty() && !priorityQ.isEmpty()) {
            count++;
            if (taskQ.peek().equals(priorityQ.peek())) {
                taskQ.remove();
                priorityQ.remove();
            } else {
                int removable = taskQ.remove();
                taskQ.add(removable);
            }
        }
        return count;
    }
}
