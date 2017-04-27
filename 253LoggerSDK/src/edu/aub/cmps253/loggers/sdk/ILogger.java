package edu.aub.cmps253.loggers.sdk;
public interface ILogger {
	
	void severe(String message);
	
	void info(String message);

	void warn(String message);

	void error(String message);

	void setLevel(LoggingLevel level);
	
}