package org.example.linkedList;

import org.w3c.dom.Node;


public class DeleteNthFromEnd {

    public DeleteNthFromEnd() {}
    public Node head;
    public class Node {
        int data;
        Node next;
        public Node(int d){
            data = d;
            next = null;
        }
    }

    public void deleteNode(int n) {
        Node first = head;
        Node second = head;

        for (int i=0;i<n;i++) {
            second = second.next;
        }
        while(second.next!= null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

    }

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void printList() {
        Node tNode = head;
        while(tNode!=null) {
            System.out.println(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {

        DeleteNthFromEnd node = new DeleteNthFromEnd();
        node.push(1);
        node.push(2);
        node.push(3);

        int key = 1;
        node.deleteNode(key);
        node.printList();
    }
}
