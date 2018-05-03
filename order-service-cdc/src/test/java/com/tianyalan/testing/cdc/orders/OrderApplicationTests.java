package com.tianyalan.testing.cdc.orders;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.tianyalan.testing.cdc.orders.OrderApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(ids = { "com.tianyalan.testing.cdc:account-service-cdc:+:8080" }, workOffline = true)
public class OrderApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testGetAccounts() {
		ParameterizedTypeReference<AccountData> ptf = new ParameterizedTypeReference<AccountData>() {
		};
		
		ResponseEntity<AccountData> responseEntity = restTemplate.exchange("http://localhost:8080/api/accounts/v1",
				HttpMethod.GET, null, ptf);
		
		Assert.assertEquals(2, responseEntity.getBody().getData().size());
	}
}
