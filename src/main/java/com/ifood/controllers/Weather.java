package com.ifood.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ifood.models.WeatherAPIModel;
import com.ifood.utils.HttpClientWeather;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Weather {

    private String API_KEY = "e67eb2059e397b69cfbe8ef97f015799";

    // https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22
    @RequestMapping(path = "/weather")
    @ResponseBody
    public String index(@RequestParam String city) {

        HttpClientWeather client = new HttpClientWeather("api.openweathermap.org/data/2.5/weather");
        client.addQueryParam("appid", API_KEY);
        client.addQueryParam("q", city);

        WeatherAPIModel data = client.sendGet();

        return "";
    }

}