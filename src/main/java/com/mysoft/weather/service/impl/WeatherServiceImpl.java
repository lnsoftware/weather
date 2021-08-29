package com.mysoft.weather.service.impl;

import com.mysoft.weather.config.WeatherProperty;
import com.mysoft.weather.exception.BuzzException;
import com.mysoft.weather.exception.ErrorEnum;
import com.mysoft.weather.model.dto.WeatherDTO;
import com.mysoft.weather.model.vo.WeatherVO;
import com.mysoft.weather.service.WeatherService;
import com.mysoft.weather.util.ParamUtil;
import com.mysoft.weather.util.copy.WeatherDTOMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    @NonNull
    private RestTemplate restTemplate;

    @NonNull
    private WeatherProperty weatherProperty;

    @Override
    public WeatherDTO query(String city) {
        if (StringUtils.isBlank(city)) {
            throw new BuzzException(ErrorEnum.CITY_BLANK);
        }

        String url = ParamUtil.completeUrl(weatherProperty.getUrl(), weatherProperty.getApiKey(), city);
        WeatherVO result = restTemplate.getForObject(url, WeatherVO.class);
        if (Objects.isNull(result)) {
            throw new BuzzException(ErrorEnum.WEATHER_EMPTY_RESULT);
        }

        WeatherDTO weatherDTO = WeatherDTOMapper.INSTANCE.toWeatherDTO(result);

        return weatherDTO;
    }
}