package org.example.linkedList;


//Leetcode 83
public class RemoveDuplicate {

    Node head;
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
        public Node(){}
    }

    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public static Node deleteDuplicates(Node head) {
        Node res = head;
        while(head != null) {
            if(head.data == head.next.data){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicate node = new RemoveDuplicate();
        node.push(3);
        node.push(2);
        node.push(1);
        node.push(1);
        node.push(0);



        deleteDuplicates(node.head);
    }

}
