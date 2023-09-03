package com.collection.DSA_module.LinkedList;
import java.util.*;

public class LRUCache {
    /*
      Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
     */
    public static void main(String[] args){
        LRUCache lru = new LRUCache(2);
        lru.set(1,10);
        lru.set(5, 12);
        System.out.println(lru.get(5));
        System.out.println(lru.get(1));
        System.out.println(lru.get(10));
        lru.set(6,5);
        System.out.println(lru.get(5));

    }


        class Node {
            int val;
            int key;
            Node next;
            Node prev;
            Node(int key, int val) {
                this.val = val;
                this.key = key;
                this.next = null;
                this.prev = null;
            }
        }
        int size = 0;
        Node head = null;
        Node tail = null;
        HashMap<Integer, Node> cache;
        private void insert(int key, int val) {
            Node newNode = new Node(key, val);
            cache.put(key, newNode);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        private void remove(int key) {
            if (cache.containsKey(key)) {
                if (head.key == key) {
                    head = head.next;
                    if (head != null)
                        head.prev = null;
                } else if (tail.key == key) {
                    tail = tail.prev;
                } else {
                    Node searchedElement = cache.get(key);
                    searchedElement.prev.next = searchedElement.next;
                    searchedElement.next.prev = searchedElement.prev;
                }
                cache.remove(key);
            }
        }
        public LRUCache(int capacity) {
            this.size = capacity;
            cache = new HashMap<Integer, Node>();
        }
        public int get(int key) {
            if (!cache.containsKey(key))
                return -1;
            Node searchedElement = cache.get(key);
            remove(key);
            insert(key, searchedElement.val);
            return searchedElement.val;
        }
        public void set(int key, int value) {
            if (cache.containsKey(key)) {
                remove(key);
            } else {
                if (cache.size() == this.size) {
                    remove(head.key);
                }
            }
            insert(key, value);
        }
    }
