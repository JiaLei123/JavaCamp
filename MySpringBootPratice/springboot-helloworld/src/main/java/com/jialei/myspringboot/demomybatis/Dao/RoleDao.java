package com.jialei.myspringboot.demomybatis.Dao;

import com.jialei.myspringboot.demomybatis.model.Role;

/**
 *
 * @author jialei
 * @version : RuleDao.java, v 0.1 2019年11月19日 11:04 上午 jialei Exp $
 */

public interface RoleDao {
    Role getById(Integer id);

    void insert(Role role);

    void delete(Integer id);
}