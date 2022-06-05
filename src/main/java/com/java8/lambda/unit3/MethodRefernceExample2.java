package com.java8.lambda.unit3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.lambda.unit1.Person;

public class MethodRefernceExample2 {
	
	public static void main(String args[]){
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("lewis","carroll",42),
				new Person("thomas","carlyle",51),
				new Person("Charlotte","Brante",45),
				new Person("Mathew","Arnold", 39)
				);
		
		performConditionally(people, p -> true,System.out::println);
		

	}
	
	public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
		for(Person aPerson : people){
			if(predicate.test(aPerson)){
				consumer.accept(aPerson);
			}	
		}
	}

}
