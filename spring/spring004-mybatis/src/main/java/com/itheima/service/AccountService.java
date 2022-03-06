package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.daomain.Account;

import java.util.List;

public interface AccountService {
    void save(AccountDao account);
    void delete (Integer id);
    void  update(Account account);
    List<Account> findAll();
    Account findById(Integer id);
}
