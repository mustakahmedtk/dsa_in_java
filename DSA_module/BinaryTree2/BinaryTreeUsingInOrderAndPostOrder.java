package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeUsingInOrderAndPostOrder {
    /*
       Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.



Output Format
Return the root node of the binary tree.



Example Input
Input 1:

 A = [2, 1, 3]
 B = [2, 3, 1]
Input 2:

 A = [6, 1, 3, 2]
 B = [6, 3, 2, 1]


Example Output
Output 1:

   1
  / \
 2   3
Output 2:

   1
  / \
 6   2
    /
   3


Example Explanation
Explanation 1:

 Create the binary tree and return the root node of the tree.
     */

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, 1, 3, 2));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(6, 3, 2, 1));
        TreeNode tree = BuildTree(A,B);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PreOrderTraversal.traversal(tree,ans);
        System.out.println(ans);

    }

    static TreeNode BuildTree(ArrayList<Integer> A, ArrayList<Integer> B){
        /*
            solution approach
            -> by looking at the post order traversal , we can predict that root is in the last index
            -> once we get the root now , we can segregate the left inOrder and right InOrder from InorderTraversal
            array.
            -> now using the same inroder Index we can segregate the leftPostOrder and rightPostOrder.
            -> now create the root tree using Bth last index value
            -> now ask the same question recursively to root.left = builtTree and root.right = buildTree

         */
              int n = A.size();
              if(n == 0) return null;
              if(n == 1) return new TreeNode(A.get(0));
              int rootValue = B.get(B.size()-1);
              int InOrderRootIndex = 0;
              // find the rootIndex in inOrderIndex
                for(int i = 0; i<n; i++){
                    if(A.get(i) == rootValue){
                        InOrderRootIndex = i;
                        break;
                    }
                }

                ArrayList<Integer> leftInOderList = new ArrayList<Integer>();
                ArrayList<Integer> rightInOderList = new ArrayList<Integer>();

                for(int i = 0; i<InOrderRootIndex;i++){
                    leftInOderList.add(A.get(i));
                }

                for(int i = InOrderRootIndex+1; i<n;i++){
                    rightInOderList.add(A.get(i));
                }

                ArrayList<Integer> leftPostOderList = new ArrayList<Integer>();
                ArrayList<Integer> rightPostOderList = new ArrayList<Integer>();


                for(int i = 0; i<InOrderRootIndex;i++){
                    leftPostOderList.add(B.get(i));
                }

                for(int i = InOrderRootIndex; i<n-1; i++){
                    rightPostOderList.add(B.get(i));
                }

                TreeNode root = new TreeNode(rootValue);
                root.left = BuildTree(leftInOderList,leftPostOderList);
                root.right = BuildTree(rightInOderList, rightPostOderList);
                return root;

                /*
                   T.C --> O(N^2)
                   S.C --> O(N^2)
                 */

    }
}
