package com.design_pattern.state;

public class Context {
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void opertion(){
		if("1".equals(state.getValue())){
			state.method1();
		}
		if("2".equals(state.getValue())){
			state.method2();
		}
	}
}
