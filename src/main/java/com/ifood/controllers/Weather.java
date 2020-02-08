package com.ifood.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

import com.ifood.models.WeatherAPIModel;
import com.ifood.utils.HttpClientWeather;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Weather {

    private String API_KEY = System.getenv("WEATHER_API_KEY");

    @RequestMapping(path = "/weather")
    @ResponseBody
    public HashMap<String, String> index(@RequestParam String city) {

        HttpClientWeather client = new HttpClientWeather("https://api.openweathermap.org/data/2.5/weather")
            .addQueryParam("appid", API_KEY)
            .addQueryParam("q", city)
            .addQueryParam("units", "metric");

        try {
            WeatherAPIModel data = client.sendGet();
            return data.toOutput();
        } catch (IOException e) {
        }

        return new WeatherAPIModel().toOutput();

    }

}