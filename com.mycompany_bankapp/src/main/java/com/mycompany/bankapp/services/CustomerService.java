/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.services;


import com.mycompany.bankapp.Database.BankDatabase;
import static com.mycompany.bankapp.Database.BankDatabase.masterCustomers;
import com.mycompany.bankapp.model.Account;
import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.model.Transaction;
import com.mycompany.bankapp.services.AccountService;
//import com.mycompany.bankapp.services.AccountService.accounts;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
/**
 *
 * @author x09092943/x14110768
 */
public class CustomerService {
    
    BankDatabase bdb = new BankDatabase();
    
    /*
    *   Entry: Get all customers and theyre associated accounts and transactions
    */
    public List<Customer> getAllCustomers() {
        return bdb.getMasterCustomers(); 
    }
    
    /*
    *   Entry: search for customer based on entered details
    */
    public List<Customer> getSearchCustomers(String name, String email, String address, int pin){
       List<Customer> matcheslist = new ArrayList<>(); 
       for (Customer q: getAllCustomers()) {
           if ((name == null || q.getName().equals(name))
                   && (email == null || q.getEmail().equals(email))
                   && (address == null || q.getAddress().equals(address))
                   && (pin == 0 || q.getPin()==(pin))){
             matcheslist.add(q);
           }           
       }
       return matcheslist;
    }
    
    /*
    *   Entry: Get customer by customer Id
    */
    public Customer getCustomer (int id){
        return bdb.getMasterCustomers().get(id-1);
    }
    
    public Customer createCustomer(Customer c){
        List<Account> masterAccounts = new ArrayList<>(); //we make an instance of the accounts arraylist
        c.setId(bdb.getMasterCustomers().size()+1); //setting the new id for the new customer in the customer arraylist
        bdb.getMasterCustomers().add(c); // add the customer to the arraylist
        c.setAccount(masterAccounts); // we add an empty accounts object for the customer which we can use later
        System.out.println("201 - resource created with path: /customers/" + String.valueOf(c.getId()));
        return c;
    }
    
    /*
    *   entry: creating a new account for an exsisting customer
    */
    public Account createAccount(String email, int pin){
        Account account = new Account();
        List<Transaction> masterTransactions = new ArrayList<>();
        List<Account> masterAccounts = new ArrayList<>();
        for (Customer c : bdb.getMasterCustomers()){ // loop through the customers arraylist
            if((c.getEmail().equals(email))
                &(c.getPin() == (pin))){
                
                //Ref for random num: https://stackoverflow.com/questions/5392693/java-random-number-with-given-length
                //we are getting a random number generated for the account number and sort code 
                Random rnd = new Random();
                int aNumber  = 10000000 + rnd.nextInt(90000000);
                int sCode = 100000 + rnd.nextInt(900000);
                String aType = "Savings Account";
                
                account.setAccountId(bdb.getMasterAccounts().size()+1);
                account.setAccountNumber(aNumber);
                account.setSortCode(sCode);
                account.setAccountType(aType);
                account.setCurrentBalance(0); //as is new account, we set balance to zero
                account.setTransaction(masterTransactions); // adding an empty transaction object to the account so we can add to later
                c.getAccount().add(account); //add the account to the customer
                bdb.getMasterAccounts().add(account); // add the account to the master accounts arraylist                
            }
        }
        return account;
    }
    
    /*
    *   Entry: get an account belonging to a customer
    */
    public Account getCustomerAccount(int id, int accountId){
        Account a = new Account();
        
        for(Account c: getCustomer(id).getAccount()){ // searching for an account associated with the customer id
            if(c.getAccountId()== accountId){
                a = c;
            }
        }
        return a;
    }
    
