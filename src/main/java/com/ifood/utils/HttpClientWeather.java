package com.ifood.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.ifood.models.WeatherAPIModel;

import okhttp3.CacheControl;
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
            .cacheControl(new CacheControl.Builder()
                .maxAge(0, TimeUnit.SECONDS)
                .build()
            )
            .url(this.url)
            .build();

        Gson gson = new Gson(); 

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            ResponseBody body = response.body();
            String a = body.string();
            WeatherAPIModel entity = gson.fromJson(a, WeatherAPIModel.class);
            return entity;
        }
    }

}