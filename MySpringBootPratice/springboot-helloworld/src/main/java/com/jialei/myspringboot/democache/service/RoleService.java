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

    @Cacheable(cacheNames = "roles1", key = "#id")
    public Role getRolebyId1(Integer id){
        logger.info("查询数据 id=" + id);
        return roleDao.getById(id);
    }

    @Cacheable(cacheNames = "roles2", key = "#root.methodName + '[' + #id +']'")
    public Role getRolebyId2(Integer id){
        logger.info("查询数据 id=" + id);
        return roleDao.getById(id);
    }

    @Cacheable(cacheNames = {"roles3"}, condition = "#id > 1", unless = "#result == null ")
    public Role getRolebyId3(Integer id){
        logger.info("查询数据 id=" + id);
        return roleDao.getById(id);
    }

    @Cacheable(cacheNames = {"roles4"}, keyGenerator = "myKeyGenerator")
    public Role getRolebyId4(Integer id){
        logger.info("查询数据 id=" + id);
        return roleDao.getById(id);
    }


}