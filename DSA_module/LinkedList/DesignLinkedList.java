package com.collection.DSA_module.LinkedList;

public class DesignLinkedList {
    /*
    Problem Description
Design and implement a Linked List data structure.
A node in a linked list should have the following attributes - an integer value and a pointer to the next node.

It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space (no trailing spaces).
Note:

If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in a new line.


Problem Constraints
1 <= value <= 105
1 <= position <= n where, n is the size of the linked-list.



Input Format
First line contains an integer denoting number of cases, let's say t. Next t line denotes the cases.


Output Format
When there is a case of print_ll(), Print the entire linked list, such that each element is followed by a single space.

There should not be any trailing space.

NOTE: You don't need to return anything.


Example Input
Input 1:
5
i 1 23
i 2 24
p
d 1
p
Input 2:
3
i 1 54
d 10
p


Example Output
Output 1:
23 24
24
Output 2:
54


Example Explanation
Explanation 1:
After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.
Explanation 2:
After the first case,  linked list contains: 54

At second case delete value at 10th position,
Since the position is higher than the length of the linkedlist.
It does not satisfy the constraint, So no action is required.

At third case print: 54.
     */

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtPos(1,3);
        ll.insertAtPos(2,4);
        ll.insertAtPos(3,6);
        ll.printLL();
        ll.deleteNode(2);
        System.out.println("   deleted pos 2");
        ll.printLL();
    }
}


class Node{
    int val;
    Node next;
    Node(int data){
        this.val = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    int size;
    public LinkedList(){
        head = null;
        size = 0;
    }


    public void insertAtPos(int pos, int val){
        if(pos>=1 && pos<=size+1){
            Node newNode = new Node(val);
            if(pos ==1){
                newNode.next = head;
                head = newNode;
            }
            else{
                int count = 1;
                Node prev = head;
                while(count<pos-1){
                    prev = prev.next;
                    count++;
                }
                newNode.next = prev.next;
                prev.next = newNode;

            }
            size++;
        }


    }

    public void deleteNode(int pos){
        if(pos>=1 && pos<=size){
            if(pos == 1){
                head = head.next;
            }else{
                int count = 1;
                Node prev = head;
                while(count<pos-1){
                    prev = prev.next;
                    count++;
                }
                prev.next = prev.next.next;
            }
            size--;
        }
    }

    public void printLL(){
        Node temp = head;
        int flag = 0;
        while(temp != null){
            if(flag == 0){
                System.out.print(temp.val);
                flag = 1;
            }else{
                System.out.print(" "+temp.val);
            }
            temp = temp.next;
        }
    }


}
