package com.ifood.utils;

import java.io.IOException;

import com.ifood.models.WeatherAPIModel;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpClientWeather extends HttpClient {

    private final OkHttpClient httpClient = new OkHttpClient();

    public HttpClientWeather(String url) {
        super(url);
    }

    public WeatherAPIModel sendGet() throws IOException {
        Request request = new Request.Builder()
            .url(this.url)
            .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            ResponseBody body = response.body();
        }
    }

}