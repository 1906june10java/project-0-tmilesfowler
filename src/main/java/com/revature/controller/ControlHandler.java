package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.exception.InvalidMenuException;
import com.revature.service.ServiceBridge;

public class ControlHandler {
	
	private static final Logger LOGGER = Logger.getLogger(ControlHandler.class); 
	
public ControlHandler(){
	
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
				/* Change print to "Username or register new"
				 * if(Register_new ){
				 * Print type new username, then new password
				 * Store those in variables and put them in srvBrg.regUser
				 * Do normal login
				 * }
				 * */
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
				else {System.out.println("Invalid Password\n");}
			}
			else {System.out.println("Invalid Username\n");}
		}
		
		else if (logdIn == true) {
			
				
				if(menuSt.equals("0")) {
				//Main Menu
				System.out.println("\nType the number of the option you'd like to select!\n1. Deposit  2. Withdraw 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}
				
				if(menuSt.equals("1")) {
				//Deposit
				System.out.println("\nWhat amount would you like to deposit? Current balance is " + balance);
				input = inp.nextLine();
				try {
				if(Integer.valueOf(input) < 0) {
					System.out.println("Negative deposits not allowed.");
					System.out.println("\nWhat would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
					menuSt = inp.nextLine();
				}
				else {
				balance += Integer.valueOf(input);
				srvBrg.pushNewBalance(usrInfo [1], balance);
				System.out.println("Deposited $" + input + ", new balance is: $" + balance);
				System.out.println("\nWhat would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}
				}
				catch (NumberFormatException e) {
					LOGGER.error("Invalid characters used.");
					System.out.println("\nWhat would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
					menuSt = inp.nextLine();
				}
				
				}
				
				if(menuSt.equals("2")) {
				//Withdraw	
				System.out.println("How much money would you like to withdraw? Current balance is " + balance);
				input = inp.nextLine();
				try {
					if(Integer.valueOf(input) < 0) {
						System.out.println("Negative withdrawls not allowed.");
						System.out.println("\nWhat would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
						menuSt = inp.nextLine();
					}
					else if (Integer.valueOf(input) > balance) {
					System.out.println("Not enough funds to withdraw desired amount.");
					System.out.println("\nWhat would you like to do next?\n0. Menu 2. Make Another Withdrawal  \n1. Deposit 3. Check Balance 4. Logout");
					menuSt = inp.nextLine();
				}
				else {
				balance -= Integer.valueOf(input);
				srvBrg.pushNewBalance(usrInfo [1], balance);
				System.out.println("Withdrew $" + input + ", new balance is: $" + balance);
				System.out.println("\nWhat would you like to do next?\n0. Menu 2. Make Another Withdrawal  \n1. Deposit 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}
				} catch (NumberFormatException e) {
					LOGGER.error("Invalid characters used.");
					System.out.println("\nWhat would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
					menuSt = inp.nextLine();
				}
				}

				if(menuSt.equals("3")) {
				//Check Balance
				System.out.println("Your balance is: $" + balance);
				System.out.println("\nWhat would you like to do next?\n0. Menu\n1. Deposit 2. Withdraw 4. Logout");
				menuSt = inp.nextLine();
				}
				
				if(menuSt.equals("4")) {
				//Logout
					System.out.println("Goodbye!\n");
					//menuSt = "0";
					logdIn = false;
				}
				
				else if (!menuSt.equals("0")&&!menuSt.equals("1")&&!menuSt.equals("2")&&!menuSt.equals("3")&&!menuSt.equals("4")) {
					try {
						throw new InvalidMenuException();
					} catch (InvalidMenuException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						LOGGER.error("Invalid option, returning to menu!");
						menuSt = "0";
					}
					
				}
				
				else {}
				
		}
		
		//System.out.println("Freedom");
		
	}
		}
	
}
