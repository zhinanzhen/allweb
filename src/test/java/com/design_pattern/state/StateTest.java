package com.design_pattern.state;

public class StateTest {
	public static void main(String[] args) {
		State state = new State();
		state.setValue("1");
		Context context = new Context();
		context.setState(state);
		context.opertion();
	}
}
