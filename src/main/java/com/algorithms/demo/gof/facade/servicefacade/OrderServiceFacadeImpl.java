package com.algorithms.demo.gof.facade.servicefacade;

import com.algorithms.demo.gof.facade.domain.Product;
import com.algorithms.demo.gof.facade.subcomponents.PaymentService;
import com.algorithms.demo.gof.facade.subcomponents.ShippingService;
import com.algorithms.demo.gof.facade.subcomponents.InventoryService;

public class OrderServiceFacadeImpl implements OrderServiceFacade{

    public boolean placeOrder(int pId){
        boolean orderFulfilled=false;
        Product product=new Product();
        product.productId=pId;
        if(InventoryService.isAvailable(product))
        {
            System.out.println("Product with ID: "+ product.productId+" is available.");
            boolean paymentConfirmed= PaymentService.makePayment();
            if(paymentConfirmed){
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled=true;
            }
        }
        return orderFulfilled;
    }
}
