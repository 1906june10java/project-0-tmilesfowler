package com.revature.repository;

import org.apache.log4j.Logger;

import com.revature.model.UserAccount;

public class UserAccountRepojdbc implements UserAccountRepository{

	private static final Logger LOGGER = Logger.getLogger(UserAccountRepojdbc.class);
	
	@Override
	public UserAccount getUserAcct(UserAccount User) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String checkUsername(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String checkPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public long checkBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
