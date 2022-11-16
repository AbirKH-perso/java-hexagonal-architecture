package com.exalt.entities;

import javax.persistence.*;

@Table
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "amount")
    private double amount;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ACCOUNT_ID",referencedColumnName = "id")
    private Account account;

    @Column(name = "info")
    private String transactionInfo;

    public Transaction() {
        super();

    }



    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", account=" + account + ", comment=" + transactionInfo + "]";
    }

    public long getTransactionId() {
        return id;
    }

    public void setTransactionId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(String transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

}