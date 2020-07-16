package com.example.circuitpool.model;

public class Transactions {

    long trans_id;
    long trans_credit;
    long trans_debit;
    long trans_balance;
    String trans_particle;
    long from_account_id;
    long to_account_id;

    public Transactions() {
    }

    public Transactions(long trans_id, long trans_credit, long trans_debit, long trans_balance, String trans_particle, long from_account_id, long to_account_id) {
        this.trans_id = trans_id;
        this.trans_credit = trans_credit;
        this.trans_debit = trans_debit;
        this.trans_balance = trans_balance;
        this.trans_particle = trans_particle;
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
    }

    public long getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(long trans_id) {
        this.trans_id = trans_id;
    }

    public long getTrans_credit() {
        return trans_credit;
    }

    public void setTrans_credit(long trans_credit) {
        this.trans_credit = trans_credit;
    }

    public long getTrans_debit() {
        return trans_debit;
    }

    public void setTrans_debit(long trans_debit) {
        this.trans_debit = trans_debit;
    }

    public long getTrans_balance() {
        return trans_balance;
    }

    public void setTrans_balance(long trans_balance) {
        this.trans_balance = trans_balance;
    }

    public String getTrans_particle() {
        return trans_particle;
    }

    public void setTrans_particle(String trans_particle) {
        this.trans_particle = trans_particle;
    }

    public long getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(long from_account_id) {
        this.from_account_id = from_account_id;
    }

    public long getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(long to_account_id) {
        this.to_account_id = to_account_id;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "trans_id=" + trans_id +
                ", trans_credit=" + trans_credit +
                ", trans_debit=" + trans_debit +
                ", trans_balance=" + trans_balance +
                ", trans_particle='" + trans_particle + '\'' +
                ", from_account_id=" + from_account_id +
                ", to_account_id=" + to_account_id +
                '}';
    }

}
