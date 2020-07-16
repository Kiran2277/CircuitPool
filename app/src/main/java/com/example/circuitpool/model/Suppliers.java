package com.example.circuitpool.model;

public class Suppliers {

    long supplier_id;
    String supplier_name;
    long account_id;

    public Suppliers() {
    }

    public Suppliers(long supplier_id, String supplier_name, long account_id) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.account_id = account_id;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplier_id=" + supplier_id +
                ", supplier_name='" + supplier_name + '\'' +
                ", account_id=" + account_id +
                '}';
    }


}
