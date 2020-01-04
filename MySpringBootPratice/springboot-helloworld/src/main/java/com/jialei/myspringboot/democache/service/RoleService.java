/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.jialei.myspringboot.democache.service;

import com.jialei.myspringboot.MyspringbootApplication;
import com.jialei.myspringboot.demomybatis.Dao.RoleDao;
import com.jialei.myspringboot.demomybatis.model.Role;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    @CachePut(cacheNames = "roles", key = "#result.id")
    public Role updateRole(Role role){
        roleDao.insert(role);
        return role;
    }

    @CacheEvict(value = "roles", key = "#id", beforeInvocation = false)
    public void deleteRole(Integer id){
        logger.info("删除数据 id=" + id);
        roleDao.delete(id);
    }

    /**
     * 复杂的cache
     * @param roleName
     * @return
     */
    @Caching(
            cacheable = {@Cacheable(value = "roles", key = "#roleName")},
            put = {
                    @CachePut(value = "roles", key = "#result.id"),
                    @CachePut(value = "roles", key = "result.roleName")
            }
    )
    public Role findRoleByName(String roleName){
        return roleDao.getById(1);
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