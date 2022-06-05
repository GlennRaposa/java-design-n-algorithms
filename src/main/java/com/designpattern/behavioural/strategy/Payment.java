package com.designpattern.behavioural.strategy;
//http://www.journaldev.com/1827/java-design-patterns-example-tutorial#state-pattern
/*
        Payment 
       
  CreditCard    PayPal
   
*/    
public interface Payment {
	public void pay(int amount);
}
