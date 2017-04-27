import edu.aub.cmps253.loggers.sdk.ILogger;
import edu.aub.cmps253.loggers.sdk.LoggerFactory;
import edu.aub.cmps253.loggers.sdk.LoggingLevel;

public class Client {
	public static void main(String[] args) {
		ILogger log = LoggerFactory.getDynamicLogger();
		log.setLevel(LoggingLevel.All); //should be read from the config file
		log.info("Hello from CMPS253 Logger!");
	}
}