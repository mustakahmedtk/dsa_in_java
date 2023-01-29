package com.collection.DSA_module;


import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {
    /*
    Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
     */
    public static void main(String[] args){
           ArrayList<Interval> input = new ArrayList<Interval>();
           Interval i1 = new Interval(1,3);
           Interval i2 = new Interval(6,9);
           Interval intervalToMerge = new Interval(2,5);
           input.add(i1);
           input.add(i2);
           ArrayList<Interval> result = solve(input, intervalToMerge);
           for(int i = 0;i<result.size();i++){
               result.get(i).printInterVal();
           }

    }

    static ArrayList<Interval> solve(ArrayList<Interval> A, Interval newInterval){
        if(A.size() == 0) return new ArrayList<Interval>();
        // insert the new interval in input arraylist
        A.add(newInterval);

        int n = A.size();
        ArrayList<Interval> output = new ArrayList<Interval>();
        // sort the arraylist
        Collections.sort(A, new Comparator<Interval>() {
            @Override
            public int compare(Interval l1, Interval l2) {
                return (l1.start-l2.start);
            }
        });
        Stack<Interval> st = new Stack<Interval>();
        // adding first interval into stack
        st.add(A.get(0));
        for(int i = 1; i<n; i++){
            Interval top = st.peek();
            Interval current = A.get(i);
            // since we have sorted the start of all the interval now comparison becomes easy
            if(current.start>top.end){
                st.push(current);
            }
            else if(current.end>top.end){
                top.end = current.end;
                st.pop();
                st.push(top);
            }

        }
       // poping out from stack and pushing in arraylist;
        while(st.size()>0){
            output.add(st.pop());
        }

        // sort the output array
        Collections.sort(output, new Comparator<Interval>() {
            @Override
            public int compare(Interval l1, Interval l2) {
                return (l1.start-l2.start);
            }
        });

        return output;

        // overall time complexity of this approach is O(nlogn);
        // space complexity is O(n); where n is no of intervals;


    }
}
