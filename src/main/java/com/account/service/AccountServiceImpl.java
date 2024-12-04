package com.account.service;

import com.account.model.Account;
import com.account.model.Address;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService{

    Address address = Address
            .builder()
            .addressLine1("Sinha Sadan, Ward Number 35")
            .addressLine2("Amghatta Road")
            .addressLine3("Dumra")
            .landmark("Ambey Traders")
            .city("Sitamarhi")
            .state("Bihar")
            .country("India")
            .pin(843301)
            .build();

    List<Account> list = List.of(Account
            .builder()
            .accountId(1234567890L)
            .accountType("Savings Bank")
            .accountOwner("Shantanu Kumar")
            .phoneNumber(9832485878L)
            .dateOfBirth(LocalDate.of(1993, Month.JANUARY,7))
            .customerId(101L)
            .address(address)
            .build());

    @Override
    public Account getAccount(Long accountid) {
        return list
                .stream()
                .filter(account -> Objects.equals(account.getAccountId(), accountid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account getAccountForCustomerId(Long customerId) {
        return list
                .stream()
                .filter(account -> Objects.equals(account.getCustomerId(), customerId))
                .findFirst()
                .orElse(null);
    }
}
