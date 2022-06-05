package com.algorithms.demo.gof.abstractFactory;


import com.algorithms.demo.gof.abstractFactory.product.Pizza;

public abstract class BasePizzaFactory {
    
    public abstract Pizza createPizza(String type);
}
