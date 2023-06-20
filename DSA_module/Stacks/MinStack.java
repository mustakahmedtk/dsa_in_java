package com.collection.DSA_module.Stacks;



class Tuple{
    int val;
    int currentMin;
    Tuple(int data, int min){
        this.val = data;
        this.currentMin = min;
    }

}

class Node<T>{
  T node;
  Node next;

   Node(T data){
      this.node =  data;
      this.next = null;
  }
}

public class MinStack {
    Node head = null;
    int size = 0;
    int currentMin = Integer.MAX_VALUE;

    public void push(int val){
        currentMin = currentMin>val?val:currentMin;
        Tuple t = new Tuple(val, currentMin);
        Node<Tuple> nn = new Node<Tuple>(t);
        nn.next = head;
        head = nn;
        size++;
    }

    public int pop(){
        if(head == null){
            System.out.println("stack is empty");
            return 0;
        }
        Tuple t = (Tuple) head.node;
        head = head.next;
        size--;
        return t.val;

    }

    public int top(){
        if(head == null){
            System.out.println("stack is empty");
            return 0;
        }
        else{
            Tuple t = (Tuple) head.node;
            return t.val;
        }

    }

    public int getSize(){
        return size;
    }

    public int getMin(){
        if(head == null){
            System.out.println("stack is empty");
            return 0;
        }
        Tuple t = (Tuple) head.node;
        return t.currentMin;
    }
}
