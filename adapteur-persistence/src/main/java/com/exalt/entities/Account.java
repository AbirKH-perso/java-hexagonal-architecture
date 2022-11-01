package com.exalt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Account")
@Table
public class Account {

    @Id
    private long id;
    @Column(name = "accountNumber")
    private long accountNumber;
    @Column(name = "balance")
    private Double balance;

    @Column(name = "accounttype")
    private String accounttype;


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

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public Account() {


    }


    public Account(long id, long accountNumber, Double balance, String accounttype) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accounttype = accounttype;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance
                + ", accounttype=" + accounttype + "]";
    }
}