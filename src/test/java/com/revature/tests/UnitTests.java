package com.revature.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		final String userTst = "revature";
		final String [] expected = {"1", "REVATURE", "P4SSW0RD", "500"};
		assertArrayEquals(expected, srvBrg.getUserInfo(userTst));
		
	}
	
	@Test
	public void infoGetInvalid() {
		final String userTst = "NOTrevature";
		final String [] expected = {null, null, null, null};
		assertArrayEquals(expected, srvBrg.getUserInfo(userTst));
	}

	//Balance change tests
	
}
