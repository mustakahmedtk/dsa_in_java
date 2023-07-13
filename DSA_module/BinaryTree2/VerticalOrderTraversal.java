package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Tuple{
    TreeNode node;
    int level;
    Tuple(TreeNode n, int l){
        this.node = n;
        this.level = l;
    }

}

public class VerticalOrderTraversal {
    /*
      Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        verticalOrderTraversal(root);
    }

    static void verticalOrderTraversal(TreeNode root){
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        int minL = 0;
        int maxL = 0;
        Tuple t = new Tuple(root, 0);
        q.add(t);
        while(q.size()>0){
            Tuple f = q.remove();
            TreeNode n = f.node;
            int l = f.level;
            minL = Math.min(minL, l);
            maxL = Math.max(maxL,l);
            if(hm.containsKey(l)){
                hm.get(l).add(n.data);
            }else{
                ArrayList<Integer> newA = new ArrayList<Integer>();
                newA.add(n.data);
                hm.put(l,newA);
            }
            if(n.left != null) q.add(new Tuple(n.left,l-1));
            if(n.right != null) q.add(new Tuple(n.right, l+1));
        }

        for(int i = minL; i<=maxL; i++){
            System.out.println(hm.get(i));
        }
    }
}
