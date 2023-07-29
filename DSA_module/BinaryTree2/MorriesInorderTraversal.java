package com.collection.DSA_module.BinaryTree2;

public class MorriesInorderTraversal {
    /*
        Given a Binary tree ,
           1
         /   \
        2     3
       / \
      4   5

      print it inorder traversal using Morris technique


      output --> 4 2 5 1 3
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        morriesTraversal(root);

    }

    static void morriesTraversal(TreeNode root){
        if(root == null) return;
        TreeNode current  = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data+" ");
                current = current.right;
            }
            else{
                TreeNode LST = current.left;
                TreeNode temp = LST;
                while(temp.right != null && temp.right != current){
                    temp = temp.right;
                }
                // first time visit
                if(temp.right == null){
                    // thread creation
                    temp.right = current;
                    current = current.left;
                }else if(temp.right == current){
                    temp.right = null;
                    System.out.print(current.data+" ");
                    current = current.right;
                }
            }
        }

        /*
            we traverse a node at max 4 times so T.C --> O(4n)-> O(n)
            S.C --> O(1)
         */

    }
}
