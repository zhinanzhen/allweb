package com.thinkinginjava.exception.test2;

public class TestLoggerException {
	public static void main(String[] args) {
		try {
			throw new LoggerException();
		} catch (LoggerException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------");
		try {
			throw new LoggerException();
		} catch (LoggerException e) {
			System.err.println("caught "+e);
		}
	}
}
