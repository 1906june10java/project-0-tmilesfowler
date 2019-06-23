package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.model.UserAccount;
import com.revature.util.ConnectionUtilPr0;

public class UserAccountRepojdbc implements UserAccountRepository{

	private static final Logger LOGGER = Logger.getLogger(UserAccountRepojdbc.class);
	
	@Override
	public UserAccount getUserAcct(String user) {
		// TODO Auto-generated method stub
		LOGGER.setLevel(Level.DEBUG);
		//System.out.println("Looking for account by the name of: " + user);
		try(Connection connection = ConnectionUtilPr0.getConnection()){
			int parameterIndex = 0;
		LOGGER.debug("Looking for account by the name of: " + user);
		String sql = "SELECT * FROM USERACCT WHERE U_NAME = ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(++parameterIndex, user);
		ResultSet result = statement.executeQuery();
		
		if(result.next()) {
			
			UserAccount myAcct = new UserAccount (
					result.getLong("U_ID"),
					result.getString("U_NAME"),
					result.getString("U_PASSWORD"),
					result.getLong("U_BALANCE")
					);
			
			System.out.println("My account is: " + myAcct.toString());
			return myAcct;
		}
		
		} catch (SQLException e){
			LOGGER.error("Account not found", e);
		}
		return null;
	}
	
	@Override
	public boolean updateBalance(String user, long balance) {
		// TODO Auto-generated method stub
		LOGGER.setLevel(Level.DEBUG);
		try(Connection connection = ConnectionUtilPr0.getConnection()){
			int parameterIndex = 0;
			LOGGER.debug("Looking for account by the name of: " + user);
			String sql = "UPDATE USERACCT SET U_BALANCE = ? WHERE U_NAME = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(++parameterIndex, balance);
			statement.setString(++parameterIndex, user);
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
			
		} catch(SQLException e){
			return false;
		}
		
		return false;
	}
	
}
