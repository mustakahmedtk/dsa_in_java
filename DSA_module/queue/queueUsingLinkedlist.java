package com.collection.DSA_module.Queue;


class Node{
    int val;
    Node next;
    Node(int data){
        this.val = data;
        this.next = null;
    }
}

public class QueueUsingLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

   public QueueUsingLinkedList(){

    }

    public void enque(int data){
       Node nn = new Node(data);
       if(head == null){
           head = nn;
           tail = nn;
       }else{
           tail.next = nn;
           tail = nn;
       }
       size++;
    }

    public int deque(){
       if(head == null){
           System.out.println("queue is empty");
           return -1;

       }
        Node temp = head;
        head = head.next;
        size--;
        return temp.val;
    }

    public int getFront(){
        if(head !=null) return head.val;
        return -1;
    }

    public int getSize(){
       return size;
    }

    public void printQueue(){
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
