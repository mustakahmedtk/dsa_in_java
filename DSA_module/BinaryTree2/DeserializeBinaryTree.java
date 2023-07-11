package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
    /*
       Problem Description
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105



Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.



Output Format
Return the root node of the Binary Tree.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output
Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


Example Explanation
Explanation 1:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3, 4 and 5 each has both NULL child we had represented that using -1.
Explanation 2:

 Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1};
        TreeNode result = solve(A);
        LevelOrderTraversal.leverOrderT(result);

    }

    static TreeNode solve(int[] A){
        int n = A.length;
        if(n == 0) return null;
        if(n == 0) return new TreeNode(A[0]);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int rootValue = A[0];
        int index = 0;
        TreeNode root = new TreeNode(rootValue);
        q.add(root);
        while(q.size()>0){
            index++;
            TreeNode front = q.remove();
            int leftValue = A[index];
            front.left = leftValue == -1?null: new TreeNode(leftValue);
            index++;
            int rightValue = A[index];
            front.right = rightValue == -1?null: new TreeNode(rightValue);
            if(front.left != null) q.add(front.left);
            if(front.right != null) q.add(front.right);
        }
        return root;
    }

    /*
      T.C --> O(N)
      S.C --> O(N)

     */

}
