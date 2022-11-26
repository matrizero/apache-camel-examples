package com.matrizero.camelrestdsl.routes;

import com.matrizero.camelrestdsl.model.Contract;
import com.matrizero.camelrestdsl.processor.ContractValidateProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectConditionContractRoute extends RouteBuilder {

    @Autowired
    ContractValidateProcessor processor;

    @Override
    public void configure() throws Exception {

        from("direct:decisionContract")
                .routeId("decision-contract-route")
                .log("${body}")
//                .marshal(new JacksonDataFormat(Contract.class))
//                .log("${body}")
                .process(processor)
                .choice()
                    .when(exchangeProperty("verifyAssign").isEqualTo(Boolean.TRUE))
                //.when(exchange -> exchange.getIn().getBody(Contract.class).getAssign()) // == Boolean.TRUE
                        .log("Contract assigned")
                        .to("direct:postContract")
                    .otherwise()
                        .log("Contract not assigned")
                .endChoice()
                .end();


    }
}
