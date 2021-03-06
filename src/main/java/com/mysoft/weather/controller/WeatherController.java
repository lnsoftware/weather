package com.mysoft.weather.controller;

import com.mysoft.weather.config.WeatherProperty;
import com.mysoft.weather.model.dto.AnswerDTO;
import com.mysoft.weather.model.dto.WeatherDTO;
import com.mysoft.weather.service.WeatherService;
import com.mysoft.weather.util.http.ResponseFactory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
        List<WeatherProperty.Country> countryList = weatherProperty.getCountryList();
        model.addAttribute("countryList", countryList);

        return "home";
    }

    /**
     * query weather with json result
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{city}", method = RequestMethod.GET)
    public ResponseEntity<AnswerDTO<WeatherDTO>> query(@PathVariable(name = "city") String city) {
        WeatherDTO dto = weatherService.query(city);

        return ResponseFactory.success(HttpStatus.OK, dto);
    }
}
