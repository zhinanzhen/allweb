package com.design_pattern.command;

public class MyCommand implements Command {
	private Solider solider;
	
	public MyCommand(Solider solider) {
		super();
		this.solider = solider;
	}

	@Override
	public void exe() {
		solider.action();
	}

}
