package com.nashtech.musicstore.service;

import com.nashtech.musicstore.dao.IAccountDao;
import com.nashtech.musicstore.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImp extends GenericServiceImp<Account, Integer> implements IAccountService {

    @Autowired
    IAccountDao accountDao;

    public Account findByEmail(String email) {
        return accountDao.findByEmail(email);
    }
}
