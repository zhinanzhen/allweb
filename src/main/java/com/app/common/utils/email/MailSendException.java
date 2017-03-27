package com.app.common.utils.email;

@SuppressWarnings("serial")
public class MailSendException extends Exception {
	
	public MailSendException(String message, Throwable cause){
		super(message,cause);
	}
	
	public MailSendException(String message){
		super(message);
	}
}