package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftAndRightViewOfBinaryTree {
    /*
      Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9



Input Format
First and only argument is head of the binary tree A.



Output Format
Return an array, representing the right view of the binary tree.



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

 [1, 3, 7, 8]
Output 2:

 [1, 3, 4, 5]


Example Explanation
Explanation 1:

Right view is described.
Explanation 2:

Right view is described.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left= new TreeNode(8);

        System.out.println(leftView(root)+" left view");
        System.out.println(rightView(root)+" right view");

    }

    static ArrayList<Integer> leftView(TreeNode root){
        /*
           Intuition
           -----------

           By looking at the Tree , we can traverse from left to right

           1
           2 3
           4 5 6 7
           8

          -> if we look from left we will only see
           1 2 4 8 -> left view of binary tree

           -> if we look from right we will only see
           1 3 7 8 -> right view of binary tree

           -> left view and right view of binary tree together is called perimeter or boundry


         */
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        ans.add(root.data);
        while(q.size()>1){
            TreeNode f = q.remove();
            if(f == null){
                ans.add(q.peek().data);
                q.add(null);
            }else{
                if(f.left != null) q.add(f.left);
                if(f.right != null) q.add(f.right);
            }
        }
        return ans;
    }


    static ArrayList<Integer> rightView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        ans.add(root.data);
        while(q.size()>1){
            TreeNode f = q.remove();
            if(f == null){
                ans.add(q.peek().data);
                q.add(null);
            }else{
                if(f.right != null) q.add(f.right);
                if(f.left != null) q.add(f.left);
            }
        }
        return ans;

    }

    /*
       T.C --> O(N)
       S.C --> O(max elements in a level)
     */
}
