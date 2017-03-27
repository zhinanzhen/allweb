package com.design_pattern.visitor;

public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject subject) {
		System.out.println("visit : " + subject.getSubject());
	}

}
