package com.java8.lambda.unit1;

public class RunnableExample {
	
	public static void main(String args[]){
		Thread myThread = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Printed Inside Runnable");
			}
			
		});
	
	 
	 //Lambda Implementation
	 Thread myLabmdaThread = new Thread(() -> System.out.println("Printed Inside Lambda Runnable"));	
	
	 myThread.run();
	 
	 myLabmdaThread.start();
	 
	}

}
