package com.collection.DSA_module.GreedyAlgorithm;

import java.util.ArrayList;

public class FindMaximumJobs {
    /*
       Problem Description
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish.



Problem Constraints
1 <= N <= 105

1 <= A[i] < B[i] <= 109



Input Format
The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.



Output Format
Return an integer denoting the maximum number of jobs you can finish.



Example Input
Input 1:

 A = [1, 5, 7, 1]
 B = [7, 8, 8, 8]
Input 2:

 A = [3, 2, 6]
 B = [9, 8, 9]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 We can finish the job in the period of time: (1, 7) and (7, 8).
Explanation 2:

 Since all three jobs collide with each other. We can do only 1 job.
     */
    static class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Pair A) {
            return (this.end-A.end);
        }

    }

    public static void main(String[] args) {
        int[] A = {1, 5, 7, 1};
        int[] B = {7, 8, 8, 8};
        System.out.println(solve(A,B));
    }

    static int solve(int[] A, int[] B){
        int n = A.length;
        Pair[] jobTimes = new Pair[n];
        for(int i = 0; i<n; i++){
            int start = A[i];
            int end = B[i];
            jobTimes[i] = new Pair(start,end);
        }
        Pair lastPicked = jobTimes[0];
        int ans = 1;
        int length = 1;
        while(length< jobTimes.length){
            Pair t = jobTimes[length];
            if(t.start>=lastPicked.end){
                ans++;
                lastPicked = t;
            }
            length++;
        }

        return ans;


    }

    /*
        T.C ---> O(nlogn);
        S.C ---> O(n);
     */
}
