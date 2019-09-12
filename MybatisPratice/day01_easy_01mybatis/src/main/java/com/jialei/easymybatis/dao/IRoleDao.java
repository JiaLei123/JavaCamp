/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.easymybatis.dao;

import com.jialei.easymybatis.dataobject.Role;

import java.util.List;

/**
 *
 * @author jialei
 * @version : IRoleDao.java, v 0.1 2019年09月11日 16:02 jialei Exp $
 */
public interface IRoleDao {
    List<Role> findAll();
}