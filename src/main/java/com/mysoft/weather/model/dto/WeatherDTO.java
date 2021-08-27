package com.mysoft.weather.model.dto;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class WeatherDTO {

    private String city;

    private Date updateTime;

    private String weather;

    private String temperature;

    private String wind;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdateTime() {
        Instant instant = updateTime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String weekDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        LocalTime localTime = instant.atZone(zoneId).toLocalTime();

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("h:mm a");
        String time = localTime.format(outputFormatter);

        return weekDay + " " + time;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        temperature += " °C";
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        wind += " km/h";
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
