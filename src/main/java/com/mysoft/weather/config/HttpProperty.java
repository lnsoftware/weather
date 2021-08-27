package com.mysoft.weather.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "http")
public class HttpProperty {

    private int connectionTimeout;

    private int readTimeout;

}
