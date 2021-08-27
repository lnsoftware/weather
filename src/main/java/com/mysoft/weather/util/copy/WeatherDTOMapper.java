package com.mysoft.weather.util.copy;

import com.mysoft.weather.model.dto.WeatherDTO;
import com.mysoft.weather.model.vo.WeatherVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeatherDTOMapper {

    WeatherDTOMapper INSTANCE = Mappers.getMapper(WeatherDTOMapper.class);

    @Mappings({
            @Mapping(source = "location.name", target = "city"),
            @Mapping(source = "current.last_updated", target = "updateTime"),
            @Mapping(source = "current.condition.text", target = "weather"),
            @Mapping(source = "current.temp_c", target = "temperature"),
            @Mapping(source = "current.wind_degree", target = "wind")
    })

    WeatherDTO toWeatherDTO(WeatherVO weatherVO);

}
