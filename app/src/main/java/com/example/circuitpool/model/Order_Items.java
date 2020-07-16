package com.example.circuitpool.model;

public class Order_Items {

    long item_id;
    long order_id;
    long item_qty;
    long item_rate;

    public Order_Items() {
    }

    public Order_Items(long item_id, long order_id, long item_qty, long item_rate) {
        this.item_id = item_id;
        this.order_id = order_id;
        this.item_qty = item_qty;
        this.item_rate = item_rate;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(long item_qty) {
        this.item_qty = item_qty;
    }

    public long getItem_rate() {
        return item_rate;
    }

    public void setItem_rate(long item_rate) {
        this.item_rate = item_rate;
    }

    @Override
    public String toString() {
        return "Order_Items{" +
                "item_id=" + item_id +
                ", order_id=" + order_id +
                ", item_qty=" + item_qty +
                ", item_rate=" + item_rate +
                '}';
    }


}
