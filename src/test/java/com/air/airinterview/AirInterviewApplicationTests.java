package com.air.airinterview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirInterviewApplicationTests {

	@Test
	void contextLoads() {
		AirJazzServiceTest airJazzServiceTest=new AirJazzServiceTest();
		airJazzServiceTest.getALlAirJazzs();
	}

}
