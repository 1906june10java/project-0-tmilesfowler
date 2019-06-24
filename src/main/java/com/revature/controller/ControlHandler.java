package com.revature.controller;

import java.util.Scanner;

import com.revature.exception.InvalidMenuException;
import com.revature.service.ServiceBridge;

public class ControlHandler {

public void userInput(){
	String usrNm = "revature";
	String pssWrd = "p4ssw0rd";
	Scanner inp = new Scanner(System.in); 
	String input = "0";
	Boolean logdIn = false;
	Boolean running = true;
	String menuSt = "0";
	String [] usrInfo = null;
	ServiceBridge srvBrg = new ServiceBridge();
	long balance = 0;
	
	while (running) {
			//Not logged in Loop
		if (logdIn == false) {
				System.out.println("Username: ");
				input = inp.nextLine();
				usrInfo = srvBrg.getUserInfo(input);
						
			if(input.equals(usrInfo[1])) {
				System.out.println("Password: ");
				input = inp.nextLine();
				
				if(input.equals(usrInfo[2])) {
					System.out.println("Login succussful! Welcome " + usrInfo[1] + "!");
					menuSt = "0";
					balance = Long.valueOf(usrInfo[3]);
					logdIn = true;
				}
				else {System.out.println("Invalid Password");}
			}
			else {System.out.println("Invalid Username");}
		}
		
		else if (logdIn == true) {
			
				
				if(menuSt.equals("0")) {
				//Main Menu
				System.out.println("Type the number of the option you'd like to select!\n1. Deposit  2. Withdraw 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				System.out.println("Current Menu: " + menuSt);
				}
				
				if(menuSt.equals("1")) {
				//Deposit
				System.out.println("What amount would you like to deposit?");
				input = inp.nextLine();
				balance += Integer.valueOf(input);
				System.out.println("Deposited $" + input + " new balance is: $" + balance);
				System.out.println("What would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}
				
				if(menuSt.equals("2")) {
				//Withdraw	
				System.out.println("How much money would you like to withdraw?");
				input = inp.nextLine();
				balance -= Integer.valueOf(input);
				System.out.println("Withdrew $" + input + " new balance is: $" + balance);
				System.out.println("What would you like to do next?\n0. Menu 2. Make Another Withdrawal  \n1. Deposit 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}

				if(menuSt.equals("3")) {
				//Check Balance
				System.out.println("Your balance is: $" + balance);
				System.out.println("What would you like to do next?\n0. Menu\n1. Deposit 2. Withdraw 4. Logout");
				menuSt = inp.nextLine();
				}
				
				if(menuSt.equals("4")) {
				//Logout
					System.out.println("Goodbye!");
					srvBrg.pushNewBalance(usrInfo [1], balance);
					//menuSt = "0";
					logdIn = false;
				}
				
				else if (!menuSt.equals("0")&&!menuSt.equals("1")&&!menuSt.equals("2")&&!menuSt.equals("3")&&!menuSt.equals("4")) {
					try {
						throw new InvalidMenuException();
					} catch (InvalidMenuException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Invalid option, returning to menu!");
						menuSt = "0";
					}
					
				}
				
				else {
					System.out.println("Jumped to " + menuSt);
				}
				
		}
		
		//System.out.println("Freedom");
		
	}
		}
	
}
