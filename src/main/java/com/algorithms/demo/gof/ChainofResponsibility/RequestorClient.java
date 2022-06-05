package com.algorithms.demo.gof.ChainofResponsibility;

        import com.algorithms.demo.gof.ChainofResponsibility.handlers.BillingSupportHandler;
        import com.algorithms.demo.gof.ChainofResponsibility.handlers.AbstractSupportHandler;
        import com.algorithms.demo.gof.ChainofResponsibility.handlers.GeneralSupportHandler;
        import com.algorithms.demo.gof.ChainofResponsibility.handlers.TechnicalSupportHandler;

public class RequestorClient {

    public  static AbstractSupportHandler getHandlerChain(){


        AbstractSupportHandler technicalSupportHandler = new TechnicalSupportHandler( AbstractSupportHandler.TECHNICAL);
        AbstractSupportHandler billingSupportHandler = new BillingSupportHandler(  AbstractSupportHandler.BILLING);
        AbstractSupportHandler generalSupportHandler = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);

        technicalSupportHandler.setNextHandler(billingSupportHandler);
        billingSupportHandler.setNextHandler(generalSupportHandler);

        return technicalSupportHandler;
    }

}
