package com.designpattern.behavioural.state;
//http://www.journaldev.com/1751/state-design-pattern-java

public class TVStopState implements State{
	
	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
	
}
