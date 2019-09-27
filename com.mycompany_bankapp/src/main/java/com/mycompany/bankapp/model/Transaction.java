/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.model;

import java.util.Date;

/**
 *
 * @author kev-h
 */
public class Transaction {

    public Transaction(int transactionId, int postBalance, String transactionType) {
        this.transactionId = transactionId;
        this.transactionDate = new Date();
        this.postBalance = postBalance;
        this.transactionType = transactionType;
    }
    
    public Transaction(){
        
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(int postBalance) {
        this.postBalance = postBalance;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    private int transactionId;
    private Date transactionDate;
    private int postBalance;
    private String transactionType;
    
}
