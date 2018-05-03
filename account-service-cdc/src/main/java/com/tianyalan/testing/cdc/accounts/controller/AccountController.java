package com.tianyalan.testing.cdc.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tianyalan.testing.cdc.accounts.model.AccountData;
import com.tianyalan.testing.cdc.accounts.repository.AccountRepository;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository repository;

    @RequestMapping(path = "/api/accounts/v1")
    public AccountData getCustomers() {
        AccountData data = new AccountData();
        data.setData(repository.findAll());
        return data;
    }
}