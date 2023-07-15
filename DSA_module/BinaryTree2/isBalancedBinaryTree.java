package com.collection.DSA_module.BinaryTree2;

public class isBalancedBinaryTree {
    /*
      Problem Description
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the root of the tree A.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

    1
   / \
  2   3
Input 2:


       1
      /
     2
    /
   3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

It is a complete binary tree.
Explanation 2:

Because for the root node, left subtree has depth 2 and right subtree has depth 0.
Difference = 2 > 1.
     */
    static int isBalance = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        isBalanceBTree(root1);
        System.out.println(isBalance);

    }

    static int isBalanceBTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = isBalanceBTree(root.left);
        int rh = isBalanceBTree(root.right);
        if(Math.abs(lh-rh)>1){
            isBalance = 0;
        }
        return (1+Math.max(lh,rh));
    }


    /*
       T.C --> O(N);
       S.C --> O(H)-> Height of the tree
     */


}
