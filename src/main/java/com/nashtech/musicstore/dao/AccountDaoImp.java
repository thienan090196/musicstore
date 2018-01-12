package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Account;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("accountDao")
@Transactional
public class AccountDaoImp extends GenericDaoImp<Account, Integer> implements IAccountDao {
    public Account findByEmail(String email) {
        return (Account) currentSession().createCriteria(Account.class).add(Restrictions.eq("email", email)).uniqueResult();
    }
}
