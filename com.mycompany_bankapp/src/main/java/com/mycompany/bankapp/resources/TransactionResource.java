/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.model.Transaction;
import com.mycompany.bankapp.services.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author x09092943/x14110768
 */
@Path("/transactions")
//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {
    
    TransactionService transactionService = new TransactionService();
    /*
    *   Get Transaction by Id
    */    
    @GET
    @Path("/{transactionId}")
    public Transaction getTransaction
        (@PathParam("transactionId")int transactionId){
        return transactionService.getTransaction(transactionId);
    }
    
    @POST
    public Transaction postTransaction(Transaction t){
        return transactionService.createTransaction(t);
    }
    
    /*
    *  Entry: Get transaction by specified criteria
    */    
    @GET
    public List<Transaction>getFilteredTransactions
        (@QueryParam("postBalance")int postBalance, 
         @QueryParam("transactionType")String transactionType){
        if((postBalance != 0)||(transactionType != null)){
            return transactionService.getSearchTransaction(postBalance,transactionType);
        }
        return transactionService.getAllTransactions();
    }
    
}
