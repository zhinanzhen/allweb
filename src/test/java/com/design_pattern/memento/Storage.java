package com.design_pattern.memento;

public class Storage {
	private Memento memento;

	public Storage(Memento memento) {
		super();
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
