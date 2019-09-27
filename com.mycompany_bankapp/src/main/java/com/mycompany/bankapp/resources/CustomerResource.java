/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.model.Account;
import com.mycompany.bankapp.model.Customer;
import com.mycompany.bankapp.model.Transaction;
import com.mycompany.bankapp.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;

/**
 *
 * @author x09092943/x14110768
 */

@Path("/customers")
//@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)

public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
    /*
    *   Entry: Get customer by customer Id
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}")
    public Customer getCustomer(@PathParam("customerId")int id){
        return customerService.getCustomer(id);
    }
    
    /*
    *   Entry: Create a customer
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createCustomer")    
    public Customer postCustomer(Customer c){
        return customerService.createCustomer(c);
    }
    /*
    *   Entry: search for customer based on entered details
    */    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer>getFilteredCustomers
        (@QueryParam("name")String name,
         @QueryParam("email")String email, 
         @QueryParam("address")String address, 
         @QueryParam("pin")int pin){
        if((name != null)||(email != null)||(address != null)||(pin != 0)){
            return customerService.getSearchCustomers(name, email, address, pin);
        }
        return customerService.getAllCustomers();
    }
    /*
    *   Entry: get an account belonging to a customer
    *    
    */    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}/accounts/{accountId}")
    public Account getAccountForCustomer(@PathParam("customerId") int id, @PathParam("accountId") int accountId) {
	return customerService.getCustomerAccount(id, accountId);
    }
    
    /*
    *   Select POST in dropdown
    *   Add Content-Type - Applciation/JSON
    *   Paste email * pin
    *   http://localhost:49000/api/customers/john@gmail.com/111/newAccount
    *
    *   entry: creating a new account for an exsisting customer
    */    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{email}/{pin}/newAccount")
    public Account createAccountForCustomer(@PathParam("email") String email, @PathParam("pin") int pin) {
	return customerService.createAccount(email, pin);
    }
    /*
    *   Entry: withdrawing money from a customers account
    *   http://localhost:49000/api/customers/1/accounts/1/withdraw/100
    */    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}/accounts/{accountId}/withdraw/{amount}")
    public Transaction Withdrawl(@PathParam("customerId") int id, @PathParam("accountId") int accountId, @PathParam("amount") int amount){
        return customerService.withdrawMoney(id, accountId, amount);
    }

   /*
    *   Entry: lodging money into a customers acount
    *   http://localhost:49000/api/customers/1/accounts/1/deposit/100
    */    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}/accounts/{accountId}/deposit/{amount}")
    public Transaction Lodge(@PathParam("customerId") int id, @PathParam("accountId") int accountId, @PathParam("amount") int amount){
        return customerService.lodgeMoney(id, accountId, amount);
    }
    /*
    *   Entry: transfering money from one account to another
    *   http://localhost:49000/api/customers/1/accounts/1/transfer/4/100
    */    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{customerId}/accounts/{accountId1}/transfer/{accountId2}/{amount}")
    public Transaction Transfer(@PathParam("customerId") int id, @PathParam("accountId1") int accountId1, @PathParam("accountId2") int accountId2, @PathParam("amount") int amount){
        return customerService.transferMoney(id, accountId1, accountId2, amount);
    } 

}
