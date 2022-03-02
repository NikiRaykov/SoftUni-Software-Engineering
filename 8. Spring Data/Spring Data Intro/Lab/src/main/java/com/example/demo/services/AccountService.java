package com.example.demo.services;

import com.example.demo.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal balance, Long id);
    void transferMoney(BigDecimal balance, Long id);
}
