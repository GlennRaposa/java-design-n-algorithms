package com.algorithms.demo.gof.facade.subcomponents;


import com.algorithms.demo.gof.facade.domain.Product;

public class InventoryService {
    public static boolean isAvailable(Product product){
        /*Check Warehouse database for product availability*/
        return true;
    }
}
