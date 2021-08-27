package com.mysoft.weather.controller;

import com.mysoft.weather.config.WeatherProperty;
import com.mysoft.weather.model.dto.WeatherDTO;
import com.mysoft.weather.service.WeatherService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WeatherController {

    @NonNull
    private WeatherProperty weatherProperty;

    @NonNull
    private WeatherService weatherService;

    /**
     * show weather home page
     *
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        List<String> cityList = weatherProperty.getCityList();
        model.addAttribute("cityList", cityList);

        return "home";
    }

    /**
     * query weather with json result
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public ResponseEntity<WeatherDTO> query(@PathVariable(name = "city") String city) {
        WeatherDTO dto = weatherService.query(city);

        return ResponseEntity.ok(dto);
    }
}
