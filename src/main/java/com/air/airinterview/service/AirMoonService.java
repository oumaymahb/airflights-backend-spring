package com.air.airinterview.service;

import com.air.airinterview.dto.AirMoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AirMoonService {

    private final String URL_MOON="https://my.api.mockaroo.com/air-moon/flights";

    private final String KEY="dd764f40";

    @Autowired
    RestTemplate restTemplate;

    public List<AirMoon> getAllAirMoon(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", KEY);
        List<AirMoon> response = Arrays.asList(restTemplate.exchange(URL_MOON, HttpMethod.GET, new HttpEntity(headers), AirMoon[].class).getBody());
        return response;
    }
}
