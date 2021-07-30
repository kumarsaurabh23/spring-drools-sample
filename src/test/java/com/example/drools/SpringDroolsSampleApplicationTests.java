package com.example.drools;

import com.example.drools.model.Fare;
import com.example.drools.model.TaxiRide;
import com.example.drools.service.TaxiFareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringDroolsSampleApplicationTests {

	@Autowired
	private TaxiFareService taxiFareService;

	@Test
	public void testDistanceLessThan10AndNoSurcharge() {
		TaxiRide taxiRide = new TaxiRide();
		taxiRide.setIsNightSurcharge(false);
		taxiRide.setDistanceInMile(9L);
		Fare rideFare = new Fare();
		Long totalCharge = taxiFareService.calculateFare(taxiRide, rideFare);

		assertNotNull(totalCharge);
		assertEquals(Long.valueOf(70), totalCharge);
	}

}
