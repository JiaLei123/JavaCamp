/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.dao;

import com.jialei.myspringboot.model.Role;

/**
 *
 * @author jialei
 * @version : RuleDao.java, v 0.1 2019年11月19日 11:04 上午 jialei Exp $
 */
public interface RoleDao {
    Role getById(Integer id);

    void insert(Role role);
}