package com.collection.DSA_module.LinkedList;

public class RemoveLoopFromLinkedList {
    /*
      Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000



Input Format
The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.



Output Format
return the head of the updated linked list.



Example Input
Input 1:


1 -> 2
^    |
| - -
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
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
        listWithCycle.head = result;
        listWithCycle.printLL();
        //System.out.println(result.val);
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
           and reach prev point of that node and break the loop
           lets take slow as p1,
            head as p2
            prev as null;


           p1 = slow
           p2 = head
           keep moving until we p1 and p2 moves
           prev = 4
           p1 = 4.next
           p2 = 1.next

           prev = 5
           p1 = 5.next
           p2 = 2.next
           prev = 5
           p1 = 3
           p2 = 3
           make previous next is null
           prev.next = null

            hence we removed the loop from linkedlist
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
        Node prev = null;
        while(p1 != p2){
            prev = p2;
            p1 = p1.next;
            p2 = p2.next;

        }
        prev.next = null;
        return head;

    }
}
