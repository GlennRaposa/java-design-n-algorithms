package com.java8.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseJava7 {

	public static void main(String args[]){
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("lewis","carroll",42),
				new Person("thomas","carlyle",51),
				new Person("Charlotte","Brante",45),
				new Person("Mathew","Arnold", 39)
				);
		
		//Step1: Sort List by last name
		Collections.sort(people, new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2){
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		
		//Step2:create a method that prints all elements in the list\
		//printAll(people);
		
		
		//Step3: create a method that prints all people that have last name beginning with C
		System.out.println("Printing All Persons with last name beginning with C");
		printConditionally(people, new Condition(){
			@Override
			public boolean test(Person p){
				return p.getLastName().startsWith("c");
			}
		});
		
		System.out.println("Printing All Persons with first name beginning with C");
		printConditionally(people, new Condition(){
			@Override
			public boolean test(Person p){
				return p.getFirstName().startsWith("C");
			}
		});
		
	}
	
	public static void printAll(List<Person> people){
		for(Person aPerson : people){
			System.out.println(aPerson.toString());
		}
	}
	
	public static void printConditionally(List<Person> people, Condition condition){
		for(Person aPerson : people){
			if(condition.test(aPerson)){
				System.out.println(aPerson.toString());
			}	
		}
	}
}

interface Condition{
	boolean test(Person p);
}
