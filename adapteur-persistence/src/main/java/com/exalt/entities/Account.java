package com.exalt.entities;

import java.util.List;

import javax.persistence.*;

@Entity(name = "Account")
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "accountNumber")
    private long accountNumber;
    @Column(name = "balance")
    private Double balance;

    @Column(name = "accountType")
    private String accountType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accounttype) {
        this.accountType = accounttype;
    }

    public Account() {


    }


    public Account(long accountNumber, Double balance, String accountType,
                   List<Transaction> transactions) {
        super();
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance
                + ", accounttype=" + accountType + "]";
    }
}