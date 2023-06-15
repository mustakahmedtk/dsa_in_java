package com.collection.DSA_module.LinkedList;

public class DeleteMiddleElement {
    /*
      Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

Return the head of the linked list after removing the middle node.

If the input linked list has 1 node, then this node should be deleted and a null node should be returned.


Input Format

The only argument given is the node pointing to the head node of the linked list
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(1,1);
        ll.insertAtPos(2,2);
        ll.insertAtPos(3,3);
        ll.insertAtPos(4,4);
        ll.insertAtPos(5,5);
        ll.printLL();
        Node result = solve(ll.head);
        ll.head = result;
        System.out.println(" ");
        ll.printLL();
        System.out.println("  after deleting");
    }

    static Node solve(Node head){
        if(head == null || head.next == null) return null;
        /*
           using slow and fast technique
         */
        Node prev = head;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;

        /*
           T.C -> O(n)
         */
    }
}
