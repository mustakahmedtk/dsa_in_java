package com.collection.DSA_module.LinkedList;

public class DetectCycleInLinkedList {
    /*
      Problem Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example:

Input:

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3.
     */

    public static void main(String[] args) {

        LinkedList listWithCycle = new LinkedList();
        listWithCycle.insertAtPos(1,1);
        listWithCycle.insertAtPos(2,2);
        listWithCycle.insertAtPos(3,3);
        listWithCycle.insertAtPos(4,4);
        listWithCycle.insertAtPos(5,5);
        Node current = listWithCycle.head;
        Node prev = null;
        while(current != null){
            prev = current;
            current = current.next;
        }
        Node temp = listWithCycle.head;
        Node tNode = temp.next.next;
        prev.next = tNode;
        Node result = solve(listWithCycle.head);
        System.out.println(result.val);
    }

    static Node solve(Node head){
        /*
           we can solve this using slow and fast pointer

           1->2->3->4->5
                /|\    |
                 |-----|

           slow = 1.next  ------> slow moves x
           fast = 1.next.next -------> fast moves 2x

           slow = 2.next
           fast = 3.next.next

           slow = 3.next
           fast = 5.next.next

           slow = 4  }
           fast = 4  }   so slow and fast meet at point 4

           so we have found out the meeting point of slow and fast and hence there is a loop

           our task is to now find out where the loop begins
           lets take slow as p1
           and head as p2

           p1 = slow
           p2 = head
           keep moving until we p1 and p2 moves

           p1 = 4.next
           p2 = 1.next

           p1 = 5.next
           p2 = 2.next

           p1 = 3
           p2 = 3

           both p1 and p2 are equal , hence we have found the node where the loop starts

         the overall time complexity of this approach is O(n)

         */
        if(head == null && head.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow != fast){
            return null;
        }
        Node p1 = head;
        Node p2 = slow;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

}
