package com.algorithms.demo.gof.abstractFactory;

import com.algorithms.demo.gof.abstractFactory.topping.CaliforniaOilSauce;
import com.algorithms.demo.gof.abstractFactory.topping.Cheese;
import com.algorithms.demo.gof.abstractFactory.topping.GoatCheese;
import com.algorithms.demo.gof.abstractFactory.topping.Sauce;

public class GourmetToppingFactory extends BaseToppingFactory{
    @Override
    public Cheese createCheese(){return new GoatCheese();}
    @Override
    public Sauce createSauce(){return new CaliforniaOilSauce();}
}
