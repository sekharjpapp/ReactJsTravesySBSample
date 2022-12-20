package com.pixel.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;

public class EndPoint extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        rest("/goRestPoint")
                .get("helloWorld")
                .produces("text/plain")
                .outType(String.class)
                .param()
                .name("name")
                .type(RestParamType.query)
                .endParam()
                .to("direct:helloWorld");

        from("direct:helloWorld").setBody(simple("Hello World, ${header.name}"));
    }
}
