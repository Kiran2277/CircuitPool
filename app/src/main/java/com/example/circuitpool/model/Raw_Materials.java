package com.example.circuitpool.model;

public class Raw_Materials {

    long material_id;
    long material_measure;
    long current_stock;
    long minimum_stock;
    String material_name;

    public Raw_Materials() {
    }

    public Raw_Materials(long material_id, long material_measure, long current_stock, long minimum_stock, String material_name) {
        this.material_id = material_id;
        this.material_measure = material_measure;
        this.current_stock = current_stock;
        this.minimum_stock = minimum_stock;
        this.material_name = material_name;
    }

    public long getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(long material_id) {
        this.material_id = material_id;
    }

    public long getMaterial_measure() {
        return material_measure;
    }

    public void setMaterial_measure(long material_measure) {
        this.material_measure = material_measure;
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

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    @Override
    public String toString() {
        return "Raw_Materials{" +
                "material_id=" + material_id +
                ", material_measure=" + material_measure +
                ", current_stock=" + current_stock +
                ", minimum_stock=" + minimum_stock +
                ", material_name=" + material_name +
                '}';
    }

}
