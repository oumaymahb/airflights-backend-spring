package com.air.airinterview.service;

import com.air.airinterview.dto.AirBeam;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class AirBeamService {

    private final String URL_BEAM="https://my.api.mockaroo.com/air-beam/flights";

    private final String KEY="dd764f40";

    @Autowired
    RestTemplate restTemplate;

    public List<AirBeam> getAllAirBeam(){
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-API-Key", KEY);
            MappingIterator<AirBeam> airBeams = mapper.reader(AirBeam.class).with(bootstrapSchema).readValues(  restTemplate.exchange(URL_BEAM, HttpMethod.GET, new HttpEntity(headers), String.class).getBody());
            return  airBeams.readAll();
        }
        catch (Exception e) {
            System.out.println("Error occurred while loading object list from file " +e.getMessage());
        }
        return null;
    }
}
