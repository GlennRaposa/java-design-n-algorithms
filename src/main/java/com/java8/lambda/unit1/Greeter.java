package com.java8.lambda.unit1;

public class Greeter {
	
	public void greet(Greeting greeting){
		greeting.perform();
	}

	public static void main(String args[]){
		Greeter greeter = new Greeter();
		
		Greeting helloWorldGreeting = new Greeting(){
		  public void perform(){
			  System.out.println("--- HELLO ANON INNNER CLASS ----");
		  }
	  };
	  //Calling Inner Class
	  //helloWorldGreeting.perform();
	  
	  
	  //------- Functional Programming
	  Greeting functionalGreeting = () -> System.out.println("----- HELLO FUNCTIONAL PROGRAMMING ------");
	  //functionalGreeting.perform();
	  
	  
	  greeter.greet(functionalGreeting);
	  greeter.greet(helloWorldGreeting);
	  
	  greeter.greet(() -> System.out.println("----- HELLO FUNCTIONAL PROGRAMMING ------"));
	  
	}
	
	
}
