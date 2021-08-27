package com.mysoft.weather.service;

import com.mysoft.weather.model.dto.WeatherDTO;

public interface WeatherService {

    WeatherDTO query(String city);

}
