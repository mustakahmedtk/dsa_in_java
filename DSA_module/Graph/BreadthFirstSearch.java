package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    /*

    given a undirected graph ,

    A = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]


        build adjacencyList and traverse using BFS and DFS .

        print all the node .

     */



    public static void main(String[] args){
        int[][] matrix = {
                {1, 2},
                {4, 1},
                {2, 4},
                {3, 4},
                {5, 2},
                {1, 3}
        };


        int v = matrix.length;

        LinkedList<Integer>[] adjacencyList = new LinkedList[v+1];
        for (int i = 0; i <= v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }

        Boolean[] visited = new Boolean[v+1];
        Arrays.fill(visited, false);


        for(int i = 0; i<v; i++){
            // from
            adjacencyList[matrix[i][0]].add(matrix[i][1]);

            // to
            adjacencyList[matrix[i][1]].add(matrix[i][0]);

        }

        //BFS(1, v, adjacencyList, visited);
        DFS(1, v, adjacencyList, visited);

    }


    static void BFS(int vertex, int v, LinkedList<Integer>[] adjacencyList, Boolean visited[]){

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(vertex);
        visited[vertex] = true;

        while(!q.isEmpty()){
            vertex = q.poll();
            System.out.println(vertex);
            for(int n : adjacencyList[vertex]){
                if(visited[n] != true){
                    visited[n] = true;
                    q.add(n);
                }
            }
        }

    }


    static void DFS(int vertex, int v, LinkedList<Integer>[] adjacencyList, Boolean visited[]){
        visited[vertex] = true;
        System.out.println(vertex);

        for(int n: adjacencyList[vertex]){
            if(visited[n] !=true){
                DFS(n, v, adjacencyList, visited);
            }
        }

    }










}
