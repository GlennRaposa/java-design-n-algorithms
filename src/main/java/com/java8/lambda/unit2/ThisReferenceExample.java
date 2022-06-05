package com.java8.lambda.unit2;

public class ThisReferenceExample {
   
	public void doProcess(int i, Process p){
		p.process(i);
	}
	
	public void execute(){
		doProcess(10, i ->{
			System.out.println("value of i ::"+i);
			System.out.println(this);
		});
	}
	
	public static void main(String args[]){
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		/*thisReferenceExample.doProcess(10, i ->{
			System.out.println("value of i ::"+i);
			//System.out.println(this);
		});*/
		
		thisReferenceExample.execute();
	}
	
	@Override
	public String toString(){
		return "THIS IS FROM THE CLASS";
	}
}
