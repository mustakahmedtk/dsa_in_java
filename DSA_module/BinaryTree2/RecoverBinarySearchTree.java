package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
    /*
    Problem Description
Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).

A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

Note: The 2 values must be returned in ascending order



Problem Constraints
1 <= size of tree <= 100000



Input Format
First and only argument is the head of the tree,A



Output Format
Return the 2 elements which need to be swapped.



Example Input
Input 1:

         1
        / \
       2   3
Input 2:


         2
        / \
       3   1



Example Output
Output 1:

 [2, 1]
Output 2:

 [3, 1]


Example Explanation
Explanation 1:

Swapping 1 and 2 will change the BST to be
         2
        / \
       1   3
which is a valid BST
Explanation 2:

Swapping 1 and 3 will change the BST to be
         2
        / \
       1   3
which is a valid BST
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[] result = recoverTree(root);
        System.out.println(result[0]+" , "+result[1]);
    }

    static int[] recoverTree(TreeNode root){
        /*
          Brute force approach
          -> inorder traversal of the tree
          -> store all the elements of  in an arraylist
          -> create two pairs of array
          -> loop over the array and find the distortion
          -> if we find only find one pair of distortion then simply return the pair
          -> if two pairs are found then max from the first pair and min from the second pair will be returned
         */
        ArrayList<Integer> ar = new ArrayList<Integer>();
        InOrderTraversal.traversal(root,ar);
        int[] pair1 = new int[2];
        int[] pair2 = new int[2];
        int index = 0;
        boolean pair2Exist = false;
        for(int i = 1; i<ar.size();i++){
            if(ar.get(i-1)>ar.get(i)){
                pair1[0] = ar.get(i-1);
                pair1[1] = ar.get(i);
                index = i;
                break;
            }
        }

        for(int i = index+1; i<ar.size();i++){
            if(ar.get(i-1)>ar.get(i)){
                pair2[0] = ar.get(i-1);
                pair2[1] = ar.get(i);
                pair2Exist = true;
                break;
            }

        }
        if(pair2Exist == false) return pair1;
        int[] result = new int[2];
        result[0] = Math.max(pair1[0],pair1[1]);
        result[1] = Math.min(pair2[0],pair2[1]);
        return result;

    }

    /*
       the brute force approach takes O(N) time complexity
       and O(H)+O(N) space complexity
     */
}
