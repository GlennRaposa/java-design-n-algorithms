package com.java8.lambda.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.lambda.unit1.Person;

public class StandardFunctionalInterfacesExample2 {

		public static void main(String args[]){
			List<Person> people = Arrays.asList(
					new Person("Charles","Dickens",60),
					new Person("lewis","carroll",42),
					new Person("thomas","carlyle",51),
					new Person("Charlotte","Brante",45),
					new Person("Mathew","Arnold", 39)
					);
			
			//Step1: Sort List by last name
			Collections.sort(people, (p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
			
			
			//Step2:create a method that prints all elements in the list\
			performConditionally(people, p -> true, p -> System.out.println(p));
			
			
			//Step3: create a method that prints all people that have last name beginning with C
			System.out.println("");
			System.out.println("Printing All Persons with last name beginning with C");
			performConditionally(people, p -> p.getLastName().startsWith("c"), p -> System.out.println(p.getLastName()));
			
			System.out.println("");
			System.out.println("Printing All Persons with first name beginning with C");
			performConditionally(people,  p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));
			
		}
		
		public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
			for(Person aPerson : people){
				if(predicate.test(aPerson)){
					consumer.accept(aPerson);
				}	
			}
		}
}
