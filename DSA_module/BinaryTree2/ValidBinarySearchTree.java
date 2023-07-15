package com.collection.DSA_module.BinaryTree2;

public class ValidBinarySearchTree {
    /*
       Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 2^32-1



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:


   1
  /  \
 2    3
Input 2:


  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.
     */
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
       boolean isValidBST = isBST(root2, l,r);
        System.out.println(isValidBST);
    }

    static boolean isBST(TreeNode root, int l, int r){
        if(root == null) return true;
        return (root.data>=l && root.data<=r && isBST(root.left,l,root.data-1) &&
                isBST(root.right , root.data+1,r));
    }

    /*
       T.C --> O(N);
       S.C --> O(H); -> height of the tree
     */
}
