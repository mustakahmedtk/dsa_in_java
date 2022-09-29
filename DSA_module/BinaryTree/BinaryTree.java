package com.collection.DSA_module;


//import jdk.internal.net.http.common.Pair;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    }

}

class Pair implements Comparable<Pair>{
    TreeNode first;
    int second;
    Pair( TreeNode node, int length){
        first = node;
        second = length;
    }
    @Override
    public int compareTo(Pair o) {
        return 0;
    }
}



class classRunner1 {

    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        BinaryTree bt = new BinaryTree();
        root.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(78);
        root.left.left = new TreeNode(9);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(10);
        root.right.right.right = new TreeNode(12);
        //bt.preOrder(root);
        //bt.inOrder(root);
        //bt.postOrder(root);
        ArrayList<ArrayList<Integer>> result =  bt.verticalOrderTraversal(root);
        System.out.println(result);

    }
}

public class BinaryTree {
    TreeNode root;

    BinaryTree(){
        root = null;
    }


    public static void preOrder(TreeNode A){
          if(A == null) return;
          System.out.print(A.val);
          System.out.print(' ');
          preOrder(A.left);
          preOrder(A.right);
    }
    public static void inOrder(TreeNode A){
        if(A == null) return;
        preOrder(A.left);
        System.out.print(A.val);
        System.out.print(' ');
        preOrder(A.right);
    }
    public static void postOrder(TreeNode A){
        if(A == null) return;
        preOrder(A.left);
        preOrder(A.right);
        System.out.print(A.val);
        System.out.print(' ');
    }

     public ArrayList<ArrayList<Integer>>  verticalOrderTraversal(TreeNode A){
         HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         Queue < Pair > q = new LinkedList < Pair > ();
         int minh = 0;
         int maxh = 0;
         q.add(new Pair(A, 0));
         while(q.size()>0){
             Pair f = q.remove();
             TreeNode t = f.first;
             int l = f.second;
             ArrayList<Integer> ar = new ArrayList<Integer>();
             if(hm.containsKey(l)) {
                 ar = hm.get(l);
                 ar.add(t.val);
             }
             else {
                 ar.add(t.val);
             }
             hm.put(l, ar);
             minh = Math.min(minh, l);
             maxh = Math.max(maxh, l);
             if(t.left != null){
                 q.add(new Pair(t.left, l-1));
             }
             if(t.right != null){
                 q.add(new Pair(t.right, l+1));
             }
         }

         for(int i = minh; i<=maxh;i++){
             result.add(hm.get(i));

         }
         return result;

     }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if(A == null) return arr;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(A);
        Q.add(null);
        int firstLevel = 0;
        int secondLevel = 0;
        while(Q.size()>1){
            TreeNode f = Q.peek();
            Q.remove();
            if(f == null){
                firstLevel++;
                Q.add(null);
                secondLevel = 0;
            }else{
                while(arr.size()<=firstLevel){
                    arr.add(new ArrayList<Integer>());
                }
                while(arr.get(firstLevel).size()<secondLevel){
                    arr.get(firstLevel).add(0);
                }
                arr.get(firstLevel).add(secondLevel,f.val);
                secondLevel++;
                if(f.left !=null){
                    Q.add(f.left);
                }
                if(f.right != null){
                    Q.add(f.right);
                }
            }
        }
        return arr;
    }


}
