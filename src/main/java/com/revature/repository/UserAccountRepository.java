package com.revature.repository;

import com.revature.model.UserAccount;

public interface UserAccountRepository {

	public UserAccount getUserAcct(String user);
	
	public boolean updateBalance(String userID, long balance);
	
}
