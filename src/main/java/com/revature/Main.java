package com.revature;

import java.io.IOException;

import com.revature.controller.ControlHandler;

/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		
		ControlHandler control = new ControlHandler();
		control.userInput();
	}
}
