package com.revature.service;

import com.revature.exception.NegNumberException;
import com.revature.model.UserAccount;
import com.revature.repository.UserAccountRepojdbc;

public class ServiceBridge {

	UserAccountRepojdbc usrRepo = new UserAccountRepojdbc();
	
	public String [] getUserInfo(String userName) {
		//userName = userName.toUpperCase();
		try {
		UserAccount tempUser = usrRepo.getUserAcct(userName);
		//System.out.println("Found: " + tempUser.toString());
		String [] tempArray = tempUser.toStrArray();
		return tempArray;
		} catch (NullPointerException e){
			String [] tempArray = {null, null, null, null};
			return tempArray;
		}
		
	}
	
	public void pushNewBalance(String user, long balance){
		if (balance < 0) {
			try {
				throw new NegNumberException();
			} catch(NegNumberException e) {
				e.printStackTrace();
				System.out.println("Balance below zero! Unable to push to server, resetting balance!");
			}
		}
		else {
		usrRepo.updateBalance(user, balance);
		}
	}
	
}
