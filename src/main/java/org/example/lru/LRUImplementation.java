package org.example.lru;

import java.util.*;

public class LRUImplementation {
    private Deque<Integer> queue;
    private HashSet<Integer> set;
    private final int cache_size;

    HashMap<Integer, Integer> map;


    public LRUImplementation(int capacity) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        cache_size = capacity;
        map = new HashMap<>();
    }

    public void refer(int page) {
        if(!set.contains(page)) {
            if(queue.size() == cache_size) {
                int last = queue.removeLast();
                set.remove(last);
            }
        }
        else {
            queue.remove(page);
        }
        queue.push(page);
        set.add(page);
    }

    public void display() {
        for(Integer s : set) {
            System.out.print(s + " ");
        }
    }

    public boolean search(int page) {
        if(set.contains(page))
            return true;
        return false;
    }

    public static void main(String[] args) {
        LRUImplementation obj = new LRUImplementation(6);
        obj.refer(1);
        obj.refer(2);
        obj.refer(3);
        obj.refer(1);
        obj.refer(4);
        obj.refer(5);
        obj.refer(6);
        obj.refer(10);
        System.out.println(obj.search(2));
        obj.display();

    }

}
