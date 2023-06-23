package com.collection.DSA_module.Queue;

public class Client {
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enque(3);
        queue.enque(5);
        queue.enque(8);
        queue.enque(9);
        queue.printQueue();
        System.out.println(queue.getFront()+"  front element");
        System.out.println(queue.deque());
        System.out.println(queue.deque());
        System.out.println(queue.getFront()+"  front element");
        System.out.println(queue.getSize()+"size of the queue");

    }
}
