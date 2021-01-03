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
public class LoyaltyClient extends Client implements ClientType{
    private final float discount = 10;
       
    @Override
    public int getClientId() {
        return clientId;
    }
    
    @Override
    public String getClientName() {
        return clientName;
    }
    
    @Override
    public String getClientType() {
        return clientType;
    }
    
    @Override
    public float getRentAmount() {
        return rentAmount;
    }
    
    @Override
    public float getDiscountedAmount() {
        return discountedAmount;
    }
    
    @Override
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Override
    public void setRentAmount(float rentAmount) {
        this.rentAmount = rentAmount;
    }

    @Override
    public void proccessPayment(){
         this.setClientType("Loyalty");
         this.discountedAmount = this.rentAmount * this.discount/100;
//      payment proccessing messege         
         System.out.println("...");
    }
      
}
