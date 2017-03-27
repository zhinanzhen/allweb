package com.thinkinginjava.exception.test2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class LoggerException extends Exception{
	private static Logger log = Logger.getLogger("LoggerException");
	public LoggerException(){
		StringWriter sw = new StringWriter();
		printStackTrace(new PrintWriter(sw));
		log.severe(sw.toString());
	}
}
