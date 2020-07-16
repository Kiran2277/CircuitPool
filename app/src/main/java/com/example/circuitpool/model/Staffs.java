package com.example.circuitpool.model;

public class Staffs {

    long staff_id;
    String staff_name;
    String staff_password;

    public Staffs() {
    }

    public Staffs(long staff_id, String staff_name, String staff_password) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.staff_password = staff_password;
    }

    public long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(long staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    @Override
    public String toString() {
        return "Staffs{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_password='" + staff_password + '\'' +
                '}';
    }


}
