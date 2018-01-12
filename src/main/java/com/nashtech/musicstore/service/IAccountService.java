package com.nashtech.musicstore.service;

import com.nashtech.musicstore.model.Account;

public interface IAccountService extends IGenericService<Account, Integer> {
    Account findByEmail(String email);
}
