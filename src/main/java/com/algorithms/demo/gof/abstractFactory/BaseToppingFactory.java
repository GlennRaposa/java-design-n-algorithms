package com.algorithms.demo.gof.abstractFactory;

import com.algorithms.demo.gof.abstractFactory.topping.Cheese;
import com.algorithms.demo.gof.abstractFactory.topping.Sauce;

public abstract class BaseToppingFactory {
    public abstract Cheese createCheese();
    public abstract Sauce createSauce();
}
