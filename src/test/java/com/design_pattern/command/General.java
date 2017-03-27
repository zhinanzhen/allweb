package com.design_pattern.command;

public class General {
	private Command command;
	
	public General(Command command) {
		super();
		this.command = command;
	}

	public void action(){
		command.exe();
	}
}
