package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {
    /*
    Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the top view of the binary tree.



Example Input
Input 1:


            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Input 2:


            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
Output 1:

 [1, 2, 4, 8, 3, 7]
Output 2:

 [1, 2, 3]


Example Explanation
Explanation 1:

Top view is described.
Explanation 2:

Top view is described.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        topViewOfBinaryTree(root);

    }

    static  void topViewOfBinaryTree(TreeNode root){
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        int minL = 0;
        int maxL = 0;
        Tuple t = new Tuple(root, 0);
        q.add(t);
        while(q.size()>0){
            Tuple f = q.remove();
            TreeNode n = f.node;
            int l = f.level;
            minL = Math.min(minL, l);
            maxL = Math.max(maxL,l);
            if(hm.containsKey(l)){
                hm.get(l).add(n.data);
            }else{
                ArrayList<Integer> newA = new ArrayList<Integer>();
                newA.add(n.data);
                hm.put(l,newA);
            }
            if(n.left != null) q.add(new Tuple(n.left,l-1));
            if(n.right != null) q.add(new Tuple(n.right, l+1));
        }

        for(int i = minL; i<=maxL; i++){
            System.out.print(hm.get(i).get(0)+" ");
        }

    }
}
