package com.java8.lambda.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.java8.lambda.unit1.Person;

public class StreamsExample1 {
	public static void main(String args[]){
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("lewis","carroll",42),
				new Person("thomas","carlyle",51),
				new Person("Charlotte","Brante",45),
				new Person("Mathew","Arnold", 39)
				);
/*		people.stream()
		.filter(p -> p.getLastName().startsWith("c"))
		.forEach(p->System.out.println(p.getFirstName()));*/

		
		long count  = people.parallelStream()
		.filter(p -> p.getLastName().startsWith("D")).count();
		
		System.out.println("count ::"+count);
		
		
		Consumer<Person> consumer = (t) -> System.out.println("I am a consumer interface call : "+t.getFirstName());
		people.forEach(consumer);
		
	}
}
