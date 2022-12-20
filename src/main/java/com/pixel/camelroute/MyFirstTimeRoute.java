package com.pixel.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//@Component
public class MyFirstTimeRoute extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {

        from("timer:first-timer")
                .bean(getCurrentTimeBean)
                .to("log:first-timer");
    }
}
@Component
class GetCurrentTimeBean {

    public String getCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }
}
