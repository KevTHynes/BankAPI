/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.services;

import com.mycompany.bankapp.Database.BankDatabase;
import com.mycompany.bankapp.model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x09092943/x14110768
 */
public class TransactionService {
    
    BankDatabase bdb = new BankDatabase();

    /*
    * Entry: Get all transactions
    */
    public List<Transaction> getAllTransactions() {
        return bdb.getMasterTransactions();
    }

    /*
    *  Entry: Get transaction by specified criteria
    */
    public List<Transaction> getSearchTransaction(int postBalance, String transactionType){
        List<Transaction> transactionSearch = new ArrayList<>();
        
        for(Transaction ts: getAllTransactions()){
            if((postBalance == 0 || ts.getPostBalance() == postBalance)
            &&(transactionType == null || ts.getTransactionType().equals(transactionType))){
                transactionSearch.add(ts);
            }
        }
        return transactionSearch;
    }
    
    /*
    *   Get Transaction by Id
    */
    public Transaction getTransaction(int transactionId){
        return bdb.getMasterTransactions().get(transactionId-1);
    }
    
    /*
    *   Entry: old create transaction method
    */
    public Transaction createTransaction(Transaction t){
        t.setTransactionId(bdb.getMasterTransactions().size()+1);
        bdb.getMasterTransactions().add(t);
        System.out.println("201 - resource created with path: /transactions/" + String.valueOf(t.getTransactionId()));
        return t;
    }
}
