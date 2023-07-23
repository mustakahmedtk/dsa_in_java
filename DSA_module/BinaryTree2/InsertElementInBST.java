package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;

public class InsertElementInBST {
    static TreeNode root = null;
    /*
       Given a list of numbers

       60,30,90,70,40,50

       construct a binary search tree
     */
    public static void main(String[] args) {

        ArrayList<Integer> ans = new ArrayList<Integer>();
        createBST(60);
        createBST(30);
        createBST(90);
        createBST(70);
        createBST(40);
        createBST(50);
        InOrderTraversal.traversal(root,ans);
        System.out.println(ans);
    }


    static void createBST(int val){
        root = constructTree(root,val);
    }

    static TreeNode constructTree(TreeNode root,int key){
        if(root == null){
            root = new TreeNode(key);
            return root;
        }
        if(root.data>key){
            root.left = constructTree(root.left, key);
        }else{
            root.right = constructTree(root.right, key);
        }
        return root;
    }
}
