package com.algorithms.demo.designpattern.behavioural.state;

public class TVStartState implements State {

	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}

}
