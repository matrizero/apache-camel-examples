package com.matrizero.camelrestdsl.processor;

import com.matrizero.camelrestdsl.model.Contract;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ContractValidateProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Boolean verifyAssign =  exchange.getIn().getBody(Contract.class).getAssign();

        System.out.println("EXCHANGE É:"+verifyAssign);

        exchange.setProperty("verifyAssign", verifyAssign);

//        exchange.getIn().setBody("");

    }
}
