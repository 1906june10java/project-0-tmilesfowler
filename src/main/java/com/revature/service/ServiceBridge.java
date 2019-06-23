package com.revature.service;

import com.revature.repository.UserAccountRepojdbc;

import com.revature.model.UserAccount;

public class ServiceBridge {

	UserAccountRepojdbc usrRepo = new UserAccountRepojdbc();
	
	public String [] getUserInfo(String userName) {
		userName = userName.toUpperCase();
		try {
		UserAccount tempUser = usrRepo.getUserAcct(userName);
		String [] tempArray = tempUser.toStrArray();
		return tempArray;
		} catch (NullPointerException e){
			String [] tempArray = {null, null, null, null};
			return tempArray;
		}
		
	}
	
	public void pushNewBalance(String user, long balance){
		user = user.toUpperCase();
		usrRepo.updateBalance(user, balance);
	}
	
}
