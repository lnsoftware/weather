package com.mysoft.weather.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "weather")
public class WeatherProperty {

    private String apiKey;

    private String url;

    private List<Country> countryList;

    @Data
    public static class Country {

        private String name;

        private List<String> cityList;
    }
}
