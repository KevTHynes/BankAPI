/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.services;

import com.mycompany.bankapp.Database.BankDatabase;
import com.mycompany.bankapp.model.Account;
import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.model.Transaction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author x09092943/x14110768
 */
public class AccountService {
    
    BankDatabase bdb = new BankDatabase();

    /*
    *   Entry: Get all accounts
    */
    public List<Account> getAllAccounts() {
        return bdb.getMasterAccounts();
    }
    
    /*
    *   Entry: Search for account with entered criteria
    */
    public List<Account> getSearchAccount(int accountNumber, int sortCode, int currentBalance, String accountType){
        List<Account> accountSearch = new ArrayList<>();
        
        for(Account as: getAllAccounts()){
            if((accountNumber == 0 || as.getAccountNumber() == accountNumber)
            &&(sortCode == 0 || as.getSortCode() == sortCode)
            &&(currentBalance == 0 || as.getCurrentBalance() == currentBalance)
            &&(accountType == null || as.getAccountType().equals(accountType))){
                accountSearch.add(as);
            }
        }
        return accountSearch;
    }
    
    /*
    *   Entry: Get accont by Id
    */
    public Account getAccount(int accountId){
        return bdb.getMasterAccounts().get(accountId-1);
    }

    /*
    * Old add account method
    */
    public Account createAccount(Account a){                
        a.setAccountId(bdb.getMasterAccounts().size()+1);
        bdb.getMasterAccounts().add(a);
        System.out.println("201 - resource created with path: /accounts/" + String.valueOf(a.getAccountId()));
        return a;
    }    
    
    /*
    *   Entry: get transactions in an account
    */
    public Transaction getAccountTransaction(int id, int transactionId){
        Transaction t = new Transaction();
        
        for(Transaction ta: getAccount(id).getTransaction()){//get transaction associated to the account id
            if(ta.getTransactionId()== transactionId){
                t = ta;
            }
        }
        return t;
    }

    /*
    *   Entry: Get balance for an account
    */
    public int getBalance(int accountNum){ 
        Account account = new Account();
        JSONObject json = new JSONObject();
        
        for(Account a: bdb.getMasterAccounts()){//loop through accounts list to find account
            if(a.getAccountNumber() == (accountNum)){//checking if account num is equal to the account num given
                
                account = a;
                String message = "Your current balance for " + String.valueOf (accountNum)+ "is: ";
                json.put("message", message);
            }
        }
        System.out.println("Account balance got for account number:" + String.valueOf(accountNum));
        
        return account.getCurrentBalance();//return the accounts current balance
    }
    
}
