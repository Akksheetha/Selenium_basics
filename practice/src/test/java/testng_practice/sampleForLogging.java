package testng_practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class sampleForLogging {

	private static final Logger logger = LogManager.getLogger(sampleForLogging.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.info("Check for working");
		logger.warn("WArning message");
	}

}
