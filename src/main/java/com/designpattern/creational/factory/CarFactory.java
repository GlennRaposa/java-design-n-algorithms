package com.designpattern.creational.factory;
/*
 * Factory pattern is most suitable where there is some complex object creation steps are involved. 
 * To ensure that these steps are centralized and not exposed to composing classes, factory pattern should be used. 
 * We can see many examples of factory pattern in JDK itself e.g.

   java.sql.DriverManager#getConnection()
   java.net.URL#openConnection()
 */
public class CarFactory {
	
	   public static Car buildCar(CarType model) {
	        Car car = null;
	        switch (model) {
	        case SMALL:
	            car = new SmallCar();
	            break;
	 
	        case SEDAN:
	            car = new SedanCar();
	            break;
	 
	        case LUXURY:
	            car = new LuxuryCar();
	            break;
	 
	        default:
	            // throw some exception
	            break;
	        }
	        return car;
	    }
	   
	   public static void main(String args[]){
			System.out.println(CarFactory.buildCar(CarType.SMALL));
			System.out.println(CarFactory.buildCar(CarType.SEDAN));
			System.out.println(CarFactory.buildCar(CarType.LUXURY));
	   }
}
