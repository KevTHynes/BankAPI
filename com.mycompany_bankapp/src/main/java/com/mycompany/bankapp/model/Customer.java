/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankapp.model;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Big D
 */
@XmlRootElement
public class Customer {
    
    
    
    public Customer(){
    }
    
    public Customer(int id, String name, String email, String address, int pin, List<Account> account) {
        
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.pin = pin;
        this.created = new Date();
        this.account = account;
    }
   
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
     
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
     
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
      
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
 
    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
    
    private int id;
    private String name;
    private String email;
    private String address;
    private int pin;
    private Date created;
    private List<Account> account;
}
