package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {

    /*
      Problem Description

Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return 1 if path exists between node 1 to node A else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]


Example Output

Output 1:

 0
Output 2:

 1


Example Explanation

Explanation 1:

 The given doens't contain any path from node 1 to node 5 so we will return 0.
Explanation 2:

 Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
     */


    public static void main(String args[]){
       int  A = 5;
       int[][] B = {  {1, 2},
                      {2, 3},
                      {3, 4},
                      {4, 5}
                   };


        LinkedList<Integer>[] adjacencyList = new LinkedList[A+1];

        for(int i = 0; i<=A; i++){
            adjacencyList[i] = new LinkedList<Integer>();
        }
        int[] visited = new int[A+1];

        Arrays.fill(visited, -1);

        for(int i = 0; i<B.length; i++){
            adjacencyList[B[i][0]].add(B[i][1]);
        }

        int result =  BFS(adjacencyList, visited, 1, A);

        System.out.println(result);

    }

    static int BFS(LinkedList<Integer>[] adjacencyList, int[] visited, int source, int dest) {

        visited[source] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(source);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) return 1;

            for (int n : adjacencyList[node]) {
                if (visited[n] == -1) {
                    visited[n] = 1;
                    q.add(n);
                }

            }

        }
        return 0;

    }
}
