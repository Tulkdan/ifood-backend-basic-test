package com.ifood.models;

import java.util.HashMap;

public class WeatherAPIModel {

    public WeatherModel[] weather;
    public WeatherMainModel main;

    public HashMap<String, String> toOutput() {
        HashMap<String, String> map = new HashMap<>();
        map.put("tempo", this.weather[0].main);
        map.put("descricao", this.weather[0].description);
        map.put("temperatura", this.main.temp.toString());
        map.put("pressao", this.main.pressure.toString());
        map.put("humidade", this.main.humidity.toString());
        map.put("temperatura_max", this.main.temp_max.toString());
        map.put("temperatura_min", this.main.temp_min.toString());
        return map;
    }

}