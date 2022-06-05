package com.algorithms.demo.designpattern.structural.decorator;

public class RoseBouquet extends FlowerBouquet{
	 
    public RoseBouquet(){
        description = "Rose bouquet";
    }
    public  double cost(){
        return 12.0;
    }
}