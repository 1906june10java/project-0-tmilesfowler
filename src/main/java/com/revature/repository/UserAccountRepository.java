package com.revature.repository;

import com.revature.model.UserAccount;

public interface UserAccountRepository {

	public UserAccount getUserAcct(UserAccount User);
	
	public String checkUsername(String user);
	
	public String checkPassword(String password);
	
	public long checkBalance();
	
}
