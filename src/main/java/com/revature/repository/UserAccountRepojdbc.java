package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.UserAccount;
import com.revature.util.ConnectionUtilPr0;

public class UserAccountRepojdbc implements UserAccountRepository{

	private static final Logger LOGGER = Logger.getLogger(UserAccountRepojdbc.class);
	
	@Override
	public UserAccount getUserAcct(String user) {
		// TODO Auto-generated method stub
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
			
			LOGGER.debug("My account is: " + myAcct.toString());
			return myAcct;
		}
		
		} catch (SQLException e){
			LOGGER.error("Account not found", e);
		}
		return null;
	}
	
	public List<UserAccount> getAllUsers(){
		LOGGER.debug("Getting all users");
		try(Connection connection = ConnectionUtilPr0.getConnection()){
			String sql = "SELECT * FROM USERACCT";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			List<UserAccount> allUsers = new ArrayList<>();
			
			while(result.next()) {
				
				allUsers.add (new UserAccount (
						result.getLong("U_ID"),
						result.getString("U_NAME"),
						result.getString("U_PASSWORD"),
						result.getLong("U_BALANCE")
						));
			}
			
			return allUsers;
			
		} catch (SQLException e) {
			LOGGER.error("Counld not get all accounts.");
		}
		
		return null;
	}
	
	public boolean createUserAccount(long iDNum, String userName, String passWord) {
		LOGGER.debug("Creating account: " + userName + ", " + passWord);
		try(Connection connection = ConnectionUtilPr0.getConnection()){
			int parameterIndex = 0;
			String sql = "INSERT INTO USERACCT VALUES (?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(++parameterIndex, iDNum);
			statement.setString(++parameterIndex, userName);
			statement.setString(++parameterIndex, passWord);
			statement.setLong(++parameterIndex, 0);
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			LOGGER.error("Could not create account", e);
		}
		
		return false;
	}
	
	@Override
	public boolean updateBalance(String user, long balance) {
		// TODO Auto-generated method stub
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
