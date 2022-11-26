package com.matrizero.camelrestdsl.routes;

import com.matrizero.camelrestdsl.model.Contract;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class DirectPostContractRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:postContract")
                .routeId("insert-contract-route")
                .log("${body}")
                .removeHeaders("CamelHttp*")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .marshal(new JacksonDataFormat(Contract.class))

                .log("${body}")
                .toD("http://localhost:8082/contracts?bridgeEndpoint=true")
                .unmarshal(new JacksonDataFormat(Contract.class))
                .end();

    }
}
