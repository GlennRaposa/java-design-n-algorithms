package com.algorithms.demo.gof.abstractFactory.product;

import com.algorithms.demo.gof.abstractFactory.BaseToppingFactory;

public class CheesePizza extends Pizza {
    BaseToppingFactory toppingFactory;
    public CheesePizza(BaseToppingFactory toppingFactory){

        this.toppingFactory=toppingFactory;
    }
    @Override
    public void addIngredients() {
        System.out.println("Preparing ingredients for cheese pizza.");
        toppingFactory.createCheese();
        toppingFactory.createSauce();
            }

}
