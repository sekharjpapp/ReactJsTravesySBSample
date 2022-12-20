package com.pixel.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "camel.hello.enabled", havingValue = "true")
public class CamelChoiceRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:greeting")
                .log("Hello ${body}")
                .choice()
                .when().simple("${body} contains 'Team'")
                .log("I like to work with team")
                .otherwise()
                .log("Solo fighter :)")
                .end()
                .end();
    }
}
