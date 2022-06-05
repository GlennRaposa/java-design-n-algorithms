package com.designpattern.behavioural.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class EmpCareTaker {
	 
	 
    final Deque<EmpMemento> mementos = new ArrayDeque<>();
    public EmpMemento getMemento()
    {
 
        EmpMemento empMemento= mementos.pop();
        return empMemento;
    }
 
    public void addMemento(EmpMemento memento)
    {
        mementos.push(memento);
 
    }
}
