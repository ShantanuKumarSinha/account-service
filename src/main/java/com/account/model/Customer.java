package com.account.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private Long customerId;
    private String customerName;
    private Integer phoneNumber;
    private List<Contact> contacts;
}
