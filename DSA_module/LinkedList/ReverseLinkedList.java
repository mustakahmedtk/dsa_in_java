package com.collection.DSA_module.LinkedList;

public class ReverseLinkedList {
    /*
      Problem Description
You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.

NOTE: You have to do it in-place and in one-pass.



Problem Constraints
1 <= Length of linked list <= 105

Value of each node is within the range of a 32-bit integer.



Input Format
First and only argument is a linked-list node A.



Output Format
Return a linked-list node denoting the head of the reversed linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
Input 2:

 A = 3 -> NULL


Example Output
Output 1:

 5 -> 4 -> 3 -> 2 -> 1 -> NULL
Output 2:

 3 -> NULL


Example Explanation
Explanation 1:

 The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL
Expalantion 2:

 The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(1,3);
        ll.insertAtPos(2,4);
        ll.insertAtPos(3,6);
        ll.insertAtPos(4,9);
        ll.insertAtPos(5,11);
        ll.printLL();
        Node result = solve(ll.head);
        ll.head = result;
        System.out.println("");
        ll.printLL();
        System.out.println("   after reversing");

    }

    static Node solve(Node head){
        /*
           given an input

           A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
           lets take
           temp as  = null
           current  = 1;
           nextnode as  = 2
           current -> next should now point to previous
           1 -> null
           update previous now as current
           prev = 1;
           current = 2;
           -> keep doing the above step until we reach to null
           -> at last return the prev as head pointer
         */
        if(head == null || head.next == null) return head;
        Node current = head;
        Node prev = null;
        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;

        // the time complexity of this appraoch is O(n);

    }

}
