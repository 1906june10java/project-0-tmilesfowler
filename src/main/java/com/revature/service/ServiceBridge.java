package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.exception.NegNumberException;
import com.revature.model.UserAccount;
import com.revature.repository.UserAccountRepojdbc;

public class ServiceBridge {
	
	private static final Logger LOGGER = Logger.getLogger(ServiceBridge.class);

	UserAccountRepojdbc usrRepo = new UserAccountRepojdbc();
	
	public String [] getUserInfo(String userName) {
		//userName = userName.toUpperCase();
		try {
		UserAccount tempUser = usrRepo.getUserAcct(userName);
		//System.out.println("Found: " + tempUser.toString());
		String [] tempArray = tempUser.toStrArray();
		return tempArray;
		} catch (NullPointerException e){
			LOGGER.error(e);
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
				LOGGER.error("Balance below zero! Unable to push to server, resetting balance!");
			}
		}
		else {
		usrRepo.updateBalance(user, balance);
		}
	}
	
	/* public boolean registerNewUser(String user, String password){
	 * 		
	 * 		UserAccount [] temp = srvBrg.getAllUsers(returns an array that sizes based on the highest index, or maybe a list);
	 * 		boolean newAccount = true;
	 * 		
	 * 		for(UserAccount existingAccount : temp){
	 * 			if (user == existingAccount.toArray[1]){
	 * 			
	 * 			}
	 * 		}
	 * }
	 * */
	
}
