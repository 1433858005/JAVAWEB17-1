package com.itheima.dao;

import com.itheima.daomain.Account;

import java.util.List;

public interface AccountDao {
    void save(AccountDao account);
    void delete (Integer id);
    void  update(Account account);
    List<Account> findAll();
    Account findById(Integer id);
}
