package com.designpattern.creational.Builder;
//http://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
//https://jlordiales.me/2012/12/13/the-builder-pattern-in-practice/
/*
 * Builder pattern aims to “Separate the construction of a complex object 
   from its representation so that the same construction process can create different representations.”
   
   Example of this pattern in JDK  [StringBuilder/StringBuffer]
   StringBuilder builder = new StringBuilder("Temp");
   String data = builder.append(1)
                .append(true)
                .append("friend")
                .toString();
*/
public class User {

   private final String firstName;
   private final String lastName;
   private final String age;
   private final String phone;
   private final String address;
   
   private User(UserBuilder userBuilder){
	   this.firstName = userBuilder._firstName;
	   this.lastName = userBuilder._lastName;
	   this.age = userBuilder._age;
	   this.phone = userBuilder._phone;
	   this.address = userBuilder._address;
   }
   
   public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
	
	public static class UserBuilder{
		
		   private String _firstName;
		   private String _lastName;
		   private String _age;
		   private String _phone;
		   private String _address;
		   
		   //You could have multiple Parameter Constructors but for now i am using only the default constructor
		   public UserBuilder(){
			   
		   }

		   public UserBuilder firstName(final String firstname){
			   this._firstName = firstname;
			   return this;
		   }
		   
		   public UserBuilder lastName(final String lastname){
			   this._lastName = lastname;
			   return this;
		   }
		   
		   public UserBuilder age(final String age){
			   this._age = age;
			   return this;
		   }
		   
		   public UserBuilder phone(final String phone){
			   this._phone = phone;
			   return this;
		   }
		   
		   public UserBuilder address(final String address){
			   this._address = address;
			   return this;
		   }
		   
		   public User buildUser(){
			   User user = new User(this);
			   validateUserObject(user);
			   return user;
		   }
		   
		   private void validateUserObject(User user) {
	            //Do some basic validations to check 
	            //if user object does not break any assumption of system
	        }
		   
	}
   
	
	public static void main(String args[]){
		User user = new User.UserBuilder().firstName("Glenn").lastName("Raposo").age("37").address("Everett").phone("111").buildUser();
		System.out.println("Stand up ::"+user.firstName);
	}
	
}
