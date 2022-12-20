package com.pixel.camelroute;

import com.pixel.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.support.DefaultMessage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestJavaDsl extends RouteBuilder {

    private final WeatherDataProvider weatherDataProvider;
    @Override
    public void configure() throws Exception {
       /* restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.auto);
        rest()
                .consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
                .get("/weather/{city}").outType(WeatherDto.class).to("direct:get-weather-data");

        from("direct:get-weather-data").process(this::getWeatherData);*/

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.auto);

        from("rest:get:javadsl/weather/{city}?produces=application/json")
                .outputType(WeatherDto.class)
                .process(this::getWeatherData);
    }

    private void getWeatherData(Exchange exchange) {
        String city = exchange.getMessage().getHeader("city",String.class);
        WeatherDto currentWeather = weatherDataProvider.getCurrentWeather(city);

        Message message = new DefaultMessage(exchange.getContext());
        message.setBody(currentWeather);
        exchange.setMessage(message);
    }
}
