package com.example.circuitpool.model;

public class Orders {

    long order_id;
    long order_price;
    long supplier_id;
    long trans_id;
    String order_status;

    public Orders() {
    }

    public Orders(long order_id, long order_price, long supplier_id, long trans_id, String order_status) {
        this.order_id = order_id;
        this.order_price = order_price;
        this.supplier_id = supplier_id;
        this.trans_id = trans_id;
        this.order_status = order_status;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public long getOrder_price() {
        return order_price;
    }

    public void setOrder_price(long order_price) {
        this.order_price = order_price;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public long getTransaction_id() {
        return trans_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.trans_id = transaction_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", order_price=" + order_price +
                ", supplier_id=" + supplier_id +
                ", transaction_id=" + trans_id +
                ", order_status='" + order_status + '\'' +
                '}';
    }


}
