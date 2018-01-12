package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Account;

public interface IAccountDao extends IGenericDao<Account, Integer> {
    Account findByEmail(String email);
}
