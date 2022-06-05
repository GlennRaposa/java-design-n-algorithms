package com.algorithms.demo.gof.abstractFactory;

import com.algorithms.demo.gof.abstractFactory.topping.Cheese;
import com.algorithms.demo.gof.abstractFactory.topping.MozzarellaCheese;
import com.algorithms.demo.gof.abstractFactory.topping.Sauce;
import com.algorithms.demo.gof.abstractFactory.topping.TomatoSauce;

public class SicilianToppingFactory extends BaseToppingFactory{
    @Override
    public  Cheese createCheese(){return new MozzarellaCheese();}
    @Override
    public  Sauce createSauce(){return new TomatoSauce();}
}
