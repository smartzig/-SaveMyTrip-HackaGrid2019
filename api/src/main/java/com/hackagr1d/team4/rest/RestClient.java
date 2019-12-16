package com.hackagr1d.team4.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClient.class);

    private final RestTemplate restTemplate;

    @Autowired
    public RestClient(final RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    private <T> T exchange(
            final String url,
            final Class<T> expectedResponseType,
            final HttpEntity<Object> httpEntity,
            final HttpMethod method) {
        String message = String.format("Doing a %s on url %s", method, url);
        LOGGER.debug(message);
        return restTemplate.exchange(url, method, httpEntity, expectedResponseType).getBody();
    }

    private <T> T sendDataForObject(
            final HttpMethod method,
            final String url,
            final Map<String, String> headerParams,
            final Class<T> expectedResponseType,
            final Object payload) {

        final HttpHeaders headers = createHeaders(headerParams);

        final HttpEntity<Object> httpEntity = new HttpEntity<>(payload, headers);
        return exchange(url, expectedResponseType, httpEntity, method);
    }

    public <T> T postForObject(
            final String url,
            final Map<String, String> headerParams,
            final Class<T> expectedResponseType,
            final Object payload) {
        return sendDataForObject(HttpMethod.POST, url, headerParams, expectedResponseType, payload);
    }



    private HttpHeaders createHeaders(final Map<String, String> headerParams) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setAll(headerParams);
        return headers;
    }
}
