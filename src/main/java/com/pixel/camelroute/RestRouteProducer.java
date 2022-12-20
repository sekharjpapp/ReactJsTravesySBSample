package com.pixel.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRouteProducer extends RouteBuilder {

    //http://localhost:8080/camel/say
    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/say")
                .get().to("direct:hello");

        from("direct:hello")
                .transform().constant("Hello World !!!");
    }
}
