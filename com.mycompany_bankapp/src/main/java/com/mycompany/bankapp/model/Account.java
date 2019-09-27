/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kev-h
 */
public class Account {

    public Account(int accountId, int accountNumber, int sortCode, int currentBalance, String accountType, List<Transaction> transaction) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
        this.currentBalance = currentBalance;
        this.accountType = accountType;
        this.transaction = transaction;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    
    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
    
    private int accountId;
    private int accountNumber;
    private int sortCode;
    private int currentBalance;
    private String accountType;
    private List<Transaction> transaction;


    public Account(){
        
    }
    
}
