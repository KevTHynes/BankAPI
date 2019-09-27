/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.model.Account;
import com.mycompany.bankapp.model.Transaction;
import com.mycompany.bankapp.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author x09092943/x14110768
 */
@Path("/accounts")
//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {
    
    AccountService accountService = new AccountService();
 
    /*
    *   Entry: Get accont by Id
    */    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{accountId}")
    public Account getAccount(@PathParam("accountId")int accountId){
        return accountService.getAccount(accountId);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Account postAccount(Account a){
        return accountService.createAccount(a);
    }
    /*
    *   Entry: Search for account with entered criteria
    */    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account>getFilteredAccounts
        (@QueryParam("accountNumber")int accountNumber,
         @QueryParam("sortCode")int sortCode, 
         @QueryParam("currentBalance")int currentBalance, 
         @QueryParam("accountType")String accountType){
        if((accountNumber != 0)||(sortCode != 0)||(currentBalance != 0)||(accountType != null)){
            return accountService.getSearchAccount(accountNumber,sortCode,currentBalance,accountType);
        }
        return accountService.getAllAccounts();
    }
        
    /*
    *   Entry: get transactions in an account
    */          
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{accountId}/transactions/{transactionId}")
    public Transaction getTransactionForAccount(@PathParam("accountId") int id, @PathParam("transactionId") int transactionId) {
	return accountService.getAccountTransaction(id, transactionId);
    }

    /*
    *   Entry: Get balance for an account
    */    
    @GET   
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("balance/{accountNum}")
    public int getBalanceForCustomer(@PathParam("accountNum") int accountNum) {
	return accountService.getBalance(accountNum);
    }
}
