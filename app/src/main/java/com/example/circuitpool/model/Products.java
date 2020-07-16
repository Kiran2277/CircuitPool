package com.example.circuitpool.model;

public class Products {

    long product_id;
    long current_stock;
    long minimum_stock;
    String product_name;

    public Products() {
    }

    public Products(long product_id, long current_stock, long minimum_stock, String product_name) {
        this.product_id = product_id;
        this.current_stock = current_stock;
        this.minimum_stock = minimum_stock;
        this.product_name = product_name;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getCurrent_stock() {
        return current_stock;
    }

    public void setCurrent_stock(long current_stock) {
        this.current_stock = current_stock;
    }

    public long getMinimum_stock() {
        return minimum_stock;
    }

    public void setMinimum_stock(long minimum_stock) {
        this.minimum_stock = minimum_stock;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", current_stock=" + current_stock +
                ", minimum_stock=" + minimum_stock +
                ", product_name='" + product_name + '\'' +
                '}';
    }


}
