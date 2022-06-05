package com.javadatastructure;

public class Dog_ReferenceAssignment {
   private String name; 
   public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Dog_ReferenceAssignment(String name){
	   this.name = name;
   }
   
   public static void foo(Dog_ReferenceAssignment someDog) {
	    someDog.setName("Max");     // AAA
	    someDog = new Dog_ReferenceAssignment("Fifi");  // BBB
	    someDog.setName("Rowlf");   // CCC
	    
	}
   
   public static void main(String args[]){
	   
	   Dog_ReferenceAssignment myDog = new Dog_ReferenceAssignment("Rover");
	   foo(myDog);
	   
	   System.out.println(myDog.getName());
	   
   }
}
