package com.ifood.utils;

public class HttpClient {

    public String url;

    public HttpClient(String url) {
        this.url = url;
    }

    private String forQueryString(String query, String value) {
        return query.concat("=").concat(value);
    }

    public HttpClient addQueryParam(String query, String value) {
        if (this.url.contains("?")) {
            this.url = this.url.concat("&");
        } else {
            this.url = this.url.concat("?");
        }
        this.url = this.url.concat(this.forQueryString(query, value));
        return this;
    }

}