package com.ifood.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;

import com.ifood.models.WeatherAPIModel;
import com.ifood.models.WeatherMainModel;
import com.ifood.models.WeatherModel;
import com.ifood.utils.HttpClientWeather;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class WeatherTest {

    private HttpClientWeather api = Mockito.mock(HttpClientWeather.class);
    WeatherAPIModel mock = new WeatherAPIModel();

    @Before
    public void mockApiRequest() throws IOException {
        // TODO: figure it out why this is not mocking
        WeatherModel weather = new WeatherModel();
        weather.main = "Cloud";
        weather.description = "A bit cloudy";

        WeatherModel[] weathers = new WeatherModel[] {weather};

        WeatherMainModel weatherMain = new WeatherMainModel();
        weatherMain.temp = 12.2f;
        weatherMain.pressure = 20.0f;
        weatherMain.humidity = 2.2f;
        weatherMain.temp_min = 30.0f;
        weatherMain.temp_max = 10f;

        mock.weather = weathers;
        mock.main = weatherMain;

        when(api.sendGet()).thenReturn(mock);
    }

    @Test
    public void shouldReturnAnResponseForTheLocation() {
        Weather w = new Weather();

        HashMap<String, String> response = w.index("London");

        assertEquals(response, mock.toOutput());
    }
}