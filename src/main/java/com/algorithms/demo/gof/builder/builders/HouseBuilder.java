package com.algorithms.demo.gof.builder.builders;

import com.algorithms.demo.gof.builder.product.House;

public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void paintHouse();
    void furnishHouse();
    House getHouse();
}
