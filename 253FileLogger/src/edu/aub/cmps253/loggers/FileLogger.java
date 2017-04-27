package edu.aub.cmps253.loggers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

import edu.aub.cmps253.loggers.sdk.AbstractLogger;
import edu.aub.cmps253.loggers.sdk.LoggingLevel;

public class FileLogger extends AbstractLogger {

	private FileLogger(LoggingLevel level) throws IOException{
		super(level);
		File logFile = new File("Log.txt");
		if(!logFile.exists()) {
			try (BufferedWriter out = new BufferedWriter(new FileWriter("Log.txt"))){};
		} 
	}
	public FileLogger() throws IOException { //this constructor is needed for the dynamic logger
		this(LoggingLevel.All);
	}
	@Override
	public void print(LoggingLevel level, String message) {
		if(level.ordinal() <= this.level.ordinal()) return;

		try {
			String m = String.format("%tr %s: %s\n", Calendar.getInstance(), level, message); 
			Files.write(Paths.get("Log.txt"), m.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static FileLogger getLogger(LoggingLevel level) {
		try {
			return new FileLogger(level);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static FileLogger getLogger() {
		return getLogger(LoggingLevel.All);
	}
}