package com.collection.DSA_module.BinaryTree2;

public class IsIdenticalTree {
    /*
      Problem Description
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints
1 <= number of nodes <= 105



Input Format
The first argument is a root node of the first tree, A.

The second argument is a root node of the second tree, B.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ) for this problem.



Example Input
Input 1:

   1       1
  / \     / \
 2   3   2   3
Input 2:

   1       1
  / \     / \
 2   3   3   3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Both trees are structurally identical and the nodes have the same value.
Explanation 2:

 Values of the left child of the root node of the trees are different.
     */

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(2);
        B.right = new TreeNode(3);
        boolean isSameTree = solve(A,B);
        System.out.println(isSameTree);

    }

    static boolean solve(TreeNode A, TreeNode B){
        if(A == null && B == null){
            return true;
        }
        if(A == null || B == null){
            return false;
        }
        if(A.data != B.data){
            return false;
        }
        return (solve(A.left,B.left) && solve(A.right,B.right));

    }

    /*

       T.C --> O(N)
       S.C --> O(H-> height of the tree)
     */


}
