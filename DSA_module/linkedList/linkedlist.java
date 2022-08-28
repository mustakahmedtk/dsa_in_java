package com.collection.DSA_module;
import java.util.ArrayList;
import java.util.HashMap;

class DSA_module {
    public static void main(String args[]) {
        Linkedlist llt = new Linkedlist();
        llt.addNodeToTheLast(23);
        llt.addNodeToTheLast(45);
        llt.addNodeToTheLast(65);
        llt.addNodeToTheLast(98);
        llt.addNodeToTheLast(32);
        llt.printLinkedList();
        llt.findMiddleNode();
        llt.size();
        llt.deleteMiddleNode();
        llt.printLinkedList();
        llt.size();
    }
}


class Linkedlist {
    Node head;
    int pos;

    Linkedlist() {
        this.head = null;
        this.pos = 0;
    }

    void addNewNode(int val) {
        System.out.println(val);
        Node newNode = new Node(val);
        newNode.next = this.head;
        head = newNode;
        this.pos++;
    }

    void addNodeToTheLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            this.pos++;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            this.pos++;
        }
    }

    void printLinkedList() {
        Node current = this.head;
        ArrayList<Number> list = new ArrayList<Number>();
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        System.out.println(list);
    }

    void findMiddleNode() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.print("middle node is ======>");
        System.out.println(slow.data);
    }

    void deleteMiddleNode() {
        Node slow = this.head;
        Node fast = this.head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
        if (slow != null) prev.next = slow.next;
        else prev.next = null;
    }

    void deleteatPos(int pos) {
        if (pos > this.pos) {
            System.out.print("out of bound, cant delete on the specified position");
            return;
        }
        pos--;
        Node current = this.head;
        Node prev = null;
        int length = 0;
        while (current != null && length < pos) {
            prev = current;
            current = current.next;
            length++;
        }
        if (current != null) prev.next = current.next;
        else prev.next = null;
        this.pos--;
        System.out.print("deleted node=============");
        System.out.println(current.data);
    }

    void size() {
        System.out.println(this.pos);
    }
}
