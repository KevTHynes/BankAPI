/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.Database;

import com.mycompany.bankapp.model.Account;
import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x09092943/x14110768
 */
public class BankDatabase {

    //ref for master arraylists: https://www.mkyong.com/java/how-to-join-two-lists-in-java/
    public static List<Customer> clist1 = new ArrayList<>();
    public static List<Customer> clist2 = new ArrayList<>();
    public static List<Customer> clist3 = new ArrayList<>();
    
    public static List<Customer> masterCustomers = new ArrayList<>();
    
    public static List<Account> account1 = new ArrayList<>();
    public static List<Account> account2 = new ArrayList<>();
    public static List<Account> account3 = new ArrayList<>();
    
    public static List<Account> masterAccounts = new ArrayList<>();

    public static List<Transaction> transaction1 = new ArrayList<>();
    public static List<Transaction> transaction2 = new ArrayList<>();
    public static List<Transaction> transaction3 = new ArrayList<>();
    
    public static List<Transaction> masterTransactions = new ArrayList<>();
    
    public static boolean init = true;

    public BankDatabase(){
        if(init){
            
           /*
            * Adding to individual customer list
            */
            Customer c1 = new Customer(1,"John", "john@gmail.com", "12/2 O'Connell St. Dublin 1", 111, account1);
            clist1.add(c1);   
            Customer c2 = new Customer(2,"Bill", "bill@outlook.com", "32/3 George St. Dublin 2", 222, account2);
            clist2.add(c2);            
            Customer c3 = new Customer(3,"Tom", "tom@yahoo.com", "2 Cappagh Rd. Dublin 11", 333, account3);
            clist3.add(c3);
             
           /*
            * Adding to individual lists to Master Customer list
            */
            masterCustomers.addAll(clist1);
            masterCustomers.addAll(clist2);
            masterCustomers.addAll(clist3);

           /*
            * Adding to individual account list
            */
            Account a1 = new Account(1, 1234567, 66556, 500, "Current Account", transaction1);
            account1.add(a1);
            Account a2 = new Account(2, 7654321, 66556, 300, "Savings Account", transaction2);
            account2.add(a2);
            Account a3 = new Account(3, 5675344, 66556, 50, "Student Account", transaction3);    
            account3.add(a3);
            
           /*
            * Adding to master account list
            */
            masterAccounts.addAll(account1);
            masterAccounts.addAll(account2);
            masterAccounts.addAll(account3);

           /*
            * Adding to individual transaction list
            */
            Transaction t1 = new Transaction(1, 500, "Credit");
            transaction1.add(t1);
            Transaction t2 = new Transaction(2, 300, "Debit");
            transaction2.add(t2);
            Transaction t3 = new Transaction(3, 50, "Credit");
            transaction3.add(t3);
            
            masterTransactions.addAll(transaction1);
            masterTransactions.addAll(transaction2);
            masterTransactions.addAll(transaction3);
        init = false;
        }
    }
    

    public static List<Customer> getClist1() {
        return clist1;
    }

    public static List<Customer> getClist2() {
        return clist2;
    }

    public static List<Customer> getClist3() {
        return clist3;
    }

    public static List<Customer> getMasterCustomers() {
        return masterCustomers;
    }

    public static List<Account> getAccount1() {
        return account1;
    }

    public static List<Account> getAccount2() {
        return account2;
    }

    public static List<Account> getAccount3() {
        return account3;
    }

    public static List<Account> getMasterAccounts() {
        return masterAccounts;
    }

    public static List<Transaction> getTransaction1() {
        return transaction1;
    }

    public static List<Transaction> getTransaction2() {
        return transaction2;
    }

    public static List<Transaction> getTransaction3() {
        return transaction3;
    }

    public static List<Transaction> getMasterTransactions() {
        return masterTransactions;
    }    

}
