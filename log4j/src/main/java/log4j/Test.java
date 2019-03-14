package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
public static void main(String[] args) {
	//PropertyConfigurator.configure("C:\\Users\\rameshacp12429\\Documents\\workspace-spring-tool-suite-4-4.1.1.RELEASE\\log4j\\src\\main\\resources\\log4j.properties");
		/*
		 * Logger logger = Logger.getLogger("MYLOGGER"); logger.info("test");
		 */
	Logger log = Logger.getLogger("MYLOGGER");
	log.trace("Trace Message!");
    log.debug("Debug Message!");
    log.info("Info Message!");
    log.warn("Warn Message!");
    log.error("Error Message!");
    log.fatal("Fatal Message!");
 }
}
