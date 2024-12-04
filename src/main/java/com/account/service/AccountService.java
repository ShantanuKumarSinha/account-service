package com.account.service;

import com.account.model.Account;
import org.springframework.stereotype.Service;


public interface AccountService {

    public Account getAccount(Long accountId);

    public Account getAccountForCustomerId(Long customerId);
}
