package com.collection.DSA_module;


import java.util.*;

class Interval {
    int start;
    int end;
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }
    void printInterVal(){
        System.out.print(this.start +":"+this.end);
        System.out.println("");
    }
}

public class MergeOverlappingIntervals {
    /*
    Problem Description
Given a collection of intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.



Input Format
First argument is a list of intervals.



Output Format
Return the sorted list of intervals after merging all the overlapping intervals.



Example Input
Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output
Output 1:

[1,6],[8,10],[15,18]


Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
     */

    public static void main(String[] args){
        ArrayList<Interval> input = new ArrayList<Interval>();
        int[][] arrInput = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        for(int i = 0; i<arrInput.length;i++){
            Interval newInterval = new Interval(arrInput[i][0],arrInput[i][1]);
            input.add(newInterval);
        }
        ArrayList<Interval> result = solve(input);
        System.out.println(result+"result");
        for(int i = 0 ; i<result.size();i++){
            Interval pair = result.get(i);
            pair.printInterVal();
        }
        System.out.println("");

    }


    static ArrayList<Interval> solve(ArrayList<Interval> A){
         /*
        Sort the intervals based on the increasing order of starting time.
        Push the first interval into a stack.
        For each interval do the following:
        If the current interval does not overlap with the top of the stack then, push the current interval into the stack.
        If the current interval overlap with the top of the stack then, update the stack top with the ending time of the current interval.
        The end stack contains the merged intervals.
         */
         int n = A.size();
         ArrayList<Interval> result = new ArrayList<Interval>();
         if(n == 0) return result;
         // sort the arraylist based on start time
        Collections.sort(A, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Stack<Interval> st = new Stack<Interval>();
        // push the first interval into stack
        st.push(A.get(0));
        for(int i = 1; i<n; i++){
            Interval top = st.peek();
            if(A.get(i).start>top.end){
                st.push(A.get(i));
            }
            else if(A.get(i).end>top.end){
                top.end = A.get(i).end;
                st.pop();
                st.push(top);
            }

        }
        // push all the intervals from stack to Arraylist
        while(st.size()>0){
            result.add(st.pop());
        }

        // sort the result array
        Collections.sort(result, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        return result;
    }
}
