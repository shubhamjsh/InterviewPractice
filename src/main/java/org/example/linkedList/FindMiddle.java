package org.example.linkedList;

public class FindMiddle {
     Node head;
    public FindMiddle() {}

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }


    public void push(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head= new_node;
    }

     public void fun() {
         Node slow = head;
         Node fast = head;
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         System.out.println(slow.data);
     }

    public static void main(String[] args) {
        FindMiddle fm = new FindMiddle();
        fm.push(1);
        fm.push(2);
        fm.push(3);
        fm.push(4);
        fm.fun();
    }

}
