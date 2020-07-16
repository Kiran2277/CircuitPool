package com.example.circuitpool.model;

public class Shop_Owners {

    long shop_id;
    String shop_name;
    String shop_password;

    public Shop_Owners() {
    }

    public Shop_Owners(long shop_id, String shop_name, String shop_password) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_password = shop_password;
    }

    public long getShop_id() {
        return shop_id;
    }

    public void setShop_id(long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_password() {
        return shop_password;
    }

    public void setShop_password(String shop_password) {
        this.shop_password = shop_password;
    }

    @Override
    public String toString() {
        return "Shop_Owners{" +
                "shop_id=" + shop_id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_password='" + shop_password + '\'' +
                '}';
    }
}
