/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.democache.service;

import com.jialei.myspringboot.MyspringbootApplication;
import com.jialei.myspringboot.demomybatis.Dao.RoleDao;
import com.jialei.myspringboot.demomybatis.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author jialei
 * @version : RoleService.java, v 0.1 2019年12月16日 2:23 下午 jialei Exp $
 */
@Service
public class RoleService {
    Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleDao roleDao;


    @Cacheable(cacheNames = "roles")
    public Role getRolebyId(Integer id){
        logger.info("查询数据 id=" + id);
        return roleDao.getById(id);
    }
}