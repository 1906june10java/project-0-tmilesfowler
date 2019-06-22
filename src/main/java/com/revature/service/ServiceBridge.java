package com.revature.service;

import com.revature.repository.UserAccountRepojdbc;
import com.revature.model.UserAccount;

public class ServiceBridge {

	UserAccountRepojdbc usrRepo = new UserAccountRepojdbc();
	
	public String [] getUserInfo(String userName) {
		userName = userName.toUpperCase();
		System.out.println("Getting: " + userName);
		UserAccount tempUser = usrRepo.getUserAcct(userName);
		String [] tempArray = tempUser.toStrArray();
		
		return tempArray;
	}
	
}
