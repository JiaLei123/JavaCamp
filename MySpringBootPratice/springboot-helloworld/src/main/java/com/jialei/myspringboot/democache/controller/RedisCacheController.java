package com.jialei.myspringboot.democache.controller;

import com.jialei.myspringboot.democache.service.RedisRoleService;
import com.jialei.myspringboot.democache.service.RoleService;
import com.jialei.myspringboot.demomybatis.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jialei
 * @version : RoleController.java, v 0.1 2019年11月19日 11:11 上午 jialei Exp $
 */
@Controller
@RequestMapping("rediscache")
public class RedisCacheController {

    @Autowired
    private RedisRoleService redisRoleService;

    @RequestMapping("query/{id}")
    @ResponseBody
    public Role query(@PathVariable("id") int id){
        Role role = redisRoleService.getRolebyId(id);
        return role;
    }

    @RequestMapping("insert")
    @ResponseBody
    public void insert(@RequestParam("id") Integer id, @RequestParam("roleName") String roleName,@RequestParam("roleDesc") String roleDesc){
        redisRoleService.updateRole(new Role(id, roleName, roleDesc));
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Integer id){
        redisRoleService.deleteRole(id);
    }
}