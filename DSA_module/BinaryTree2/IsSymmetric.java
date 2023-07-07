package com.collection.DSA_module.BinaryTree2;

public class IsSymmetric {
    /*
       Problem Description
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is the root node of the binary tree.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ).



Example Input
Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:

    1
   / \
  2   2
   \   \
   3    3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The above binary tree is symmetric.
Explanation 2:

The above binary tree is not symmetric.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        boolean isSymmetric = solve(root.left, root.right);
        System.out.println(isSymmetric);

    }


    static boolean solve(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.data != right.data){
            return true;
        }
        return (solve(left.left, right.right) && solve(left.right, right.left));
    }


    /*
       T.C --> O(N)
       S.C --> O(H)
     */
}
