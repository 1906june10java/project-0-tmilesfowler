package com.revature.controller;

import java.util.Scanner;


public class ControlHandler {

public void userInput(){
	String usrNm = "revature";
	String pssWrd = "p4ssw0rd";
	Scanner inp = new Scanner(System.in); 
	String input = "0";
	Boolean logdIn = false;
	Boolean running = true;
	String menuSt = "0";
	
	while (running) {
			//Not logged in Loop
		if (logdIn == false) {
				System.out.println("Username: ");
				input = inp.nextLine();
						
			if(input.equals(usrNm) || input.equals("")) {
				System.out.println("Password: ");
				input = inp.nextLine();
				
				if(input.equals(pssWrd) || input.equals("")) {
					System.out.println("Login succussful! Welcome " + usrNm + "!");
					menuSt = "0";
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
				System.out.println("How much money would you like to deposit?");
				System.out.println("$" + inp.nextLine());
				System.out.println("What would you like to do next?\n0. Menu 1. Make Another Deposit  \n2. Withdraw 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}
				
				if(menuSt.equals("2")) {
				//Withdraw	
				System.out.println("How much money would you like to withdraw?");
				System.out.println("$" + inp.nextLine());
				System.out.println("What would you like to do next?\n0. Menu 2. Make Another Withdrawal  \n1. Deposit 3. Check Balance 4. Logout");
				menuSt = inp.nextLine();
				}

				if(menuSt.equals("3")) {
				//Check Balance
				System.out.println("Your balance is: ");
				System.out.println("What would you like to do next?\n0. Menu\n1. Deposit 2. Withdraw 4. Logout");
				menuSt = inp.nextLine();
				}
				
				if(menuSt.equals("4")) {
				//Logout
					System.out.println("Goodbye!");
					//menuSt = "0";
					logdIn = false;
				}
				
				else {
					System.out.println("Jumped to " + menuSt);
				}
				
		}
		
		//System.out.println("Freedom");
		
	}
		}
	
}
