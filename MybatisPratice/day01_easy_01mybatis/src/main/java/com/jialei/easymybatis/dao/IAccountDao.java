/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.dataobject.Account;
import com.jialei.easymybatis.dataobject.AccountUser;

import java.util.List;

/**
 *
 * @author jialei
 * @version : IAccountDao.java, v 0.1 2019年09月10日 11:54 jialei Exp $
 */
public interface IAccountDao {
    List<Account> findAll();

    List<AccountUser> findAllAccountUser();

    List<Account> findAllAccountUser1();
}