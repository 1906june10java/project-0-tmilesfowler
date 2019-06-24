package com.revature.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.service.ServiceBridge;

public class UnitTests {
	
	private static final ServiceBridge srvBrg = new ServiceBridge();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	//Login tests
	@Test
	public void infoGet() {
		final String userTst = "Revature";
		final String [] expected = {"1", "Revature", "p4ssw0rd", "500"};
		assertArrayEquals(expected, srvBrg.getUserInfo(userTst));
		
	}
	
	@Test
	public void infoGetInvalid() {
		final String userTst = "InvalidUser";
		final String [] expected = {null, null, null, null};
		assertArrayEquals(expected, srvBrg.getUserInfo(userTst));
	}

	//Balance change tests
	@Test
	public void balanceChange() {
		final String userTst = "JUnit";
		final long newBalance = 10;
		final String expected = String.valueOf(newBalance);
		srvBrg.pushNewBalance(userTst, newBalance);
		assertEquals(expected, srvBrg.getUserInfo(userTst)[3]);
	}
	
	@Test
	public void differentBalance() {
		final String userTst = "JUnit";
		final String oldBalance = srvBrg.getUserInfo(userTst)[3];
		final long newBalance = 150;
		srvBrg.pushNewBalance(userTst, newBalance);
		assertFalse(oldBalance == srvBrg.getUserInfo(userTst)[3]);
	}
	
	
}
