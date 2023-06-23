package com.collection.DSA_module;


class Runner{
    public static void main(String args[]){
        queueUsingLinkedlist que = new queueUsingLinkedlist();
        que.enque(5);
        que.enque(4);
        que.enque(8);
        que.deque();
        que.print();
        System.out.print("front value is =====");
        System.out.println(que.getFront());
        System.out.print("Rear value is =====");
        System.out.println(que.getRear());
        System.out.print("size =====");
        System.out.println(que.getSize());
    }
}

public class queueUsingLinkedlist {
       Node Head;
       Node Tail;
       int size;
       queueUsingLinkedlist(){
           Head = null;
           Tail = null;
           size = 0;
       }

       void enque(int x){
           size++;
           Node newNode = new Node(x);
           if(Head ==null){
               Head = newNode;
               Tail = newNode;
           }else{
               Tail.next = newNode;
               Tail = Tail.next;

           }
       }
        int deque(){
           if(Head == null) return 0;
           size--;
           if(Head == Tail){
               Node temp = Head;
               Head = null;
               Tail = null;
               return temp.data;
           }else{
               Node Temp = Head;
               Head = Head.next;
               return Temp.data;
           }
       }
       int getFront(){
           if(Head !=null){
               return Head.data;
           }else{
               return 0;
           }
       }
       int getRear(){
           if(Tail !=null) return Tail.data;
           return 0;
       }
       int getSize(){
           return size;
       }
       void print(){
           Node current = Head;
           while(current !=null){
               System.out.print(current.data);
               current = current.next;
           }

       }

}


