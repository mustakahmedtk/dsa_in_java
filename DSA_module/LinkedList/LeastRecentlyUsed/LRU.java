package com.collection.DSA_module.LinkedList.LeastRecentlyUsed;
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node prev;
   public Node(int data){
        this.val = data;
        this.next = null;
        this.prev = null;

    }
}

public class LRU {
   public int size;
   private int count = 0;
   private Node head = null;
   private Node tail = null;
   private HashMap<Integer,Node> nodes = new HashMap<Integer, Node>();

    public LRU(int length){
        this.size = length;
    }


    private void insertAtBack(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            }
        nodes.put(val,newNode);
        count++;
    }



    private Node search(int val){
        return nodes.get(val);
    }

    private void remove(Node node){
        nodes.remove(node.val);
        if(node == head){
            head = head.next;
            head.prev = null;
        }else{
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

    }

    public void add(int val){
        Node searchedElement = search(val);
         if(searchedElement != null){
            remove(searchedElement);
         }else{
            if(count == size){
                // remove at first
                remove(head);
            }
         }
        insertAtBack(val);

    }

    public void printList(){
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

    /*
       all operations like search , insert and remove takes O(1) time complexity
       And as we are using hashMap , the space complexity becomes O(n);
     */






}
