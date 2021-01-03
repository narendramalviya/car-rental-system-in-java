/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment;

/**
 *
 * @author nkmalviya
 */
public class Payment {
    private ClientType client;
      
    public void setClient(String clientType) {
        if(clientType == "Loyalty"){
          this.client = new LoyaltyClient();
        }
        else if(clientType == "Employee"){
           this.client = new EmployeeClient();
        }
        else{
            this.client = new StandardClient();            
        }
    }
    
    public void setRentAmount(float rentAmount){
       this.client.setRentAmount(rentAmount);
    }
    
    public void setClientName(String clientName){
       this.client.setClientName(clientName);
    }
    
    public void setClientId(int id){
       this.client.setClientId(id);
    }
    
    public ClientType makePayment(){        
        client.proccessPayment();
//      payment proccessing messege
        System.out.println(" ...");
        return client;
    }
    
}
