package com.air.airinterview.service;

import com.air.airinterview.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirService {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("h:m a");

    @Autowired
    AirJazzService airJazzService;

    @Autowired
    AirMoonService airMoonService;

    @Autowired
    AirBeamService airBeamService;

    public List<AirResponse> getResult(){
        List<AirJazz> airJazzes=airJazzService.getALlAirJazzs();
        List<AirMoon> airMoons=airMoonService.getAllAirMoon();
        List<AirBeam> airBeams=airBeamService.getAllAirBeam();
        List<AirResponse> airResponses=new ArrayList<>();
        airJazzes.forEach((item)->{
            AirResponse airResponse=new AirResponse();
            airResponse.setProvider(Provider.AIR_JAZZ);
            airResponse.setPrice(item.getPrice());
            airResponse.setDepartureTime(LocalTime.parse(item.getDTime(), dateFormat));
            airResponse.setArrivalTime(LocalTime.parse(item.getATime(), dateFormat));
            airResponses.add(airResponse);
        });
        airMoons.forEach((item)->{
            AirResponse airResponse=new AirResponse();
            airResponse.setProvider(Provider.AIR_MOON);
            airResponse.setPrice(item.getPrice());
            airResponse.setDepartureTime(LocalTime.parse(item.getDepartureTime(), dateFormat));
            airResponse.setArrivalTime(LocalTime.parse(item.getArrivalTime(), dateFormat));
            airResponses.add(airResponse);
        });
        airBeams.forEach((item)->{
            AirResponse airResponse=new AirResponse();
            airResponse.setProvider(Provider.AIR_BEAM);
            airResponse.setPrice(item.getP());
            airResponse.setDepartureTime(LocalTime.parse(item.getDeparture(), dateFormat));
            airResponse.setArrivalTime(LocalTime.parse(item.getArrival(), dateFormat));
            airResponses.add(airResponse);
        });
        return  airResponses.stream()
                .sorted(Comparator.comparingDouble(AirResponse::getPrice))
                .limit(50)
                .collect(Collectors.toList());

    }
}
