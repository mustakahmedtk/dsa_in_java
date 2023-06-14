package com.collection.DSA_module.LinkedList;

public class ReverseKLinkList {
    /*
    Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.



Problem Constraints
1 <= |A| <= 103

B always divides A



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(1,1);
        ll.insertAtPos(2,2);
        ll.insertAtPos(3,3);
        ll.insertAtPos(4,4);
        ll.insertAtPos(5,5);
        ll.insertAtPos(6,6);
        ll.printLL();
        int B = 2;
        Node result = reverseKList(ll.head,B);
        ll.head = result;
        System.out.println("");
        ll.printLL();
        System.out.println("   after reversed");


    }
    static Node reverseKList(Node head, int B){
        /*
           approach to solve reverse k list
           -> lets take above input

           1->2->3->4->5->6

           -> divide each segments into B

           1->2    3->4    5->6

           -> reverse each segment

           2->1    4->3    6->5

           -> if we see , we can solve each sub problem recursively
           how to connect back the pointers is the challenge

           lets take some pointers

           after reversing we do
           prev pointer as 2
           but our head pointer still be 1
           2->1 -> reverseKlist(next subProblem == 3->4->5->6)
           1.next = reverseKlist(next subProblem == 3->4->5->6)

           2->1->4->3->reverseKlist(next sub problem == 5->6)

           at last the prev returns
           and we get
           2->1->4->3->6->5

         */
        if(head == null && head.next == null){
            return head;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while(count<B && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next != null){
            head.next = reverseKList(next,B);
        }
        return prev;

        /*
           the overall time complexity of this approach is O(n)
           and the space complexity is O(n/B)
         */


    }
}
