package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.Stack;

public class KthSmallestElementInBST {
    /*
       Problem Description
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an integer, representing the Bth element.



Example Input
Input 1:


            2
          /   \
         1    3
B = 2
Input 2:


            3
           /
          2
         /
        1
B = 1



Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

2nd element is 2.
Explanation 2:

1st element is 1.
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode(2);
        A.left = new TreeNode(1);
        A.right = new TreeNode(3);
        int k = 2;
        System.out.println(solve(A,k));
    }

    static int solve(TreeNode A, int k){
        /*
           brute force approach
           -> simply do inorder traversal
           -> get the k-1 index from array
           -> as inorder traversal of BST always sorted

         */
        /*
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        InOrderTraversal.traversal(A,inorder);
        return inorder.get(k-1);

         */
        /*
          T.C --> O(N)
          S.C --> O(N)

          better Approach
          -----------------
          the idea is to stop once we reach to kth element
          recursively we can do it and print when we reach to kth element
          but stack trace will still get executed and reach to last return function


          Iterative approach can be a better solution
         */
        Stack<TreeNode> st = new Stack<TreeNode>();
        int done = 0;
        while(true){
            while(A != null){
                st.push(A);
                A = A.left;
            }
            done = done+1;
            TreeNode root = st.pop();
            if(done == k){
                return root.data;
            }
            A = root.right;
        }

        /*
           T.C --> O(H)+O(K)
           S.C --> O(H)
         */

    }
}
