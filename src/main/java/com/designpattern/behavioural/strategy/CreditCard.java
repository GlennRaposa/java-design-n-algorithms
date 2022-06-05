package com.designpattern.behavioural.strategy;
//https://www.javacodegeeks.com/2013/08/strategy-design-pattern-in-java-example-tutorial.html
public class CreditCard implements Payment {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCard(String nm, String ccNum, String cvv, String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	
	@Override
	public void pay(int amount) {
		System.out.println(amount +" paid with credit/debit card");
	}

}