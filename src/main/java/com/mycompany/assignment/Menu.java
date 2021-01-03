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
// package a7201_assig1;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class Menu {
	Payment payment;
        ArrayList <ClientType> clientList;
        
        Menu(){
            this.payment = new Payment();
            clientList = new ArrayList <ClientType>();

//       testing data
            ClientType tempClient = new EmployeeClient();
            tempClient.setClientId(0);
            tempClient.setClientName("nk malviya");
            tempClient.setClientType("Employee");
            tempClient.setRentAmount(230);
            tempClient.proccessPayment();
            clientList.add(tempClient);
            
            tempClient = new StandardClient();
            tempClient.setClientId(1);
            tempClient.setClientName("kailash malviya");
            tempClient.setClientType("Standard");
            tempClient.setRentAmount(530);
            tempClient.proccessPayment();
            clientList.add(tempClient);
            
            tempClient = new LoyaltyClient();
            tempClient.setClientId(2);
            tempClient.setClientName("shiv malviya");
            tempClient.setClientType("Loyalty");
            tempClient.setRentAmount(430);
            tempClient.proccessPayment();
            clientList.add(tempClient);
            
            tempClient = new LoyaltyClient();
            tempClient.setClientId(3);
            tempClient.setClientName("sunil malviya");
            tempClient.setClientType("Loyalty");
            tempClient.setRentAmount(330);
            tempClient.proccessPayment();
            clientList.add(tempClient);
            
        }
        
        private void proccessOnOption(String clientType){
            int id =0; 
            String name = null ;
            float rentAmount = 0;
            Scanner scanInput = new Scanner(System.in);
            ClientType client = null;
            
            //list of all clients by given option
            System.out.println("Client ID          Name          Total Amount          Discounted Amount");
            displayClientListByType(clientType);
            System.out.println("------------------------------------------------------------------------");
            
            //first we need to set client type 
            payment.setClient(clientType);
                
            boolean inputIsCorrect = false;
            do{
                try{
                    System.out.println("Enter ID of an existing client or  0 to enter a new one:");
                    id = scanInput.nextInt();
                    
                    //get client by given type and id
                    client = this.getClientById(id,clientType);
                    //id zero (0) for new client and other than 0 means client 
                    //client already available
                    //if client not found by given id and id is not 0 and purticular type than throws error messege
                    if(id != 0 && client == null){
                        throw new Exception("Client not found!, enter correct id?");                         
                    }
                    //clean input buffur ,read empty or new line charactors from input buffur
                    scanInput.nextLine(); 
                    inputIsCorrect = true;
      	     
                }catch(Exception e){
                    System.out.println("Wrong kind of input!"+e.getMessage());
                    scanInput.nextLine();
                }
            }while(!inputIsCorrect);
             
            if(id == 0){
                    id = clientList.size();  

                    System.out.println("Enter the name of Client:");
                    name = scanInput.nextLine();               
            }else{          
                   name = client.getClientName();
   
            }
            
            System.out.println("Enter the amount of this payment:");
            rentAmount = scanInput.nextFloat();
            payment.setClientId(id);
            payment.setClientName(name);
            payment.setRentAmount(rentAmount);
            
            //makePayment() returns the object of the new client
            client = payment.makePayment();
            //add client to client list
            clientList.add(client);
            System.out.println(" Finished processing payment.\n\n");
        }
        
        //get client by given id and type
        private ClientType getClientById(int id,String clientType){
            for(ClientType client :this.clientList){
                 if(client.getClientId() == id && client.getClientType() == clientType)
                     return client;
            }
            // return null when client not fount!!
            return null;
        }
        //print all clients  by given client type 
        private void displayClientListByType(String clientType){      
            for(ClientType client :clientList){
                if(client.getClientType() == clientType)
                    System.out.printf("%d           %15s    %15.2f     %15.2f\n",client.getClientId(),client.getClientName(),client.getRentAmount(),client.getDiscountedAmount());
            }
        }
              
