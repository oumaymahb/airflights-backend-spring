package com.air.airinterview.service;

import com.air.airinterview.dto.AirBeam;
import com.air.airinterview.dto.AirJazz;
import com.air.airinterview.dto.AirMoon;
import com.air.airinterview.dto.AirResponse;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class AirJazzService {

    private final String URL_JAZZ="https://my.api.mockaroo.com/air-jazz/flights";

    private final String KEY="dd764f40";

    @Autowired
    RestTemplate restTemplate;

    public AirJazzService(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    public List<AirJazz> getALlAirJazzs(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", KEY);
        List<AirJazz> response = Arrays.asList(restTemplate.exchange(URL_JAZZ, HttpMethod.GET, new HttpEntity(headers), AirJazz[].class).getBody());
        return response;
    }
}
