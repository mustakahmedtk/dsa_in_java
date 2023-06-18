package com.collection.DSA_module.LinkedList;

import java.util.List;

public class MergeTwoLists {
    /*
    Problem Description
Merge two sorted linked lists, A and B, and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists and should also be sorted.



Problem Constraints
0 <= |A|, |B| <= 105



Input Format
The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format
Return a pointer to the head of the merged linked list.



Example Input
Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
Input 2:

 A = 1 -> 2 -> 3
 B = Null


Example Output
Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
Output 2:

 1 -> 2 -> 3


Example Explanation
Explanation 1:

 Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
Explanation 2:

 We don't need to merge as B is empty.
     */

    public static void main(String[] args) {
        LinkedList A = new LinkedList();
        LinkedList B = new LinkedList();
        A.insertAtPos(1,5);
        A.insertAtPos(2,8);
        A.insertAtPos(3,20);
        B.insertAtPos(1,4);
        B.insertAtPos(2,11);
        B.insertAtPos(3,15);
        LinkedList result = new LinkedList();
        result.head = solve(A.head,B.head);
        result.printLL();

    }

    static Node solve(Node A, Node B){
        if(A == null && B == null) return null;
        if(A == null) return B;
        if(B == null) return A;
        Node p1 = A;
        Node p2 = B;
        Node head = null;
        Node temp = null;
        while(p1 != null && p2 != null){
            if(p1.val<=p2.val){
                if(head == null){
                    head = p1;
                    temp = p1;
                }else{
                    temp.next = p1;
                    temp = p1;
                }
                p1 = p1.next;
            }else if(p2.val<=p1.val){
                if(head == null){
                    head = p2;
                    temp = p2;
                }else{
                    temp.next = p2;
                    temp = p2;
                }
                p2 = p2.next;
            }
        }
        while(p1 != null){
            temp.next = p1;
            temp = p1;
            p1 = p1.next;
        }

        while(p2 != null){
            temp.next = p2;
            temp = p2;
            p2 = p2.next;
        }
        return head;

        /*
           the Time Complexity of this approach is O(N+M)
         */
    }
}
