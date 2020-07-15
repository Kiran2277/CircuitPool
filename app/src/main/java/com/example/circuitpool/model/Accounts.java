package com.example.circuitpool.model;

public class Accounts {

    long id;
    String name;

    public Accounts(String name){
        this.name = name;
    }

    public Accounts(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Accounts() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