//      print all clients       
        private void displayClientList(){
             System.out.println("------------------------------------------------------------------------");
             System.out.println("Client ID          Name            Total Amount            Discounted Amount");
            
             System.out.println("Standard");
             displayClientListByType("Standard");
             
             System.out.println("\nLoyalty");
             displayClientListByType("Loyalty");
             
             
             System.out.println("\nEmployee");
              displayClientListByType("Employee");
               
             System.out.println("------------------------------------------------------------------------");
        }
        
        private void displayReport(){
//            total amount of  all clients categorywise
                float standardClientAmount = 0;
                float loyaltyClientAmount = 0;
                float staffAmount = 0;
                float standardClientDiscountedAmount = 0;
                float loyaltyClientDiscountedAmount = 0;
                float staffDiscountedAmount = 0;

                float totalRentAmount = 0;
                float totalDiscountedAmount = 0;

                for(ClientType client :clientList){
                     totalRentAmount += client.getRentAmount();
                     totalDiscountedAmount += client.getDiscountedAmount();
                     
                     if(client.getClientType() == "Standard"){
                            standardClientAmount += client.getRentAmount();
                            standardClientDiscountedAmount += client.getDiscountedAmount();
                     }
                     else if(client.getClientType() == "Loyalty"){
                             loyaltyClientAmount += client.getRentAmount();
                             loyaltyClientDiscountedAmount += client.getDiscountedAmount();
                     }
                     else{
                         staffAmount += client.getRentAmount();
                         staffDiscountedAmount += client.getDiscountedAmount();
                     }          
                }
                
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Type of Account      Total Amount Received      Discounts Given"); 
                System.out.println("-----------------------------------------------------------------");
                System.out.printf("Standard                %15.2f       %15.2f \n",standardClientAmount,standardClientDiscountedAmount);
                System.out.printf("Loyalty                 %15.2f       %15.2f \n",loyaltyClientAmount,loyaltyClientDiscountedAmount);
                System.out.printf("Staff                   %15.2f       %15.2f \n",staffAmount,staffDiscountedAmount);
                System.out.println("----------------------------------------------------------------");
                System.out.printf("Total                   %15.2f       %15.2f \n",totalRentAmount,totalDiscountedAmount);
                System.out.println("----------------------------------------------------------------\n");
        }
	public void displayUserMenu() {
		// Control the menu navigation.  Includes display of menu, acceptance and processing of user input and
		// exiting the menu based on the user's selections.
		boolean blnContinue = true;
		Scanner scanInput = null;
		
		header();
		
		try {		//try-catch-finally to ensure compatibility with all java versions. 
			scanInput = new Scanner(System.in);
			while (blnContinue) {
				displayMenu();
			         
				if (scanInput.hasNextInt()) {
					blnContinue = processMenuSelection(scanInput.nextInt());
				}
				else {
					scanInput.nextLine();
					blnContinue = processMenuSelection(0);
				}
			}
		}
		catch (Exception e){
			// Generic error catch - this can be made more specific to the expected errors.
			System.out.println("An unexpected exception has occurred with input"+e.toString());
		}
		finally {
			// Close the scanner
			if (scanInput != null) {
				scanInput.close();
			}
		}
		
	}

	private void header() {
		// Display program header information
		System.out.println("Federation Car Rental Payment Tracking System");
		System.out.println("=============================================");
		System.out.println();
	}

	private void displayMenu() {
		// Display the menu for user to select which function to run
		System.out.println("Select an option from the menu below:");
		System.out.println("1. Standard Payment");
		System.out.println("2. Loyalty Payment");
		System.out.println("3. Employee Payment");
		System.out.println("4. Display List of Clients");
		System.out.println("5. Generate Report To View Payments Received");
		System.out.println("6. Exit");
		System.out.printf("Enter your option: ");
              
                

	}
	
	private boolean processMenuSelection(int menuSelection) {
		// Use the input provided by the user to activate the appropriate code function

		boolean blnContinue = true;
		
		switch (menuSelection){
		case 1:
			// call method to process standard payments here
			System.out.println("--Processing Standard Payment--");
                        proccessOnOption("Standard");
                       
			break;
		case 2:
			// call method to process loyalty rewards payments here
			System.out.println("--Processing Loyalty Payment--");
                        proccessOnOption("Loyalty");
                       
			break;
		case 3:
			// call method to process employee payments here
			System.out.println("--Processing Employee Payment--");
                        proccessOnOption("Employee");
                        
			break;
		case 4:
			// call method to  display list of clients here
			System.out.println("--List of Clients--");
                        displayClientList();
			break;
		case 5:
			// call method to generate report to display payments received here
			System.out.println("--Report to View Payments Received--");
                        displayReport();
			break;
		case 6:
			System.out.println("-- Exiting Federation Car Rental Payment Tracking System --\n ....\n  -- Goodbye! --\n");
			blnContinue = false;
			break;
		default:
			// no valid selection made
			System.out.println("Invalid selection! A number between 1 and 6 was expected.");
		}		
		return blnContinue;
	}

}
