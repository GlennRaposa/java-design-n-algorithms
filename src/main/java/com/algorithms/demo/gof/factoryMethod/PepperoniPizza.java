package com.algorithms.demo.gof.factoryMethod;

public class PepperoniPizza extends Pizza {
    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for pepperoni pizza.");
    }
}