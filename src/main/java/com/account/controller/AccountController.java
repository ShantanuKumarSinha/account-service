package com.account.controller;

import com.account.model.Account;
import com.account.model.Customer;
import com.account.service.AccountService;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    private RestTemplate restTemplate;

    private static final String CUSTOMER_URL = "http://customer-service/customer/";

    private static final String CUSTOMER_URL_ALT = "http://localhost:9000/customer/";

    public AccountController(AccountService accountService, RestTemplate restTemplate){
    this.accountService = accountService;
    this.restTemplate = restTemplate;
    }

    @GetMapping("/{accountId}")
    public Account getAccount(@PathVariable Long accountId){
        return accountService.getAccount(accountId);
    }

    @GetMapping("/customer/{customerId}")
    public Account getAccountForCustomerId(@PathVariable Long customerId){
        var customer = restTemplate.getForObject(CUSTOMER_URL_ALT+customerId, Customer.class);
        System.out.println("CUSTOMER_URL "+CUSTOMER_URL_ALT);
        var account = accountService.getAccountForCustomerId(customerId);
        account.setCustomer(customer);
        return account;
    }


}
