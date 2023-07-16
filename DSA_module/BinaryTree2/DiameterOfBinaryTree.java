package com.collection.DSA_module.BinaryTree2;

public class DiameterOfBinaryTree {
    static int ans = -1;
    /*
    Problem Description
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints
0 <= N <= 105



Input Format
First and only Argument represents the root of binary tree A.



Output Format
Return an single integer denoting the diameter of the tree.



Example Input
Input 1:

           1
         /   \
        2     3
       / \
      4   5
Input 2:

            1
          /   \
         2     3
        / \     \
       4   5     6


Example Output
Output 1:

 3
Output 2:

 4


Example Explanation
Explanation 1:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
Explanation 2:

 Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
         findDiameter(root);
        System.out.println(ans);
    }


    static int findDiameter(TreeNode root){

        /*
           diameter or longest path of a tree is nothing but

           height of left sub tree + height of right sub tree + edges of own i.e 2
           l+r+2
         */
        if(root == null) return -1;
        int l = findDiameter(root.left);
        int r = findDiameter(root.right);
        ans = Math.max(ans,(l+r+2));
        return (1+Math.max(l,r));

        /*
           T.C --> O(N)
           S.C --> O(H)-> hieght of the tree
         */
    }


}
