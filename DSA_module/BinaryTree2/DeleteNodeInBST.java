package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;

public class DeleteNodeInBST {
    /* Given a BST, delete a node 15 from BST
          10
         / \
        3   15
       / \  / \
      2   8 13 20

      output :
          10
         / \
        3   20
       / \  / \
      2   8 13 null
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);
       TreeNode newRoot =  deleteNode(root,15);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        InOrderTraversal.traversal(newRoot, ans);
        System.out.println(ans);

    }

    static TreeNode deleteNode(TreeNode root, int k){
        if(root == null) return root;
        if(root.data == k){
            // case 1
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null || root.right == null){
                if(root.left != null){
                    return root.left;
                }
                if(root.right != null){
                    return root.right;
                }
            }else{
                int x = findMin(root.right);
                root.data = x;
                root.right = deleteNode(root.right,x);
                return root;
            }
        }
        if(root.data>k){
            root.left = deleteNode(root.left,k);
        }else{
            root.right = deleteNode(root.right,k);
        }

        return root;

    }

    static int findMin(TreeNode t){
        int min = Integer.MAX_VALUE;
        if(t == null) return min;
        while(t != null){
            min = Math.min(min,t.data);
            if(t.left != null){
                t = t.left;
            }else{
                t = t.right;
            }
        }
        return min;

    }

    /*
       T.C --> O(H*H)
       S.C --> O(H)
     */
}
