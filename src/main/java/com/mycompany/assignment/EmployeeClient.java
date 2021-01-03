/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment;

/**
 *
 * @author nkmalviya
 **/

public class EmployeeClient extends Client implements ClientType{
    private final float discount = 20;
    
    
    public int getClientId() {
        return clientId;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public String getClientType() {
        return clientType;
    }
    
    public float getRentAmount() {
        return rentAmount;
    }
    
    public float getDiscountedAmount() {
        return discountedAmount;
    }
    
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public void setRentAmount(float rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void proccessPayment(){
        this.setClientType("Employee");
         this.discountedAmount = this.rentAmount * this.discount/100;
//      payment proccessing messege
         System.out.println("...");
    }
    
    
}
