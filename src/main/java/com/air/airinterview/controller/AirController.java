package com.air.airinterview.controller;

import com.air.airinterview.dto.AirResponse;
import com.air.airinterview.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/flights")
public class AirController {

    @Autowired
    AirService airService;

    @GetMapping
    public List<AirResponse> getAirResponse(){
        return airService.getResult();
    }
}