    /*
    *   entry = withdrawing money from a customers account
    */
    public Transaction withdrawMoney(int id, int accountId, int amount){
        Transaction transaction = new Transaction();
        Account account = new Account();

        
        for(Account c: getCustomer(id).getAccount()){ //we need to loop through customer list to find the customer
            if(c.getAccountId()== accountId){
                account = c;
                                
                int postBalance = c.getCurrentBalance()-amount;//this is where we declare the new post balance and subtract the amount away from the current balance

                Date transactionDate = new Date();               
                transaction.setTransactionId(bdb.getMasterTransactions().size()+1);///account.getTransaction().size()+1);
                transaction.setTransactionDate(transactionDate);
                transaction.setPostBalance(postBalance);
                transaction.setTransactionType("Debit");
                c.getTransaction().add(transaction);
                c.setCurrentBalance(postBalance); //setting the current balance of the account to the post balance amount
                bdb.getMasterTransactions().add(transaction); //add the transaction to the master list
            }
        }                      
        return transaction;
    }
    
   /*
    * entry = lodging money into a customers acount
    */
    public Transaction lodgeMoney(int id, int accountId, int amount){
        Transaction transaction = new Transaction();
        Account account = new Account();

        //we need to loop through customer list to find the customer
        for(Account c: getCustomer(id).getAccount()){
            if(c.getAccountId()== accountId){
                account = c;
            
                
                int postBalance = c.getCurrentBalance()+amount;//this is where we declare the new post balance and add the amount to the current balance

                //we are now creating the new transaction and setting the all the variables
                Date transactionDate = new Date();               
                transaction.setTransactionId(bdb.getMasterTransactions().size()+1);///account.getTransaction().size()+1);
                transaction.setTransactionDate(transactionDate);
                transaction.setPostBalance(postBalance);
                transaction.setTransactionType("Credit");
                c.getTransaction().add(transaction);
                c.setCurrentBalance(postBalance);//set current balance to post balance amount
                bdb.getMasterTransactions().add(transaction);//add transaction to master list
            }
        }                      
        return transaction;
    }
    
    /*
    *   Entry: transfering money from one account to another
    */
    public Transaction transferMoney(int id, int accountId1, int accountId2, int amount){
        Transaction transFromAcc = new Transaction();
        Transaction transToAcc = new Transaction();

        Account account1 = new Account();
        Account account2 = new Account();
        
        for(Account a: getCustomer(id).getAccount()){//we need to loop through account list to find the customer and its account
            for(Account b: bdb.getMasterAccounts()){//now we loop to find the receiving account
                if((a.getAccountId()== accountId1)
                    &&(b.getAccountId()== accountId2)){
                    account1 = a;
                    account2 = b;

                    int postBalance1 = a.getCurrentBalance()-amount; //this is where we declare the new post balance and take the amount away from the current balance
                    int postBalance2 = b.getCurrentBalance()+amount; //this is where we declare the new post balance and add the amount to the current balance           


                    //we are now creating the new transaction and setting the all the variables
                    //where we take the money from the first account
                    Date transactionDate = new Date();               
                    transFromAcc.setTransactionId(bdb.getMasterTransactions().size()+1);//a.getTransaction().size()+1);
                    transFromAcc.setTransactionDate(transactionDate);
                    transFromAcc.setPostBalance(postBalance1);
                    transFromAcc.setTransactionType("Debit");
                    a.getTransaction().add(transFromAcc);
                    a.setCurrentBalance(postBalance1);
                    bdb.getMasterTransactions().add(transFromAcc);
  
                   //we are now creating the new transaction and setting the all the variables
                   //where we add the money to the second account                
                    transToAcc.setTransactionId(bdb.getMasterTransactions().size()+1);//b.getTransaction().size()+1);
                    transToAcc.setTransactionDate(transactionDate);
                    transToAcc.setPostBalance(postBalance2);
                    transToAcc.setTransactionType("Credit");
                    b.getTransaction().add(transToAcc);
                    b.setCurrentBalance(postBalance2);
                    bdb.getMasterTransactions().add(transToAcc);
                }
            }
        }        
        return transToAcc;
    }
    
}
