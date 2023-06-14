package com.collection.DSA_module.LinkedList;

public class MiddleNodeOfLinkedList {
    /*
      Problem Description
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints
1 <= length of the linked list <= 100000

1 <= Node value <= 109



Input Format
The only argument given head pointer of linked list.



Output Format
Return the middle element of the linked list.



Example Input
Input 1:

 1 -> 2 -> 3 -> 4 -> 5
Input 2:

 1 -> 5 -> 6 -> 2 -> 3 -> 4


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 The middle element is 3.
Explanation 2:

 The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(1,1);
        ll.insertAtPos(2,2);
        ll.insertAtPos(3,3);
        ll.insertAtPos(4,4);
        ll.insertAtPos(5,5);
        //ll.insertAtPos(6,6);

        System.out.println(solve(ll.head, ll.size));
    }

    static int solve(Node head, int size){
        if(head == null || head.next == null){
            return 0;
        }
        /*
          brute force approach
          -> count the size of linked list
          -> for even size,  traverse until (size/2)+1
          -> for odd size,   traverse until size/2
          -> hence we found the middle node

         */
        // count the size of linkedlist, in our case we have the size
        /*
        int length = size;
        if(length/2 == 0){
            length = (length/2)+1;
        }else{
            length = length/2;
        }
        Node current = head;
        int count = 0;
        while(count<length && current != null){
            current = current.next;
            count++;
        }
        return current.val;

         */
        /*
          T.C -> O(n)-> for counting the size + O(n/2)
          S.C -> O(1)


          better approach using slow and fast pointer approach


         */
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;

        /*
          T.C -> O(n)
          S.C -> O(1)
         */


    }
}
