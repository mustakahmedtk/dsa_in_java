package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalViewOfBinaryTree {

    /*
       Given a Tree,
             8
            / \
           9   6
            \   \
             2   10
            / \
           2   9
                \
                 4


       if we traverse the tree diagonally

       8 9
       6 2 2
       10 9
       4

      we can only see 8 6 10 4 from diagonal view

     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(9);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(10);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.right = new TreeNode(4);
        diagonalView(root);



    }

    static void diagonalView(TreeNode root){
        HashMap<Integer , ArrayList<TreeNode>> hm = new HashMap<Integer, ArrayList<TreeNode>>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.add(new Tuple(root,0));
        int max = 0;
        while(q.size()>0){
            Tuple f = q.remove();
            TreeNode t = f.node;
            int level = f.level;
            max = Math.max(max,level);
            if(hm.containsKey(level)){
                hm.get(level).add(t);
            }else{
                ArrayList<TreeNode> ar = new ArrayList<TreeNode>();
                ar.add(t);
                hm.put(level,ar);
            }
            if(t.left != null) q.add(new Tuple(t.left,level));
            if(t.right != null) q.add(new Tuple(t.right, level+1));
        }

        for(int i = 0; i<=max;i++){
            System.out.print(hm.get(i).get(0).data+" ");
        }

    }



}
