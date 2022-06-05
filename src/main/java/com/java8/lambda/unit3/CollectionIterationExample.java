package com.java8.lambda.unit3;

import java.util.Arrays;
import java.util.List;

import com.java8.lambda.unit1.Person;

public class CollectionIterationExample {

	public static void main(String args[]){
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("lewis","carroll",42),
				new Person("thomas","carlyle",51),
				new Person("Charlotte","Brante",45),
				new Person("Mathew","Arnold", 39)
				);
		
		
		people.forEach(p -> System.out.println(p));
		
		
		//people.forEach(System.out::println);
		
	}
}
