package org.example.linkedList;

import java.util.concurrent.atomic.DoubleAccumulator;

public class MergeSortedList {

    
    Node head;
    public MergeSortedList() {}
    public class Node {
        int val;
        Node next;
        public Node() {}

        public Node(int data) {
            this.val = data;
//            next = null;
        }

//        public void push(int data) {
//            Node new_node = new Node(data);
//            new_node.next = head;
//            head = new_node;
//        }
    }

    public Node push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        return new_node;
    }

    public Node fun(Node list1, Node list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val > list2.val) {
            Node temp = list1;
            list1 = list2;
            list2 = temp;

        }
        Node res = list1;
        while(list1 != null && list2 != null) {
            Node tmp = null;
            while(list1 != null && list1.val <= list2.val) {
                tmp = list1;
                list1 = list1.next;

            }
            tmp.next = list2;
            Node temp = list1;
            list1 = list2;
            list2 = temp;
        }
        printList(res);
        return res;
    }

    public static void main(String[] args) {
        MergeSortedList msl1 = new MergeSortedList();
        MergeSortedList msl2 = new MergeSortedList();

//        Node n1 = 
//        Node msl2 = msl1.head;
        msl1.push(1);
        msl1.push(3);
        msl1.push(5);

        msl2.push(2);
        msl2.push(4);
        msl2.push(6);
        msl2.push(8);


        msl1.fun(msl1.head, msl2.head);

    }

    public void printList(Node res) {
//        MergeSortedList.Node tNode = head;
        while(res!=null) {
            System.out.println(res.val + " ");
            res = res.next;
        }
    }

}
