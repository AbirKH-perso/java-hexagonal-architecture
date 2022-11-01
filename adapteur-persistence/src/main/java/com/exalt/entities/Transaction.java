package com.exalt.entities;

import javax.persistence.*;

@Table
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private long id;
    @Column(name = "amount")
    private double amount;

    @OneToOne
    @JoinColumn(name = "accountNumber")
    private Account account;

    @Column(name = "comment")
    private String transactionInfo;

    public Transaction() {
        super();

    }


    public Transaction(String transactionInfo, double amount, Account account) {
        super();
        this.amount = amount;
        this.account = account;
        this.transactionInfo = transactionInfo;
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