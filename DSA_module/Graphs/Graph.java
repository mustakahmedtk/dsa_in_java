package com.collection.DSA_module;

import java.util.*;

public class Graph {
    private int noOfVertices;
    private LinkedList<Integer> adjacencyList[];
    Graph(int noOfVertices){
        this.noOfVertices = noOfVertices;
        this.adjacencyList = new LinkedList[noOfVertices];
        for(int i = 0; i<noOfVertices; i++){
            this.adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int from , int to){
        this.adjacencyList[from].add(to);
        this.adjacencyList[to].add(from);
    }

    void BreadthFirstSearch(int vertex){
        boolean[] vertices = new boolean[noOfVertices];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(vertex);
        vertices[vertex] = true;
        while(!q.isEmpty()){
            vertex = q.poll();
            System.out.print(vertex + " ");
            for(int n:adjacencyList[vertex]){
                if(vertices[n]!=true){
                    q.add(n);
                    vertices[n] = true;
                }

            }

        }

    }

    public static void main(String args[]){
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        //System.out.println(graph.adjacencyList);
        graph.BreadthFirstSearch(1);


    }


}
