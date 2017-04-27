package edu.aub.cmps253.loggers;
import java.util.Calendar;

import edu.aub.cmps253.loggers.sdk.AbstractLogger;
import edu.aub.cmps253.loggers.sdk.ILogger;
import edu.aub.cmps253.loggers.sdk.LoggingLevel;

public class ConsoleLogger extends AbstractLogger {

	private ConsoleLogger(LoggingLevel level){
		super(level);
	}
	
	public ConsoleLogger() { //this constructor is needed for the dynamic logger
		this(LoggingLevel.All);
	}
	public static ConsoleLogger createInstance(LoggingLevel level) {
		return new ConsoleLogger(level);
	}
	public static ILogger createInstance(){
		return createInstance(LoggingLevel.All);
	}
    
	@Override
	public void print(LoggingLevel level, String message){
    	if(level.ordinal() <= this.level.ordinal()) return; //is the severity level at or above the passed-in level?
    	
    	System.out.printf("%tr %s: %s\n", Calendar.getInstance(), level, message);
	}
}
