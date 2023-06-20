package com.collection.DSA_module;


 class classRunner{
    public static void main(String args[]){
        stackUsingLinkedList st = new stackUsingLinkedList();
        st.push(4);
        st.push(5);
        st.push(7);
        st.size();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
    }

}


class List{
     int data;
     List next;
     List(int data){
         this.data = data;
         this.next = null;
     }
}




public class stackUsingLinkedList {
    List stack;
    int size;
    stackUsingLinkedList(){
         this.stack = null;
         this.size = 0;
    }

    public void push(int val){
        List newNode = new List(val);
        newNode.next = this.stack;
        this.stack = newNode;
        this.size++;
    }

    public int pop(){
        if(this.stack == null) {
            return 0;
        }
        List current = this.stack;
        int val = current.data;
        this.stack = current.next;
        this.size--;
        return val;
    }

    public int size(){
        return this.size;
    }

    public int peek(){
        return this.stack!=null?this.stack.data:0;
    }
}
