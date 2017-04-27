package edu.aub.cmps253.loggers.sdk;
public abstract class AbstractLogger implements ILogger {

	protected LoggingLevel level = LoggingLevel.All;

	@Override
	public void setLevel(LoggingLevel level) {
		this.level = level;
	}

	@Override
	public void info(String message){
		print(LoggingLevel.Info, message);
	}

	@Override
	public void warn(String message){
		print(LoggingLevel.Warning, message);
	}

	@Override
	public void severe(String message) {
		print(LoggingLevel.Severe, message);
	}

	@Override
	public void error(String message) {
		print(LoggingLevel.Error, message);
	}

	public abstract void print(LoggingLevel level, String message);
	
	public AbstractLogger(LoggingLevel level){
		this.level = level;
	}
}
