package com.collection.DSA_module.BinaryTree2;


import java.util.ArrayList;

class TreeNode{
    int data;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val){
        this.data = val;
    }

}



public class PreOrderTraversal {
    /*
       Problem Description
Given a binary tree, return the Postorder traversal of its nodes values.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the Postorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [3, 2, 1]
Output 2:

 [6, 3, 2, 1]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [3, 2, 1].
Explanation 2:

 The Preoder Traversal of the given tree is [6, 3, 2, 1].
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        traversal(root,ans);
        System.out.println(ans);
    }

   static void traversal(TreeNode root, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        ans.add(root.data);
        traversal(root.left,ans);
        traversal(root.right,ans);
   }
}
