package com.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    private Long accountId;
    private String accountOwner;
    private String accountType;
    private LocalDate dateOfBirth;
    private Long customerId;
    private Address address;
    private Long phoneNumber;
    private Customer customer;
}
