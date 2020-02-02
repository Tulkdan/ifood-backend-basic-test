package com.ifood.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HttpClientTests {

    @Test
    public void shouldReturnAnInstanceOfHttpClientWithUrl() {
        String url = "https://google.com/";
        HttpClient client = new HttpClient(url);

        assertEquals(url, client.url);
    }

    @Test
    public void shouldAddQueryParamToUrl() {
        String url = "https://google.com/";
        HttpClient client = new HttpClient(url)
            .addQueryParam("q", "value");

        assertEquals("https://google.com/?q=value", client.url);
    }

    @Test
    public void shouldAddAnyQueryParamsToUrl() {
        String url = "https://google.com/";
        HttpClient client = new HttpClient(url)
            .addQueryParam("q", "value")
            .addQueryParam("city", "London")
            .addQueryParam("appid", "aassdd");

        String expected = url + "?q=value&city=London&appid=aassdd";
        assertEquals(expected, client.url);
    }

}