package com.jialei.myspringboot.democache.service;

import com.jialei.myspringboot.demomybatis.Dao.RoleDao;
import com.jialei.myspringboot.demomybatis.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "redisRoles", cacheManager = "roleCacheManager")
public class RedisRoleService {
    Logger logger = LoggerFactory.getLogger(com.jialei.myspringboot.democache.service.RoleService.class);

    @Autowired
    private RoleDao roleDao;

    @Cacheable()
    public Role getRolebyId(Integer id) {
        logger.info("查询数据 id=" + id);
        return roleDao.getById(id);
    }

    @CachePut(key = "#result.id")
    public Role updateRole(Role role) {
        roleDao.insert(role);
        return role;
    }

    @CacheEvict(key = "#id", beforeInvocation = true)
    public void deleteRole(Integer id) {
        logger.info("删除数据 id=" + id);
        roleDao.delete(id);
    }
}
