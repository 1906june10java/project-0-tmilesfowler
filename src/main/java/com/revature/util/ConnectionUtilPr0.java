package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.util.ConnectionUtilPr0;

public class ConnectionUtilPr0 {
	// USE INSTEAD OF SYSOUT
		private static final Logger LOGGER = Logger.getLogger(ConnectionUtilPr0.class);
		
		public static Connection getConnection() throws SQLException {
			LOGGER.setLevel(Level.DEBUG);
			String url = "jdbc:oracle:thin:@myrevaturerds.ck0lmtvj5bg5.us-east-2.rds.amazonaws.com:1521:ORCL";
			String username = "tmilesfowler";
			String password = "Milomio12!";
			return DriverManager.getConnection(url, username, password);
			
		}
		/**
		public static void main(String[] args) {
			try {
				getConnection();
				LOGGER.info("Connection successful");
			} catch (SQLException e) {
				LOGGER.error("Could not connect.", e);
			}
		}
		*/
}
