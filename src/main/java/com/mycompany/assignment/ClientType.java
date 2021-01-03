package com.mycompany.assignment;

public interface ClientType {

    public void proccessPayment();

    public int getClientId();

    public String getClientName();

    public String getClientType();

    public float getRentAmount();

    public float getDiscountedAmount();

    public void setClientId(int clientId);

    public void setClientName(String clientName);

    public void setClientType(String clientType);

    public void setRentAmount(float rentAmount);
}
