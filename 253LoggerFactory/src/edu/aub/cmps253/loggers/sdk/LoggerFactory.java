package edu.aub.cmps253.loggers.sdk;

import edu.aub.cmps253.loggers.ConsoleLogger;
import edu.aub.cmps253.loggers.FileLogger;
import edu.aub.cmps253.loggers.sdk.ILogger;
import edu.aub.cmps253.utils.XmlHelper;

public class LoggerFactory<T> {
	private static ILogger logger;

	private LoggerFactory () {}

	public static ILogger getLogger(){
		if(logger!=null) return logger;
		try {
			XmlHelper xml = new XmlHelper("Config.xml");
			String loggerType = xml.getElement("Logger");
			if(loggerType.equals("FileLogger"))
				logger = FileLogger.getLogger(); 
			else 
				logger = ConsoleLogger.createInstance();

			return logger;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static ILogger getDynamicLogger(){ //this method replaces the getLogger() method above (no need for an if statement anymore)
		if(logger!=null) return logger;
		try {
			XmlHelper xml = new XmlHelper("Config.xml");
			String loggerType = xml.getElement("DynamicLogger");
			Class<?> c= Class.forName(loggerType);
			logger = (ILogger)c.newInstance();

			return logger;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
} 