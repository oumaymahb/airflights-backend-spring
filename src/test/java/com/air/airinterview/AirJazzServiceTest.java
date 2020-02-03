package com.air.airinterview;


import com.air.airinterview.dto.AirJazz;
import com.air.airinterview.service.AirJazzService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class AirJazzServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AirJazzService airJazzService;

    AirJazzServiceTest(){

    }
    @Test
    public void getALlAirJazzs(){
        AirJazz airJazz=new AirJazz();
        airJazz.setId("b56db499-9f9d-451f-a923-abb6ea697448");
        airJazz.setPrice(498.19);
        airJazz.setATime("5:10 PM");
        airJazz.setDTime("3:40 AM");
        airJazzService=new AirJazzService(restTemplate);
        ResponseEntity<List<AirJazz>> myEntity = new ResponseEntity<List<AirJazz>>(HttpStatus.ACCEPTED);
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", "dd764f40");
        Mockito.when(restTemplate.exchange(
                Matchers.eq("https://my.api.mockaroo.com/air-jazz/flights"),
                Matchers.eq(HttpMethod.GET),
                Matchers.<HttpEntity<List<AirJazz>>>any(),
                Matchers.<ParameterizedTypeReference<List<AirJazz>>>any())
        ).thenReturn(myEntity);
        List<AirJazz> res = airJazzService.getALlAirJazzs();
        Assert.assertEquals(airJazz, res.get(0));
    }
    public static void main(String[] args){
        AirJazzServiceTest airJazzServiceTest=new AirJazzServiceTest();
        airJazzServiceTest.getALlAirJazzs();
    }
}
