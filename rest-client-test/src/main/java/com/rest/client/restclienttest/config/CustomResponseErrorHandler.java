package com.rest.client.restclienttest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

public class CustomResponseErrorHandler implements ResponseErrorHandler {
    final static Logger log = LoggerFactory.getLogger(CustomResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus status = response.getStatusCode();
        return status.is4xxClientError() || status.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String responseAsString = toString(response.getBody());
        log.error("ResponseBody: {}", responseAsString);

        throw new CustomException(responseAsString);
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        String responseAsString = toString(response.getBody());
        log.error("URL: {}, HttpMethod: {}, ResponseBody: {}", url, method, responseAsString);

        throw new CustomException(responseAsString);
    }
    String toString(InputStream inputStream) {
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    static class CustomException extends IOException {
        public CustomException(String message) {
            super(message);
        }
    }
}
