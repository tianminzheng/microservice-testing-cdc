package com.tianyalan.testing.cdc.accounts;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.tianyalan.testing.cdc.accounts.AccountApplication;
import com.tianyalan.testing.cdc.accounts.controller.AccountController;
import com.tianyalan.testing.cdc.accounts.model.Account;
import com.tianyalan.testing.cdc.accounts.repository.AccountRepository;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AccountApplication.class)
public class AccountApplicationTests {

	@Autowired
	private AccountController controller;
	
	@MockBean
	private AccountRepository repository;

	@Before
	public void before() {
		Mockito.when(repository.findAll()).thenReturn(
			 Arrays.asList(new Account(1L, "tianyalan1", "tianmin", "zheng", "tianyalan@email.com"), 
				 new Account(2L, "tianyalan2", "tianmin", "zheng", "tianyalan@email.com")));

		RestAssuredMockMvc.standaloneSetup(this.controller);
	}
}
