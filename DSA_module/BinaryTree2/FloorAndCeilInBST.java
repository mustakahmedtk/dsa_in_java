package com.collection.DSA_module.BinaryTree2;

import java.util.ArrayList;

public class FloorAndCeilInBST {
    /*
      Problem Description
Given a Binary Search Tree rooted at A.

Given an integer array B of size N. Find the floor and ceil of every element of the array B.

Floor(X) is the highest element in the tree <= X, while the ceil(X) is the lowest element in the tree >= X.

NOTE: If floor or ceil of any element of B doesn't exists, output -1 for the value which doesn't exists.



Problem Constraints
0 <= Number of nodes in the tree <= 1000000
0 <= node values <= 109
0 <= N <= 100000
0 <= B[i] <= 109



Input Format
First argument represents the root of binary tree A.
Second argument is an integer array B.



Output Format
Return an integer array C of size N*2. C[i][0] denotes the floor value of B[i] and C[i][1] represents the ceil value of B[i] in the given tree.



Example Input
Input 1:

Given Tree A:
           10
         /    \
        4      15
       / \
      1   8
B = [4, 19]
Input 2:

Given Tree A:
            8
          /   \
         5     19
        / \     \
       4   7     100
B = [1, 11]


Example Output
Output 1:

[
    [4, 4]
    [15, -1]
]
Output 2:

[
    [-1, 4]
    [8, 19]
]


Example Explanation
Explanation 1:

The node with value 4 is present in the tree. So, for B[0] = 4, output is [4, 4] as both floor and ceil value is 4.

For B[1] = 19,
Highest element <= 19 is 15. So the floor value of 19 is 15.
19 is greater than all elements in the tree. So, the ceil value of 19 doesn't exists.
So, output is [15, -1].
Explanation 2:

For B[0] = 1,
There is no element in the tree <= 1. So, the floor value doesn't exists.
Lowest element >= 1 is 4. So, the ceil value is 4.
So, output is [-1, 4]

Similarily for B[1] = 11, output is [8, 19].
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        int[] B = {4, 19};
        ArrayList<ArrayList<Integer>> result = floorAndCeilBST(root,B);
        for(int i = 0; i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    static ArrayList<ArrayList<Integer>> floorAndCeilBST(TreeNode A,int[] B){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A == null) return result;
        int n = B.length;
        for(int i = 0; i<n;i++){
            int key = B[i];
            TreeNode root = A;
            int floor = -1;
            int ceil = -1;
            ArrayList<Integer> ans1 = new ArrayList<Integer>();
            while(root != null){
                if(root.data == key){
                    floor = root.data;
                    ceil = root.data;
                    break;
                }else if(root.data>key){
                    ceil = root.data;
                    root = root.left;
                }else{
                    floor = root.data;
                    root = root.right;
                }
            }
            ans1.add(floor);
            ans1.add(ceil);
            result.add(ans1);
        }
        return result;
    }

    /*
        T.C --> O(BH) where B is the length of B elements and H is the height of the tree
        S.C --> O(n^2) --> output space
     */
}
