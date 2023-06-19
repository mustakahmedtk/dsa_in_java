package com.collection.DSA_module.LinkedList.LeastRecentlyUsed;

public class Client {
    public static void main(String[] args) {
        LRU lru = new LRU(5);
        lru.add(6);
        lru.add(7);
        lru.add(9);
        lru.add(10);
        lru.add(9);
        lru.add(13);
        lru.add(7);
        lru.add(10);
        lru.add(5);
        lru.printList();
    }
}
