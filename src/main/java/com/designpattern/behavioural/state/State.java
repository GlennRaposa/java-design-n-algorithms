package com.designpattern.behavioural.state;
//http://www.blackwasp.co.uk/State_2.aspx
//http://www.journaldev.com/1751/state-design-pattern-java
/*
 * Rules of thumb
 * 
//https://sourcemaking.com/design_patterns/state
State objects are often Singletons.

Flyweight explains when and how State objects can be shared.

Interpreter can use State to define parsing contexts.
Strategy has 2 different implementations, the first is similar to State. 
The difference is in binding times (Strategy is a bind-once pattern, whereas State is more dynamic).

The structure of State and Bridge are identical (except that Bridge admits hierarchies of envelope classes, whereas State allows only one). 
The two patterns use the same structure to solve different problems: State allows an object's 
behavior to change along with its state, while Bridge's intent is to decouple an abstraction from its implementation 
so that the two can vary independently.

The implementation of the State pattern builds on the Strategy pattern. 
The difference between State and Strategy is in the intent. With Strategy, the choice of algorithm is fairly stable. 
With State, a change in the state of the "context" object causes it to select from its "palette" of Strategy objects.

 */
public interface State {
	public void doAction();
}
