package com.tuenti.util;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsoleLog.
 * This class save the messages and prints them
 */
public class ConsoleLog {

	/** The messages. */
	private List<String> messages = new ArrayList<>();
	
	/** The console log. */
	private static ConsoleLog consoleLog;

	/**
	 * Gets the single instance of ConsoleLog.
	 *
	 * @return single instance of ConsoleLog
	 */
	public static synchronized ConsoleLog getInstance() {
		if (consoleLog == null) {
			consoleLog = new ConsoleLog();
		}
		return consoleLog;

	}
	
	
	/**
	 * Adds the message.
	 *
	 * @param message the message
	 */
	public void addMessage(String message){
		messages.add(message);		
	}
	
	/**
	 * Prints the messages.
	 */
	public void printMessages(){
		for (int i =0 ; i< messages.size();i++){
			System.out.println("Case #" + (i+1) +": " +messages.get(i) );			
		}		
	}
}
