package com.matrizero.camelrestdsl.router;

import com.matrizero.camelrestdsl.model.Contract;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MainRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

//       restConfiguration()
//               .component("servlet")
//               .port(8081).host("localhost")
//               .bindingMode(RestBindingMode.json)
//               .enableCORS(true);


//        rest().post("/event")
//                .consumes(MediaType.APPLICATION_JSON_VALUE)
//                .type(Contract.class)
//                .outType(Contract.class)
//                .to("direct:postContract");




        /** Esse modo funciona **/

        rest("/v1")
                .description("Main api entry")
                .bindingMode(RestBindingMode.json)
                .post("/contracts")
                .consumes(MediaType.APPLICATION_JSON_VALUE).type(Contract.class).outType(Contract.class)
                .route().routeId("rest-contract")
                .to("direct:decisionContract")
                .endRest();

        /** Esse modo funciona **/

//        rest("/v1")
//                .post("/contracts")
//                .consumes(MediaType.APPLICATION_JSON_VALUE).type(Contract.class).outType(Contract.class)
//                .route().routeId("rest-contract")
//                .to("direct:postContract")
//                .endRest();
    }
}
