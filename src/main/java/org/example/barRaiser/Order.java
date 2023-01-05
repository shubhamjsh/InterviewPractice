package org.example.barRaiser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order {

    public static class OrderPojo implements Comparable<OrderPojo>{

        private int orderId;
        private int amount;
        private String customer;

        public static class orderByAmount implements Comparator<OrderPojo> {
            @Override
            public int compare(OrderPojo o1, OrderPojo o2) {
                return o1.amount > o2.amount ? 1 : (o1.amount < o2.amount ? -1 : 0);
            }
        }

        public static class orderByCustomer implements Comparator<OrderPojo> {
            @Override
            public int compare(OrderPojo o1, OrderPojo o2) {
                return o1.customer.compareTo(o2.customer);
            }
        }

        public OrderPojo(int id, int amt, String cust) {
            this.orderId = id;
            this.amount = amt;
            this.customer = cust;
        }

        public int getAmount(){return amount;}
        public void setAmount(int amount) {this.amount = amount;}

        public int getOrderId() {return orderId;}
        public void setOrderId(int orderId) {this.orderId = orderId;}

        public String getCustomer(){ return customer;}
        public void setCustomer(String cust) { this.customer = cust;}
        @Override
        public int compareTo(OrderPojo o) {
            return this.orderId > o.orderId ? 1 : (this.orderId < o.orderId ? -1 : 0);
//            return 0;
        }
    }


    public static void main(String[] args) {
        OrderPojo ord1 = new OrderPojo(5, 1000, "apple");
        OrderPojo ord2 = new OrderPojo(1, 10000, "microsoft");
        OrderPojo ord3 = new OrderPojo(2, 2000, "windows");
        OrderPojo ord4 = new OrderPojo(3, 1, "bixby");

        List<OrderPojo> list = new ArrayList<>();
        list.add(ord1);
        list.add(ord2);
        list.add(ord3);
        list.add(ord4);

        Collections.sort(list);

        System.out.println(list);
    }
}
