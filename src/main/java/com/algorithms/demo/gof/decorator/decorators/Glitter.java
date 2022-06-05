package com.algorithms.demo.gof.decorator.decorators;

import com.algorithms.demo.gof.decorator.components.FlowerBouquet;

public class Glitter extends FlowerBouquetDecorator{
        FlowerBouquet flowerBouquet;
        public Glitter(FlowerBouquet flowerBouquet){
            this.flowerBouquet=flowerBouquet;
        }
        public  String getDescription(){
            return flowerBouquet.getDescription()+", glitter";
        }
        public double cost()
        {
            return 4+flowerBouquet.cost();
        }
    }


