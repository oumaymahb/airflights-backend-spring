package com.air.airinterview;

import com.air.airinterview.dto.AirResponse;
import com.air.airinterview.service.AirJazzService;
import com.air.airinterview.service.AirService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sun.tools.jar.CommandLine;

@SpringBootApplication
@Slf4j
public class AirInterviewApplication{
	public static void main(String[] args) {
		SpringApplication.run(AirInterviewApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
